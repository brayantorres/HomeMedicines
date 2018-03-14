package com.example.brayandavid.homemedicines;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

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

        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("user","password/token");
        client.get("http://13.90.130.197/", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(LoginUser.this, (statusCode), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(LoginUser.this, "No funcionó", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

