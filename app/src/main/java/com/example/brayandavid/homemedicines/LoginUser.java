package com.example.brayandavid.homemedicines;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskLogin;
import com.example.brayandavid.homemedicines.View.ServicesListActivity;

import java.util.concurrent.ExecutionException;

public class LoginUser extends AppCompatActivity {
    private EditText txtEmailLogin;
    private EditText txtPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        txtEmailLogin = (EditText) findViewById(R.id.txt_email_login);
        txtPasswordLogin = (EditText) findViewById(R.id.txt_pass_login);

    }

    public void btn_Login_Click(View v) {

        final ProgressDialog progressDialog = ProgressDialog.show(LoginUser.this, "Espera", "Procesando", true);
        TaskLogin logenTask = new TaskLogin();
        Toast.makeText(this,"Triunfando papa", Toast.LENGTH_SHORT);
        Login login = new Login();
        login.setPassword((txtPasswordLogin.getText().toString()));
        login.setUser(txtEmailLogin.getText().toString());

        try {
           String resul = logenTask.execute(login).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int code = TaskLogin.getCode();
        if (code==200){
        Intent i = new Intent(LoginUser.this, ServicesListActivity.class);
        startActivity(i);}
    }


}

