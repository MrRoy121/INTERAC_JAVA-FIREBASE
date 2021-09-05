package com.example.interac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SpecialEventActivity extends AppCompatActivity {

    TextView t2, t3, t4, t5, t6, t7, t8;
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_event);

        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);

        fs.collection("Others").document("SPECIAL EVENTS").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot d) {
                if(d.exists()){
                    t8.setText(d.getString("Applicable Fees"));
                    t2.setText(d.getString("details"));
                    t4.setText(d.getString("Services provided"));
                    t6.setText(d.getString("Non-University Event Fees"));
                }
            }
        });

    }
}
