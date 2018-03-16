package com.example.brayandavid.homemedicines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.brayandavid.homemedicines.Conection.TaskChangePassword;
import com.example.brayandavid.homemedicines.Objects.LoginChangePassword;

import java.util.concurrent.ExecutionException;

public class PasswordChange extends AppCompatActivity {
    private EditText txtEmail;
    private EditText oldPassword;
    private EditText newPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        txtEmail = (EditText) findViewById(R.id.txtemail_ch_p);
        oldPassword = (EditText) findViewById(R.id.txt_old_password);
        newPassword = (EditText) findViewById(R.id.txtnewpassw);
    }
    public void btnchange_P(View v){
        TaskChangePassword logenTask = new TaskChangePassword();
        LoginChangePassword changePassword = new LoginChangePassword();
        changePassword.setOldPassword((oldPassword.getText().toString()));
        changePassword.setNewPassword((newPassword.getText().toString()));
        changePassword.setUser(txtEmail.getText().toString());


        try {
            String  resul = logenTask.execute(changePassword).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int code = TaskChangePassword.getCode();
        if (code == 200 || code == 201) {
            Intent i = new Intent(this, LoginUser.class);
            startActivity(i);
        }else{
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
