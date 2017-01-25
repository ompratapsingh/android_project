package com.dave.materialdesignsample.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.global.ConnectionDetector;
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


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int screenHeight = displaymetrics.heightPixels;
        int screenWidth = displaymetrics.widthPixels;

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

        Bundle bundle = getIntent().getExtras();
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
        registerCall();

        /* RegistrationAsyncTask registrationAsyncTask = new RegistrationAsyncTask(Invitation.this, true);
        registrationAsyncTask.execute();*/
    }


    private void registerCall() {
        if (!ConnectionDetector.isConnectingToInternet(Invitation.this)) {
            Toast.makeText(this, "No internet connection...", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog = ProgressDialog.show(Invitation.this, "", "Please wait...");

            String deviceId = Settings.Secure.getString(this.getContentResolver(),
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
                    progressDialog.dismiss();

                    String strResponnse = new String(responseBody);

                    Log.e("res", strResponnse);
                    Toast.makeText(Invitation.this, "" + strResponnse, Toast.LENGTH_LONG).show();
//                gson = new Gson();
//                logInDao = gson.fromJson(strResponnse, LogInDao.class);
//                    logInDao.getData().get(0);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    progressDialog.dismiss();
                }
            });
        }
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
