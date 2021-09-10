package com.example.interac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Reset1Activity extends AppCompatActivity {

    ProgressBar loadingBar;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reset1);
        loadingBar = findViewById(R.id.pbar);

        Button buttonCont514=(Button) findViewById(R.id.buttonCont514);
        buttonCont514.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Reset1Activity.this,Reset2.class);
                startActivity(i);
            }

        });

        EditText emailet= findViewById(R.id.editTextTextEsid514);

        findViewById(R.id.buttonCont514).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailet.getText().toString().trim();
                beginRecovery(email);
            }
        });

    }

    private void beginRecovery(String email) {

        loadingBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                loadingBar.setVisibility(View.INVISIBLE);
                if(task.isSuccessful())
                {
                    Toast.makeText(Reset1Activity.this,"Email with details is sent",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Reset1Activity.this,"Error Occurred",Toast.LENGTH_LONG).show();
                }
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Reset1Activity.this,"Error Failed",Toast.LENGTH_LONG).show();
            }
        });
    }

}
