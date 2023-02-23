package com.example.module_3_assignment_api_call;

import static android.content.ContentValues.TAG;


// here we set model i.e is what content we want to fetch
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

import java.io.IOException;

public class countryModel {
    private String name;
    private String flag;

    private PictureDrawable flagImage;

    public countryModel(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }

    public static void setImageDrawable(PictureDrawable drawable) {
    }

    public PictureDrawable getFlagImage() {
        return flagImage;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlagImage(PictureDrawable flagImage) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void loadFlagImage(String url, ImageView imageView) {
        Context context = null;
        if (url.endsWith(".svg")) {
            try {
                // Load SVG image using AndroidSVG library
                SVG svg = SVG.getFromInputStream(context.getAssets().open(url));
                Drawable drawable = new PictureDrawable(svg.renderToPicture());
                imageView.setImageDrawable(drawable);
            } catch (IOException | SVGParseException e) {
                Log.e(TAG, "Error loading SVG image", e);
            }
        } else {
            // Load bitmap image using Glide
            assert context != null;
            Glide.with(context)
                    .load(url)
                    .into(imageView);
        }
    }

}
