package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.brayandavid.homemedicines.View.Category;
import com.example.brayandavid.homemedicines.View.Producto;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by Kevin Ortiz on 14/03/2018.
 */
public class HttpConection extends AsyncTask<String, Integer, List<Producto>> {


    private Context mContext;

    public HttpConection(Context context) {
        mContext = context;
    }

    @Override
    protected List<Producto> doInBackground(String... strings) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet del = new HttpGet("http://13.90.130.197/product");
        del.setHeader("content-type", "application/json");
        del.setHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncml0aWNvc3VhdmVAZ21haWwuY29tIiwiZXhwIjoxNTIxNjYzNjk1fQ.5cbhSSbmaFu9ILPuqy2P2WQYEe6BBTsZk3TnoGOwpwtECsc_IWtirXlZq0dv1enfE4nVeYuNmmSSY1ZYJFjU7A");
        System.out.print("jaja Inicie REst****************+");
        try {
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());

            JSONArray respJSON = new JSONArray(respStr);

            List<Producto> productosList = new ArrayList<>();

            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);

                Producto producto = new Producto();
                producto.setId(obj.getString("id"));
                producto.setName(obj.getString("name"));
                producto.setDescription(obj.getString("description"));
                //producto.setEachPrice(obj.getDouble("eachPrice"));

                JSONObject categoryJson = obj.getJSONObject("category");

                Category category = new Category();
                category.setId(categoryJson.getString("id"));
                category.setName(categoryJson.getString("name"));

                producto.setCategory(category);
                productosList.add(producto);
            }
            System.out.print("Termineeeee REst****************+");
            return productosList;
        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }
        return new ArrayList<>();
    }


    @Override
    protected void onPostExecute(List<Producto> productos) {
        try {
            super.onPostExecute(productos);
        }catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}
