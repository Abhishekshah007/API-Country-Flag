package com.example.module_3_assignment_api_call;

import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

import java.io.IOException;
import java.net.URL;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//here we configure retrofit to fetch data
public class clientInterface {
    private static final String BASE_URL = "https://restcountries.com/v2/";

    private static Retrofit retrofit = null;



    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofit;
    }
//
//    public void loadFlag(String flagUrl, Callback<PictureDrawable> callback){
//        new Thread(()->{
//            try {
//                SVG svg = SVG.getFromInputStream(new URL(flagUrl).openStream());
//                Picture picture = svg.renderToPicture();
//                PictureDrawable drawable = new PictureDrawable(picture);
//                callback.onResponse(drawable);
//            }
//            catch (IOException | SVGParseException e){
//                callback.onFailure(e);
//            }
//        });
//    }


}