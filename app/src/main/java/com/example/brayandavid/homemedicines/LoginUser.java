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

public class LoginUser extends AppCompatActivity {
    private EditText txtEmailLogin;
    private EditText txtPasswordLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        txtEmailLogin = (EditText) findViewById(R.id.txt_email_login);
        txtPasswordLogin = (EditText) findViewById(R.id.txt_pass_login);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void btn_Login_Click (View v){
        final ProgressDialog progressDialog = ProgressDialog.show(LoginUser.this, "Espera","Procesando",true);
        firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(), txtPasswordLogin.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()){
                    Toast.makeText(LoginUser.this, "LOGIN EXITOSO", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginUser.this, ProfileActivity.class);
                    i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);

                }
                else {
                    Log.e("ERROR",task.getException().toString());

                    Toast.makeText(LoginUser.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();


                }
            }
        });



    }
}
