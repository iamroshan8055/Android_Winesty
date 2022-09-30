package com.example.roshantirthyash_groupproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class Fragment_Login extends Fragment {

    Button btnLogin;

    EditText uPass,uEmail;
    String uPassTxt,uEmailTxt;

    FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        uEmail = v.findViewById(R.id.log_username);
        uPass = v.findViewById(R.id.log_password);

        mAuth=FirebaseAuth.getInstance();

        btnLogin = v.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                uEmailTxt = uEmail.getText().toString();
                uPassTxt = uPass.getText().toString();

                if (uEmailTxt.isEmpty()){
                    uEmail.setError("Username field should not be empty");
                    uEmail.requestFocus();
                }  else if (!uEmailTxt.contains("@conestogac.on.ca") && !uEmailTxt.contains("@yahoo.in") && !uEmailTxt.contains("@gmail.com") && !uEmailTxt.contains("@yahoo.com")) {
                    uEmail.setError("Invalid Email");
                    uEmail.requestFocus();
                } else if (uPassTxt.isEmpty()){
                    uPass.setError("Password field should not be empty");
                    uPass.requestFocus();
                } else {

                    mAuth.signInWithEmailAndPassword(uEmailTxt,uPassTxt).addOnCompleteListener(task -> {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getContext(), "Successfully Logged in!", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(getContext(), MainActivity.class);
                            startActivity(myIntent);
                        }
                        else
                        {
                            Toast.makeText(getContext(),
                                    "Please Check Your login Credentials",
                                    Toast.LENGTH_SHORT).show();
                        }

                    });

//                    Intent myIntent = new Intent(getContext(), MainActivity.class);
//                    startActivity(myIntent);
                }

            }
        });
        return v;
    }
}
