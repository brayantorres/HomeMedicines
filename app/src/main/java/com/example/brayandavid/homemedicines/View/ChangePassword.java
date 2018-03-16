package com.example.brayandavid.homemedicines.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.brayandavid.homemedicines.Conection.TaskChangePassword;
import com.example.brayandavid.homemedicines.Conection.TaskLogin;
import com.example.brayandavid.homemedicines.LoginUser;
import com.example.brayandavid.homemedicines.Objects.LoginChangePassword;
import com.example.brayandavid.homemedicines.R;
import com.example.brayandavid.homemedicines.Security;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ChangePassword extends AppCompatActivity {
    private EditText txtEmail;
    private EditText oldPassword;
    private EditText newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        txtEmail = (EditText) findViewById(R.id.txtemail_ch_p);
        oldPassword = (EditText) findViewById(R.id.txt_old_password);
        newPassword = (EditText) findViewById(R.id.txtnewpassw);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarlogin);
        setSupportActionBar(toolbar);
    }

    public void btn_Login_Click(View v) throws JSONException {
        final ProgressDialog progressDialog = ProgressDialog.show(ChangePassword.this, "Espera...", "Validando Usuario", false);
        TaskChangePassword logenTask = new TaskChangePassword();
        LoginChangePassword changePassword = new LoginChangePassword();
        changePassword.setOldPassword((oldPassword.getText().toString()));
        changePassword.setNewPassword((newPassword.getText().toString()));
        changePassword.setUser(txtEmail.getText().toString());

        String resul = null;
        try {
            resul = logenTask.execute(changePassword).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int code = TaskLogin.getCode();
        if (code == 200 || code == 201) {
            Intent i = new Intent(ChangePassword.this, LoginUser.class);
            JSONObject token = new JSONObject(resul);
            Security.token = token.getString("token");
            startActivity(i);
        }
    }


}

