package com.example.roshantirthyash_groupproj;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO_Users {

    private DatabaseReference databaseReference;
    public DAO_Users(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Users.class.getSimpleName());
    }

    public Task<Void> add(Users u){
        return databaseReference.push().setValue(u);
    }
}
