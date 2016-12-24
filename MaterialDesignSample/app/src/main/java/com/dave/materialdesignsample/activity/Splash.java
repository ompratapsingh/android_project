package com.dave.materialdesignsample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.dave.materialdesignsample.R;
import com.plattysoft.leonids.ParticleSystem;

public class Splash extends Activity {
    private ParticleSystem particleSystemLeft;
    private ParticleSystem particleSystemRight;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Button btn = (Button) findViewById(R.id.button1);
//        Button btn2 = (Button) findViewById(R.id.button2);

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

//        mHandler.postDelayed(new Runnable() {
//            public void run() {
//                Intent intent = new Intent(Splash.this, Register.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 3000);
//        View v1 = getWindow().getDecorView().getRootView();
//        (new ParticleSystem(this, 100, R.drawable.ic_heart, 3000))
//                .setAcceleration(0.00013f, 90)
//                .setSpeedByComponentsRange(0f, 0f, 0.05f, 0.1f)
//                .setFadeOut(200, new AccelerateInterpolator())
//                .emitWithGravity(v1, Gravity.BOTTOM, 30);



        /*

        new ParticleSystem(Splash.this, 80, R.drawable.ic_heart, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.1f, 180, 180)
                .setRotationSpeed(144)
                .setAcceleration(0.000017f, 90)
                .emit(findViewById(R.id.emiter_top_right), 8);

        new ParticleSystem(Splash.this, 80, R.drawable.ic_heart, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.1f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.000017f, 90)
                .emit(findViewById(R.id.emiter_top_left), 8);
*/

//        View v1 = getWindow().getDecorView().getRootView();
//        new ParticleSystem(Splash.this, 100, R.drawable.ic_heart, 3000)
//                .setAcceleration(0.00013f, 90)
//                .setSpeedByComponentsRange(0f, 0f, 0.05f, 0.1f)
//                .setFadeOut(200, new AccelerateInterpolator())
//                .emitWithGravity(v1, Gravity.BOTTOM, 30);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new ParticleSystem(Splash.this, 100, R.drawable.ic_heart, 3000)
//                        .setAcceleration(0.00013f, 90)
//                        .setSpeedByComponentsRange(0f, 0f, 0.05f, 0.1f)
//                        .setFadeOut(200, new AccelerateInterpolator())
//                        .emitWithGravity(v, Gravity.BOTTOM, 30);
//
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
}
