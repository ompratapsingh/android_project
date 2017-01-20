package com.dave.materialdesignsample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.asynctask.RegistrationAsyncTask;
import com.dave.materialdesignsample.event.RegistrationEvent;
import com.dave.materialdesignsample.model.RegistrationVo;

public class Invitation extends Activity implements View.OnClickListener {
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
        RegistrationAsyncTask registrationAsyncTask = new RegistrationAsyncTask(Invitation.this, true);
        registrationAsyncTask.execute();
    }

    /**
     *<></>
     * @param registrationEvent
     */
    public void onEvent(RegistrationEvent registrationEvent) {
        RegistrationVo registrationVo = registrationEvent.getRegistrationVo();
        if (registrationVo != null) {
            startActivity(new Intent(Invitation.this, NewMenu.class));
        } else {
            Log.d("Error", "Error while executing Login!");
            Toast.makeText(Invitation.this, "Seems Like Error While Performace Task", Toast.LENGTH_LONG).show();
        }
    }
}
