package com.example.interac;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;


    FirebaseAuth fa = FirebaseAuth.getInstance();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageViewInterac514);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(fa.getCurrentUser() != null){
                    fs.collection("User").document(fa.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot d) {
                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                            finish();

                        }
                    });
                }else{
                    Intent i= new Intent(MainActivity.this,LaunchScreen.class);
                    startActivity(i); //start new activity
                    finish();
                }
            }
        }, 2000); //time in milliseconds

    }
}

