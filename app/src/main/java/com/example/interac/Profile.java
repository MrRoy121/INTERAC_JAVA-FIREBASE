package com.example.interac;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.interac.utils.EmailValidation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Profile extends AppCompatActivity {

    RadioButton genderradioButton;
    RadioGroup radioGroup;
    EditText name, nname, about, phone, email, descrip;
    String sname, snname, sabout, sphone, semail, sdescrip;

    Button b;
    FirebaseAuth fa = FirebaseAuth.getInstance();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        name = findViewById(R.id.name);
        nname = findViewById(R.id.nname);
        about = findViewById(R.id.about);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        descrip = findViewById(R.id.descri);
        b = findViewById(R.id.button23);

        fs.collection("Profile").document(fa.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot d) {
                if(d.exists()){
                    name.setText(d.getString("Name"));
                    nname.setText(d.getString("Nickname"));
                    about.setText(d.getString("About Me"));
                    phone.setText(d.getString("Phone"));
                    email.setText(d.getString("Email"));
                    descrip.setText(d.getString("Description"));
                }
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderradioButton = (RadioButton) findViewById(selectedId);
                sname = name.getText().toString();
                snname = nname.getText().toString();
                sabout = about.getText().toString();
                sphone = phone.getText().toString();
                semail = email.getText().toString();
                sdescrip = descrip.getText().toString();
                if(sname.length()==0||snname.length()==0||sabout.length()==0||selectedId == -1||sphone.length()==0||semail.length()==0||sdescrip.length()==0){
                    Toast.makeText(Profile.this, "All Fields Are Required!!", Toast.LENGTH_SHORT).show();
                }else  if(!EmailValidation.isValid(email.getText().toString().trim())){
                    System.out.println("Email ID not valid");
                    Toast.makeText(getApplicationContext(), "Email ID Required", Toast.LENGTH_SHORT).show();
                }else{

                    Map<String, String> user = new HashMap<>();
                    user.put("Name", sname);
                    user.put("Nickname", snname);
                    user.put("About Me", sabout);
                    user.put("Phone", sphone);
                    user.put("Email", semail);
                    user.put("Description", sdescrip);
                    user.put("Gender", genderradioButton.getText().toString());
                    SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    sh.edit().putBoolean("profile", true).apply();
                    sh.edit().putString("name", sname + " " + snname).apply();

                    fs.collection("Profile").document(fa.getCurrentUser().getUid()).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            finish();
                            Toast.makeText(Profile.this, "Profile Data Added Successfully!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

    }
}
