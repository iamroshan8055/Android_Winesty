package com.example.roshantirthyash_groupproj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.File;

public class Fragment_Register extends Fragment {

    private static final int RESULT_OK = -1;
    private static int RESULT_LOAD_IMAGE = -1;
    private static final int CAMERA_REQUEST = 123;
    private static final int GALLERY_REQUEST_CODE = 100;
    Bitmap image;
    ImageView profile_pic;
    FloatingActionButton add_profile;
    Button btnRegister;
    EditText uPass, uConf_pass, uEmail, uUsername;
    String uPassTxt, uConf_passTxt, uEmailTxt, uUsernameTxt;
//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;
    private static final String TAG = "Fragment_Register";

    FirebaseAuth mAuth;

//    @Override
//    public void onAttach(@NonNull Context context) {
//        sharedPreferences = context.getSharedPreferences("usersfile",Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        super.onAttach(context);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        profile_pic = v.findViewById(R.id.profile_image);
        add_profile = v.findViewById(R.id.add_profile_pic);


        add_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent cameraIntent = new Intent (Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(cameraIntent, RESULT_LOAD_IMAGE);

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
//
//                Intent intent=new Intent(Intent.ACTION_PICK);
//                // Sets the type as image/*. This ensures only components of type image are selected
//                intent.setType("image/*");
//                //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
//                String[] mimeTypes = {"image/jpeg", "image/png"};
//                intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
//                // Launching the Intent
//                startActivityForResult(intent,GALLERY_REQUEST_CODE);

//                https://jitpack.io/p/bkhezry/android-image-picker
//                ImagePicker.with(getActivity())
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .cropOval()	    		//Allow dimmed layer to have a circle inside
//                        .cropFreeStyle()	    //Let the user to resize crop bounds
//                        .galleryOnly()          //We have to define what image provider we want to use
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
//                        .createIntent()
//                        .start();
            }
        });

        final ImageView uProfile = v.findViewById(R.id.profile_image);
        final EditText uEmail = v.findViewById(R.id.reg_email);
        final EditText uUsername = v.findViewById(R.id.reg_username);
        final EditText uPass = v.findViewById(R.id.reg_password);
        uConf_pass = v.findViewById(R.id.reg_confirm_password);

        DAO_Users dao = new DAO_Users();

        mAuth=FirebaseAuth.getInstance();

        btnRegister = v.findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                uEmailTxt = uEmail.getText().toString();
                uUsernameTxt = uUsername.getText().toString();
                uPassTxt = uPass.getText().toString();
                uConf_passTxt = uConf_pass.getText().toString();

//                editor.putString("username",uEmailTxt);
//                editor.putString("username",uUsernameTxt);
//                editor.putString("username",uPassTxt);
//                editor.apply();

                if (uEmailTxt.isEmpty()){
                    uEmail.setError("Email field should not be empty");
                    uEmail.requestFocus();
                } else if (!uEmailTxt.contains("@conestogac.on.ca") && !uEmailTxt.contains("@yahoo.in") && !uEmailTxt.contains("@gmail.com") && !uEmailTxt.contains("@yahoo.com")){
                    uEmail.setError("Invalid Email");
                    uEmail.requestFocus();
                } else if (uUsernameTxt.isEmpty()){
                    uUsername.setError("Username field should not be empty");
                    uUsername.requestFocus();
                } else if (uPassTxt.isEmpty()){
                    uPass.setError("Password field should not be empty");
                    uPass.requestFocus();
                } else if (uConf_passTxt.isEmpty()){
                    uConf_pass.setError("Confirm password field should not be empty");
                    uConf_pass.requestFocus();
                } else if (!uPassTxt.equals(uConf_passTxt)){
                    uConf_pass.setError("Password dose not match with confirm password");
                    uConf_pass.requestFocus();
                }else {
//                    Toast.makeText(getContext(), "Registered Successfully!", Toast.LENGTH_SHORT).show();

                    mAuth.createUserWithEmailAndPassword(uEmailTxt,uPassTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getContext(),"You are successfully Registered", Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(getContext(), LoginActivity.class);
                                startActivity(myIntent);
                            }
                            else
                            {
                                Toast.makeText(getContext(),"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

//                    Users u = new Users(uUsernameTxt,uEmailTxt,uPassTxt);
//                    dao.add(u).addOnSuccessListener(suc->{
//                        Toast.makeText(getContext(),"Record is inserted",Toast.LENGTH_SHORT).show();
//                    }).addOnFailureListener(er->{
//                        Toast.makeText(getContext(),"error : "+er.getMessage(),Toast.LENGTH_SHORT).show();
//                    });

//                    Intent myIntent = new Intent(getContext(), LoginActivity.class);
//                    startActivity(myIntent);
                }



//                Users u = new Users(uUsernameTxt,uEmailTxt,uPassTxt);
//                dao.add(u).addOnSuccessListener(suc->{
//                    Toast.makeText(getContext(),"Record is inserted",Toast.LENGTH_SHORT).show();
//                }).addOnFailureListener(er->{
//                    Toast.makeText(getContext(),"error : "+er.getMessage(),Toast.LENGTH_SHORT).show();
//                });

//                Intent myIntent = new Intent(getContext(), LoginActivity.class);
//                startActivity(myIntent);


            }
        });
        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            profile_pic.setImageBitmap(photo);
        }
    }

//    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

//    Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


//    public void onActivityResult(int requestCode,int resultCode,Intent data){
//        // Result code is RESULT_OK only if the user selects an Image
//        if (resultCode == Activity.RESULT_OK)
//            switch (requestCode){
//                case GALLERY_REQUEST_CODE:
//                    //data.getData returns the content URI for the selected Image
//                    Uri selectedImage = data.getData();
//                    profile_pic.setImageURI(selectedImage);
//                    break;
//                case CAMERA_REQUEST:
//                    Bitmap photo = (Bitmap) data.getExtras().get("data");
//                    profile_pic.setImageBitmap(photo);
//            }
//    }


//    public void onActivityResult(int requestCode,int resultCode,Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        // Result code is RESULT_OK only if the user selects an Image
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data){
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = this.getActivity().getContentResolver().query(selectedImage,filePathColumn,null,null,null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            Log.e(TAG, "picture path -- "+picturePath);
//            Glide.with(this.getActivity()).load(new File(picturePath)).into(profile_pic);
//        }
//
//    }


}
