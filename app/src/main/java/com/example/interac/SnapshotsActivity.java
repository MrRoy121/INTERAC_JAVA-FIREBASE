package com.example.interac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.interac.kits.imageModel;
import com.example.interac.kits.uploadImageAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class SnapshotsActivity extends AppCompatActivity {
ImageView imageView8765;

    RecyclerView recyclerView;
    List<imageModel> list = new ArrayList<>();
    uploadImageAdapter arr;

    FirebaseAuth fa = FirebaseAuth.getInstance();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_snapshots);

        fs.collection("Profile").document(fa.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    sh.edit().putBoolean("profile", true).apply();
                }else{
                    SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    sh.edit().putBoolean("profile", false).apply();
                  //  Log.e("Snap", documentSnapshot.getString("Name"));
                    sh.edit().putString("name", documentSnapshot.getString("Name") + " " + documentSnapshot.getString("Nickname")).apply();

                }
            }
        });
       // imageView8765=(ImageView) findViewById(R.id.imageView8765);


//        imageView8765.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SnapshotsActivity.this, DashboardActivity.class);
//                startActivity(i);
//            }
//        });
//
        ImageView imageUpload = (ImageView) findViewById(R.id.upload);

        imageUpload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnapshotsActivity.this, WritePost.class);
                startActivity(i);
            }
        });

        ImageView imageProfile = (ImageView) findViewById(R.id.profile);

        imageProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnapshotsActivity.this, Profile.class);
                startActivity(i);
            }
        });

        FirebaseStorage storage = FirebaseStorage.getInstance();
        SwipeRefreshLayout swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.sr);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                finish();
                startActivity(getIntent());
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SnapshotsActivity.this));
        arr = new uploadImageAdapter(SnapshotsActivity.this, list);
        recyclerView.setAdapter(arr);
        StorageReference listRef = storage.getReference().child("All_Image_Uploads/");
        listRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()) {
                    item.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
                        @Override
                        public void onSuccess(StorageMetadata storageMetadata) {
                            Log.e("Ne", String.valueOf(storageMetadata));
                            Log.e("Ne", String.valueOf(storageMetadata.getCustomMetadata("name")));
                            item.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            list.add(new imageModel(uri.toString(),storageMetadata.getCustomMetadata("name")));
                            arr.notifyDataSetChanged();
                        }
                    });
                        }
                    });
//
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Error", e.getMessage().toString());
                    }
                });


    }
}
