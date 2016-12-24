package com.dave.materialdesignsample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.dave.materialdesignsample.R;

public class Invitation extends Activity {
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

        ivAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Invitation.this, Menu.class));
            }
        });
    }
}
