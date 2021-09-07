package com.example.interac;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MyProfileActivity extends AppCompatActivity {

    TextView name, nname, about, phone, email, descrip, gender;
    final int MIN_PASSWORD_LENGTH = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        viewInitializations();
    }

    void viewInitializations() {
//        etFirstName = findViewById(R.id.et_first_name);
//        etLastName = findViewById(R.id.et_last_name);
//        etEmail = findViewById(R.id.et_email);
//        etContactNo = findViewById(R.id.et_contact_no);
//        etDec = findViewById(R.id.et_des);

        // To show back button in actionbar
        name = findViewById(R.id.name);
        nname = findViewById(R.id.nname);
        about = findViewById(R.id.about);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        descrip = findViewById(R.id.descri);
        gender = findViewById(R.id.gender);

        FirebaseFirestore.getInstance().collection("Profile").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot d) {
                if(d.exists()){
                    name.setText(d.getString("Name"));
                    nname.setText(d.getString("Nickname"));
                    about.setText(d.getString("About Me"));
                    phone.setText(d.getString("Phone"));
                    email.setText(d.getString("Email"));
                    descrip.setText(d.getString("Description"));
                    gender.setText(d.getString("Gender"));
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
//
//    // Checking if the input in form is valid
//    boolean validateInput() {
//        if (etFirstName.getText().toString().equals("")) {
//            etFirstName.setError("Please Enter First Name");
//            return false;
//        }
//        if (etLastName.getText().toString().equals("")) {
//            etLastName.setError("Please Enter Last Name");
//            return false;
//        }
//        if (etEmail.getText().toString().equals("")) {
//            etEmail.setError("Please Enter Email");
//            return false;
//        }
//        if (etContactNo.getText().toString().equals("")) {
//            etContactNo.setError("Please Enter Contact No");
//            return false;
//        }
//        if (etDec.getText().toString().equals("")) {
//            etDec.setError("Please Enter Designation ");
//            return false;
//        }
//
//        // checking the proper email format
//        if (!isEmailValid(etEmail.getText().toString())) {
//            etEmail.setError("Please Enter Valid Email");
//            return false;
//        }
//
//        return true;
//    }
//
//    boolean isEmailValid(String email) {
//        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
//    }
//
//    // Hook Click Event
//
//    public void performEditProfile (View v) {
//        if (validateInput()) {
//
//            // Input is valid, here send data to your server
//
//            String firstName = etFirstName.getText().toString();
//            String lastName = etLastName.getText().toString();
//            String email = etEmail.getText().toString();
//            String contactNo = etContactNo.getText().toString();
//            String Designation = etDec.getText().toString();
//
//            Toast.makeText(this,"Profile Update Successfully",Toast.LENGTH_SHORT).show();
//            // Here you can call you API
//
//        }
//    }

}