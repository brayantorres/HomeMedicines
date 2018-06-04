package com.example.brayandavid.homemedicines.Conection;

import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.Pay;
import com.example.brayandavid.homemedicines.Security;

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

public class TaskBuy extends AsyncTask<Pay, Void, String> {
    static int code;

    public TaskBuy() {
    }

    @Override
    protected String doInBackground(Pay... pays) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost del = new HttpPost("http://13.90.130.197/cart/pay");
        del.setHeader("content-type", "application/json");
        del.setHeader("Authorization", Security.getToken());
        try {
            Pay pay = pays[0];
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("buyer", pay.getBuyer());
            jsonObject.put("creditcard", pay.getCreditcard());
            jsonObject.put("paymentMethod", pay.getPaymentMethod());
            jsonObject.put("shippingAddress", pay.getShippingAddress());
            jsonObject.put("user", pay.getUser());

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

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        TaskBuy.code = code;
    }


}
