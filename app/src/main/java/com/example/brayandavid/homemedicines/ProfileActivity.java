package com.example.brayandavid.homemedicines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
     TextView TextViewEmail_Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextViewEmail_Profile = findViewById(R.id.tv_email_profile);
        TextViewEmail_Profile.setText(getIntent().getExtras().getString("Email"));
    }
}
