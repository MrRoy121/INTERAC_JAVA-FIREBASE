package com.example.interac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    SharedPreferences sharedPreferences;
    FirebaseAuth fa = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        ImageView imageViewAboutUs=(ImageView) findViewById(R.id.imageViewAboutus);
        imageViewAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, AboutUsActivity.class);
                startActivity(i);
            }
        });
        ImageView imageView5AcadCal=(ImageView) findViewById(R.id.imageView5AcadCal);
        imageView5AcadCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, AcademicCalendar.class);
                startActivity(i);
            }
        });
        
        ImageView imageViewCampRes=(ImageView) findViewById(R.id.imageViewCampRes);
        imageViewCampRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, CampusResourcesActivity.class);
                startActivity(i);
            }
        });

        ImageView imageViewConPpl=(ImageView) findViewById(R.id.imageViewConPpl);
        imageViewConPpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, ConnectPeople.class);
                startActivity(i);
            }

        });
        ImageView imageView8FC=(ImageView) findViewById(R.id.imageView8FC);
        imageView8FC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, HangoutsActivity.class);
                startActivity(i);
            }

        });

        ImageView imageViewEvents=(ImageView) findViewById(R.id.imageViewEvents);
        imageViewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, EventsActivity.class);
                startActivity(i);
            }

        });


        ImageView imageView18Org514=(ImageView) findViewById(R.id.imageView18Org514);
        imageView18Org514.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, OrganizationActivity.class);

                startActivity(i);
            }

        });
        ImageView imageView19Snap514=(ImageView) findViewById(R.id.imageView19Snap514);
        imageView19Snap514.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, SnapshotsActivity.class);

                startActivity(i);
            }

        });

        ImageView menu=(ImageView) findViewById(R.id.imgdashboardmenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }

        });
        drawerLayout = findViewById(R.id.my_drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.usname);
        navigationView.setNavigationItemSelectedListener(this);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        navUsername.setText(sharedPreferences.getString("username", " "));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            fa.signOut();
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("email", " ");
            myEdit.putString("username", " ");
            myEdit.putString("pass", " ");
            myEdit.apply();
            finish();
            Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.logout) {
//            fa.signOut();
//            SharedPreferences.Editor myEdit = sharedPreferences.edit();
//            myEdit.putString("email", " ");
//            myEdit.putString("username", " ");
//            myEdit.putString("pass", " ");
//            myEdit.apply();
//            finish();
//            Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
//            startActivity(i);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            fa.signOut();
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("email", " ");
            myEdit.putString("username", " ");
            myEdit.putString("pass", " ");
            myEdit.apply();
            finish();
            Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(i);
            return true;
        }
        return true;
    }
}
