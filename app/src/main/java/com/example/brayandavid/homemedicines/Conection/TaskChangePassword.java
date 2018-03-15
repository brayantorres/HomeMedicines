package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.LoginChangePassword;

import org.json.JSONObject;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by Kevin Ortiz on 15/03/2018.
 */

public class TaskChangePassword extends AsyncTask<LoginChangePassword, Void, String> {
    static int code;
    public TaskChangePassword(Context loginCPContext) {this.loginCPContext = loginCPContext;}

    private Context loginCPContext;

    @Override
    protected String doInBackground(LoginChangePassword... loginChangePasswords) {
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost("http://13.90.130.197/login/change-password");
            del.setHeader("content-type", "application/json");
            del.setHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncml0aWNvc3VhdmVAZ21haWwuY29tIiwiZXhwIjoxNTIxNjYzNjk1fQ.5cbhSSbmaFu9ILPuqy2P2WQYEe6BBTsZk3TnoGOwpwtECsc_IWtirXlZq0dv1enfE4nVeYuNmmSSY1ZYJFjU7A");
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("user", loginChangePasswords[0].getUser());
                jsonObject.put("password", loginChangePasswords[0].getOldPassword());
                jsonObject.put("password", loginChangePasswords[0].getNewPassword());
                del.setEntity(new StringEntity(jsonObject.toString()));
                HttpResponse resp = httpClient.execute(del);
                String respStr = EntityUtils.toString(resp.getEntity());
                code = resp.getStatusLine().getStatusCode();

                return respStr;

            } catch (Exception ex) {
                Log.e("ServicioRest", "Error!", ex);
            }
            return "";
        }

    }
}
