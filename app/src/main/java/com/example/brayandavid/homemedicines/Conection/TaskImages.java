package com.example.brayandavid.homemedicines.Conection;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.loopj.android.http.HttpGet;


/**
 * Created by Kevin Ortiz on 16/03/2018.
 */

public class TaskImages extends AsyncTask<byte[], Bitmap, byte[]> {
    private Context mContext;
    @Override
    protected byte[] doInBackground(byte[]... bytes) {
        HttpGet httpGet = new HttpGet("http://13.90.130.197/product/001/image/4");
        httpGet.setHeader("content-type", "application/json");
        httpGet.setHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncml0aWNvc3VhdmVAZ21haWwuY29tIiwiZXhwIjoxNTIxNjYzNjk1fQ.5cbhSSbmaFu9ILPuqy2P2WQYEe6BBTsZk3TnoGOwpwtECsc_IWtirXlZq0dv1enfE4nVeYuNmmSSY1ZYJFjU7A");

      //  CloseableHttpResponse response = TaskImages.execute(httpGet);
        //byte[] imagen = ByteStreams.toByteArray(response.getEntity().getContent());
        return null;




    }


}
