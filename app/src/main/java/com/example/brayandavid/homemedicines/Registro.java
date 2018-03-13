package com.example.brayandavid.homemedicines;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtEmail = (EditText) findViewById(R.id.txt_email_registro);
        txtPassword = (EditText) findViewById(R.id.txt_pass_registro);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void btn_Registro_Click(View v){

       final ProgressDialog progressDialog = ProgressDialog.show(Registro.this, "Espera","Processing",true);
       firebaseAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               progressDialog.dismiss();

               if (task.isSuccessful()){
                   Toast.makeText(Registro.this, "REGISTRADO CON EL EMAIL :" + txtEmail.getText(), Toast.LENGTH_LONG).show();
                   Intent i = new Intent(Registro.this, MainActivity.class);
                   startActivity(i);

               }
               else {
                   Log.e("ERROR",task.getException().toString());
                   Toast.makeText(Registro.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

               }
           }
       });

    }
}