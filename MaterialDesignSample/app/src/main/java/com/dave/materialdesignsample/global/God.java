package com.dave.materialdesignsample.global;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.dave.materialdesignsample.R;

public class God {
    public static String URL = "http://ankit77rajput.com/invitationService/invitationAPI.php";

    public static String userName = "";
    public static String mobileNo = "";
    public static String email = "";
    public static Dialog dialog;

    public static String getDeviceId(Context context) {
        return context.getSharedPreferences("user", 0).getString("deviceid", null);
    }


    public static void displayDialog(Context context) {


        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup);
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        dialog.getWindow().setLayout(lp.WRAP_CONTENT, lp.WRAP_CONTENT);
        dialog.show();
    }

    public static void dismissDialog(Context context) {
        dialog.dismiss();
    }
}
