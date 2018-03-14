package com.example.brayandavid.homemedicines;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtEmail = (EditText) findViewById(R.id.txt_email_registro);
        txtPassword = (EditText) findViewById(R.id.txt_pass_registro);


    }

    public void btn_Registro_Click(View v){

       final ProgressDialog progressDialog = ProgressDialog.show(Registro.this, "Espera","Processing",true);
               progressDialog.dismiss();


    }
}
