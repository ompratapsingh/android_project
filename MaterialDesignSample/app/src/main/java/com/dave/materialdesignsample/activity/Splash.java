package com.dave.materialdesignsample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dave.materialdesignsample.PlayAudio;
import com.dave.materialdesignsample.R;
import com.plattysoft.leonids.ParticleSystem;

import static com.dave.materialdesignsample.global.God.getDeviceId;

public class Splash extends Activity {
    private ParticleSystem particleSystemLeft;
    private ParticleSystem particleSystemRight;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent objIntent = new Intent(this, PlayAudio.class);
        startService(objIntent);

        final int i = getWindowManager().getDefaultDisplay().getWidth();
        particleSystemLeft = (new ParticleSystem(this, 400, R.drawable.ic_heart, 10000))
                .setSpeedModuleAndAngleRange(0.0F, 0.2F, 0, 0)
                .setRotationSpeed(100F)
                .setAcceleration(5E-05F, 145);
        particleSystemRight = (new ParticleSystem(this, 400, R.drawable.ic_heart, 10000))
                .setSpeedModuleAndAngleRange(0.0F, 0.2F, 180, 180)
                .setRotationSpeed(100F)
                .setAcceleration(5E-05F, 80);

        particleSystemLeft.emit(findViewById(R.id.emiter_top_left), 8);
        particleSystemRight.emit(i, 0, 8);

        mHandler.postDelayed(new Runnable() {
            public void run() {
                doStuff();
            }
        }, 10000);
    }

    private void doStuff() {
        if (getDeviceId(this) == null) {
            Intent i1 = new Intent(this, Register.class);
            startActivity(i1);
            this.finish();
        } else {
            Intent i2 = new Intent(this, NewMenu.class);
            startActivity(i2);
            this.finish();
        }
    }
}
