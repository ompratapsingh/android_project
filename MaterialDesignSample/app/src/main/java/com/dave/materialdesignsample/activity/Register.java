package com.dave.materialdesignsample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;
import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.constant.AppConstants;
import com.dave.materialdesignsample.global.God;
import com.plattysoft.leonids.ParticleSystem;

import io.fabric.sdk.android.Fabric;
import java.util.regex.Pattern;

public class Register extends Activity {
    ImageView ivLogo;
    EditText etNumber, etEmail, etName;
    Button btnRegister, btnAccept;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_login);

        etNumber = (EditText) findViewById(R.id.etNumber);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etName = (EditText) findViewById(R.id.etName);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        btnRegister = (Button) findViewById(R.id.btnRegister);
//        btnAccept = (Button) findViewById(R.id.btnAccept);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int screenHeight = displaymetrics.heightPixels;
        int screenWidth = displaymetrics.widthPixels;

        ivLogo.getLayoutParams().width = (int) (screenWidth * 0.60);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ParticleSystem(Register.this, 100, R.drawable.star_pink, 800)
                        .setSpeedRange(0.1f, 0.25f)
                        .oneShot(v, 100);

                mHandler.postDelayed(new Runnable() {
                    public void run() {
//                if (isValid()) {
                        God.userName = etName.getText().toString();
                        Bundle bundle=new Bundle();
                        bundle.putString(AppConstants.R_NAME,etName.getText().toString());
                        bundle.putString(AppConstants.R_MOBILE,etNumber.getText().toString());
                        bundle.putString(AppConstants.R_EMAIL,etEmail.getText().toString());
                        Intent intent = new Intent(Register.this, Invitation.class);
                        intent.putExtras(bundle);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
//                }
                    }
                }, 1000);

            }
        });
    }

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private boolean isValid() {
        boolean b = false;
        if (etName.getText().toString().trim().length() == 0) {
            etName.setError("Please enter Name");
            etName.requestFocus();
            b = false;
        } else if (!EMAIL_ADDRESS_PATTERN.matcher(etEmail.getText().toString()).matches()) {
            etEmail.setError("Please enter Valid Email");
            etEmail.requestFocus();
            b = false;
        } else if (etNumber.getText().length() != 10) {
            etNumber.setError("Please enter Proper Number");
            etNumber.requestFocus();
            b = false;
        } else {
            b = true;

        }
        return b;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
