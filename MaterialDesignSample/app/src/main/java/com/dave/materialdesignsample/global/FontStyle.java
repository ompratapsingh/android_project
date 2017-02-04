package com.dave.materialdesignsample.global;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class FontStyle {

    public static void setRainbow(Context context, View view) {
        try {
            Typeface type = Typeface.createFromAsset(context.getAssets(), "MTCORSVA.ttf");
            ((TextView) view).setTypeface(type);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void setEnglish(Context context, View view) {
//        try {
//            Typeface type = Typeface.createFromAsset(context.getAssets(), "ITCKRIST.TTF");
//            ((TextView) view).setTypeface(type);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
