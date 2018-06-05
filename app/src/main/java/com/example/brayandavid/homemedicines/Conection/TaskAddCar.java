package com.example.brayandavid.homemedicines.Conection;

import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.Objects.Item;
import com.example.brayandavid.homemedicines.Security;

import org.json.JSONObject;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by Kevin Ortiz on 6/4/2018.
 */

public class TaskAddCar extends AsyncTask<Item, Void, String> {
    static int code;

    public TaskAddCar() {
    }

    @Override
    protected String doInBackground(Item... items) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost add = new HttpPost("http://13.90.130.197/cart/add-product/" + Security.getUsuario());
        add.setHeader("content-type", "application/json");
        add.setHeader("Authorization", Security.getToken());

        try {
            JSONObject item = new JSONObject();
            item.put("quantity", items[0].getCantidad());
            JSONObject product = new JSONObject();
            product.put("id", items[0].getProduct().getId());
            product.put("eachPrice", items[0].getProduct().getEachPrice());

            item.put("product", product);

            add.setEntity(new StringEntity(item.toString()));
            HttpResponse resp = httpClient.execute(add);
            String respStr = EntityUtils.toString(resp.getEntity());
            code = resp.getStatusLine().getStatusCode();
            return respStr;

        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }

        return null;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        TaskAddCar.code = code;
    }
}
