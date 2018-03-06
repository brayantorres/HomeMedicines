package com.example.brayandavid.homemedicines;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

        public void btnRegistroClick(View v){
            Intent i = new Intent(MainActivity.this, Registro.class);
            startActivity(i);
    }



    public void btnLoginClick(View v){
        Intent i = new Intent(MainActivity.this, LoginUser.class);
        startActivity(i);
    }

    }




