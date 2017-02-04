package com.dave.materialdesignsample.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.global.ConnectionDetector;
import com.dave.materialdesignsample.global.FontStyle;
import com.dave.materialdesignsample.global.God;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Invitation extends Activity implements View.OnClickListener {

    private AsyncHttpClient client;
    //    String URL = "http://cloud.novusservice.com/webapi/login";
    private ProgressDialog progressDialog;
    String str = "";
    private Gson gson;
    RelativeLayout rl;
    LinearLayout llbase;
    TextView tvGroom, tvBride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);

        ImageView ivLeft = (ImageView) findViewById(R.id.ivLeft);
        ImageView ivRight = (ImageView) findViewById(R.id.ivRight);
        ImageView ivDeny = (ImageView) findViewById(R.id.ivDeny);
        ImageView ivAccept = (ImageView) findViewById(R.id.ivAccept);
        ImageView ivLeftBg = (ImageView) findViewById(R.id.ivLeftBg);
        ImageView ivRightBg = (ImageView) findViewById(R.id.ivRightBg);

        tvGroom = (TextView) findViewById(R.id.tvGroom);
        tvBride = (TextView) findViewById(R.id.tvBride);

        FontStyle.setRainbow(this, tvGroom);
        FontStyle.setRainbow(this, tvBride);
        rl = (RelativeLayout) findViewById(R.id.rl);
        llbase = (LinearLayout) findViewById(R.id.llbase);

        overridePendingTransition(R.anim.push_out_left, R.anim.pull_in_right);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int screenHeight = displaymetrics.heightPixels;
        int screenWidth = displaymetrics.widthPixels;
        animateToolbarDroppingDown(rl);
        animation();

        ivLeft.getLayoutParams().height = (int) (screenWidth * 0.2);
        ivLeft.getLayoutParams().width = (int) (screenWidth * 0.25);
        ivRight.getLayoutParams().height = (int) (screenWidth * 0.2);
        ivRight.getLayoutParams().width = (int) (screenWidth * 0.25);
        ivLeftBg.getLayoutParams().width = (int) (screenWidth * 0.45);
        ivLeftBg.getLayoutParams().height = (int) (screenWidth * 0.45);
        ivRightBg.getLayoutParams().height = (int) (screenWidth * 0.45);
        ivRightBg.getLayoutParams().width = (int) (screenWidth * 0.45);
        ivDeny.getLayoutParams().height = (int) (screenWidth * 0.2);
        ivDeny.getLayoutParams().width = (int) (screenWidth * 0.2);
        ivAccept.getLayoutParams().height = (int) (screenWidth * 0.2);
        ivAccept.getLayoutParams().width = (int) (screenWidth * 0.2);

//        Bundle bundle = getIntent().getExtras();
        ivAccept.setOnClickListener(this);
        ivDeny.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ivAccept:
                str = "yes";
                break;
            case R.id.ivDeny:
                str = "no";
                break;
        }
//        registerCall();
        Intent intent = new Intent(Invitation.this, NewMenu.class);
        startActivity(intent);
    }


    private void registerCall() {
        if (!ConnectionDetector.isConnectingToInternet(Invitation.this)) {
            Toast.makeText(this, "No internet connection...", Toast.LENGTH_SHORT).show();
        } else {
//            progressDialog = ProgressDialog.show(Invitation.this, "", "Please wait...");
            God.displayDialog(Invitation.this);
            final String deviceId = Settings.Secure.getString(this.getContentResolver(),
                    Settings.Secure.ANDROID_ID);

            JSONObject jsonParams = new JSONObject();

            try {
                jsonParams.put("actionId", 1);
                jsonParams.put("merriageId", 101);
                jsonParams.put("deviceId", deviceId);
                jsonParams.put("name", God.userName);
                jsonParams.put("email", God.email);
                jsonParams.put("mobile", God.mobileNo);
                jsonParams.put("acceptation", str);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringEntity entity = null;
            try {
                Log.e("res", "to string " + jsonParams.toString());
                entity = new StringEntity(jsonParams.toString());

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            client = new AsyncHttpClient();
            client.post(Invitation.this, God.URL, entity, "application/json", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                    progressDialog.dismiss();
                    God.dismissDialog(Invitation.this);

                    String strResponnse = new String(responseBody);

                    Log.e("res", strResponnse);
                    Toast.makeText(Invitation.this, "" + strResponnse, Toast.LENGTH_LONG).show();
                    gson = new Gson();
//                    logInDao = gson.fromJson(strResponnse, LogInDao.class);
//                    logInDao.getData().get(0);

                    SharedPreferences.Editor editor = getSharedPreferences("user", 0).edit();
                    editor.putString("deviceid", deviceId);
                    editor.apply();
                    editor.commit();

                    Intent intent = new Intent(Invitation.this, NewMenu.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                    progressDialog.dismiss();
                    God.dismissDialog(Invitation.this);
                }
            });
        }
    }

    public void animation() {
        animateToolbarDroppingDown(rl);

        TranslateAnimation leftToright = new TranslateAnimation(-1200.0f, 0.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        leftToright.setDuration(1500);  // animation duration
        leftToright.setRepeatCount(0);  // animation repeat count
//                animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
//      animation.setFillAfter(true);
        tvGroom.startAnimation(leftToright);  // start animation


        TranslateAnimation rightToleft = new TranslateAnimation(1200.0f, 0.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        rightToleft.setDuration(1500);  // animation duration
        rightToleft.setRepeatCount(0);  // animation repeat count
//                animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
//      animation.setFillAfter(true);
        tvBride.startAnimation(rightToleft);

        TranslateAnimation bottomTotop = new TranslateAnimation(0.0f, 0.0f,
                1200.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        bottomTotop.setDuration(1500);  // animation duration
        bottomTotop.setRepeatCount(0);  // animation repeat count
//                animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
//      animation.setFillAfter(true);
        llbase.startAnimation(bottomTotop);  // start animation

    }

    public static void animateToolbarDroppingDown(View containerToolbar) {
        containerToolbar.setRotationX(-90);
        containerToolbar.setAlpha(0.2F);
        containerToolbar.setPivotX(0.0F);
        containerToolbar.setPivotY(0.0F);
        Animator alpha = ObjectAnimator.ofFloat(containerToolbar, "alpha", 0.2F, 0.4F, 1.0F).setDuration(1000);
        Animator rotationX = ObjectAnimator.ofFloat(containerToolbar, "rotationX", -40, 20, -20, 10, 0).setDuration(3000);
//        Animator rotationX = ObjectAnimator.ofFloat(containerToolbar, "rotationX", -90, 60, -45, 45, -10, 30, 0, 20, 0, 5, 0).setDuration(8000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(alpha, rotationX);
        animatorSet.start();
    }

    /**
     * <></>
     *
     * @param registrationEvent
     */
   /* public void onEvent(RegistrationEvent registrationEvent) {
        RegistrationVo registrationVo = registrationEvent.getRegistrationVo();
        if (registrationVo != null) {
            startActivity(new Intent(Invitation.this, NewMenu.class));
        } else {
            Log.d("Error", "Error while executing Login!");
            Toast.makeText(Invitation.this, "Seems Like Error While Performace Task", Toast.LENGTH_LONG).show();
        }
    }*/
}
