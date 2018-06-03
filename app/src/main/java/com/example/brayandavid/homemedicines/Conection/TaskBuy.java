package com.example.brayandavid.homemedicines.Conection;

import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.Buyer;
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

public class TaskBuy extends AsyncTask<Buyer, Void, String> {
    static int code;

    public TaskBuy() {
    }

    @Override
    protected String doInBackground(Buyer... buyers) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost del = new HttpPost("http://13.90.130.197/cart/pay");
        del.setHeader("content-type", "application/json");
        del.setHeader("Authorization", Security.getToken());
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fullName", buyers[0].getFullName() );
            jsonObject.put("dniNumber", buyers[0].getDniNumber());
            jsonObject.put("emailAddress", buyers[0].getEmailAddress());
            jsonObject.put("contactPhone", buyers[0].getContactPhone());
            jsonObject.put("merchantBuyerId", buyers[0].getMerchantBuyerId());
            jsonObject.put("shippingAddress", buyers[0].getShippingAddress());
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
