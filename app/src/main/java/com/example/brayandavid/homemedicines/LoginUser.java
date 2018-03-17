package com.example.brayandavid.homemedicines;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.brayandavid.homemedicines.Conection.TaskLogin;
import com.example.brayandavid.homemedicines.Objects.Login;
import com.example.brayandavid.homemedicines.View.ServicesListActivity;

import org.json.JSONException;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarlogin);
        setSupportActionBar(toolbar);
    }

    public void btn_Login_Click(View v) throws JSONException {
        TaskLogin logenTask = new TaskLogin();
        Login login = new Login();
        login.setPassword((txtPasswordLogin.getText().toString()));
        login.setUser(txtEmailLogin.getText().toString());
        Intent i = new Intent(LoginUser.this, PasswordChange.class);
        startActivity(i);
        try {
            String  resul = logenTask.execute(login).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int code = TaskLogin.getCode();
        if (code == 200) {
            Intent h = new Intent(LoginUser.this, ServicesListActivity.class);

            startActivity(h);
        }
        if (code == 406) {
            Intent j = new Intent(LoginUser.this, PasswordChange.class);

            startActivity(j);
        }

    }

}

