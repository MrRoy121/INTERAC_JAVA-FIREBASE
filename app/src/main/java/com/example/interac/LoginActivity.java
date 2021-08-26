package com.example.interac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.interac.utils.EmailValidation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.interac.utils.EmailValidation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUserName234, editTextPassword123;

    FirebaseAuth fa = FirebaseAuth.getInstance();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    CheckBox ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_login);
        ch = findViewById(R.id.checkBox);


        editTextPassword123 = (EditText) findViewById(R.id.editTextPassword123);
        editTextUserName234 = (EditText) findViewById(R.id.editTextUserName234);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                if (validate()) {
                    fs.collection("User").document(editTextUserName234.getText().toString()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot d) {
                            if(d.exists()){
                                fa.signInWithEmailAndPassword(Objects.requireNonNull(d.getString("email")), editTextPassword123.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            if(ch.isChecked()) {
                                                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                                                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                                                myEdit.putString("email", d.getString("email"));
                                                myEdit.putString("username", d.getString("username"));
                                                myEdit.apply();
                                            }
                                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                            finish();
                                            Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                                            startActivity(i);


                                        } else {
                                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }else{
                                Toast.makeText(getApplicationContext(), "Username Doesn't Exists Try Again!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                Intent i = new Intent(LoginActivity.this, Reset1Activity.class);
                startActivity(i);

            }
        });
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);

            }
        });
    }

    public boolean validate() {
        boolean flag = true;
        if (editTextPassword123.getText().toString().trim().length() == 0) {

            flag = false;
            Toast.makeText(getApplicationContext(), "Password Required", Toast.LENGTH_SHORT).show();
            return flag;

        }

        if (editTextUserName234.getText().toString().trim().length() == 0) {

            flag = false;
            Toast.makeText(getApplicationContext(), "Email ID Required", Toast.LENGTH_SHORT).show();
            return flag;
        }
//        if(!EmailValidation.isValid(editTextUserName234.getText().toString().trim())){
//
//            flag = false;
//            System.out.println("Email ID not valid");
//            Toast.makeText(getApplicationContext(), "Email ID Required", Toast.LENGTH_SHORT).show();
//            return flag;
//
//        }


        return flag;
    }

}