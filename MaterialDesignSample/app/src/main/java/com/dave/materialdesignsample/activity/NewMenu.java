package com.dave.materialdesignsample.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.widget.AnimatorUtils;
import com.dave.materialdesignsample.widget.ClipRevealFrame;
import com.ogaclejapan.arclayout.ArcLayout;

import java.util.ArrayList;
import java.util.List;

public class NewMenu extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_DEMO = "demo";
    Toast toast = null;
    View rootLayout;
    Button btnAlbum, btnEvents, btnProgress, btnWishes, btnContact, btnGallery, btnSplash;
    ClipRevealFrame menuLayout;
    ArcLayout arcLayout;
    View centerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        ImageView ivLeft = (ImageView) findViewById(R.id.ivLeft);
        ImageView ivRight = (ImageView) findViewById(R.id.ivRight);
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

        rootLayout = findViewById(R.id.root_layout);
        menuLayout = (ClipRevealFrame) findViewById(R.id.menu_layout);
        arcLayout = (ArcLayout) findViewById(R.id.arc_layout);
        centerItem = findViewById(R.id.center_item);
        btnAlbum = (Button) rootLayout.findViewById(R.id.btnAlbum);
        btnEvents = (Button) rootLayout.findViewById(R.id.btnEvents);
        btnProgress = (Button) rootLayout.findViewById(R.id.btnProgress);
        btnWishes = (Button) rootLayout.findViewById(R.id.btnWishes);
        btnContact = (Button) rootLayout.findViewById(R.id.btnContact);
        btnGallery = (Button) rootLayout.findViewById(R.id.btnGallery);
        btnSplash = (Button) rootLayout.findViewById(R.id.btnSplash);
        centerItem.setOnClickListener(this);
        for (int i = 0, size = arcLayout.getChildCount(); i < size; i++) {
            arcLayout.getChildAt(i).setOnClickListener(this);
        }

        final Button fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        //  fab.performClick();
//    onFabClick(fab);

        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {

                onFabClick(fab);
            }
        }, 100);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
            onFabClick(v);
            return;
        }

        if (v instanceof Button) {
            manageClick((Button) v);
        }
    }

    private void manageClick(Button btn) {
        if (toast != null) {
            toast.cancel();
        }

        switch (btn.getId()) {

            case R.id.btnAlbum:
                Log.e("test", "ID: " + btn.getId());
//                Toast.makeText(this, "Clicked :" + btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), BookOfLove.class));
                break;

            case R.id.btnEvents:
                Log.e("test", "ID: " + btn.getId());
//                Toast.makeText(this, "Clicked :" + btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Events.class));
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                break;

            case R.id.btnProgress:
                Log.e("test", "ID: " + btn.getId());
//                Toast.makeText(this, "Clicked :" + btn.getText(), Toast.LENGTH_SHORT).show();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
                int screenHeight = displayMetrics.heightPixels;
                int screenWidth = displayMetrics.widthPixels;
                final Dialog dialog = new Dialog(NewMenu.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.popup);
                dialog.setCancelable(true);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                Window window = dialog.getWindow();
                lp.copyFrom(window.getAttributes());
                dialog.getWindow().setLayout(lp.WRAP_CONTENT, lp.WRAP_CONTENT);
                dialog.show();
                break;

            case R.id.btnWishes:
                Log.e("test", "ID: " + btn.getId());
//                Toast.makeText(this, "Clicked :" + btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Wishes.class));
                break;

            case R.id.btnContact:
                Log.e("test", "ID: " + btn.getId());
                startActivity(new Intent(getApplicationContext(), Contact.class));
//                Toast.makeText(this, "Clicked :" + btn.getText(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnGallery:
                Log.e("test", "ID: " + btn.getId());
//                Toast.makeText(this, "Clicked :" + btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Gallery.class));
                break;

            case R.id.btnSplash:
                Log.e("test", "ID: " + btn.getId());
//                Toast.makeText(this, "Clicked :" + btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Splash.class));
                break;
        }
    }

    private void onFabClick(View v) {
        int x = (v.getLeft() + v.getRight()) / 2;
        int y = (v.getTop() + v.getBottom()) / 2;
        float radiusOfFab = 1f * v.getWidth() / 2f;
        float radiusFromFabToRoot = (float) Math.hypot(
                Math.max(x, rootLayout.getWidth() - x),
                Math.max(y, rootLayout.getHeight() - y));

        if (v.isSelected()) {
            hideMenu(x, y, radiusFromFabToRoot, radiusOfFab);
        } else {
            showMenu(x, y, radiusOfFab, radiusFromFabToRoot);
        }
        v.setSelected(!v.isSelected());
    }

    private void showMenu(int cx, int cy, float startRadius, float endRadius) {
        menuLayout.setVisibility(View.VISIBLE);

        List<Animator> animList = new ArrayList<>();

        Animator revealAnim = createCircularReveal(menuLayout, cx, cy, startRadius, endRadius);
        revealAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        revealAnim.setDuration(200);

        animList.add(revealAnim);
        animList.add(createShowItemAnimator(centerItem));

        for (int i = 0, len = arcLayout.getChildCount(); i < len; i++) {
            animList.add(createShowItemAnimator(arcLayout.getChildAt(i)));
        }

        AnimatorSet animSet = new AnimatorSet();
        animSet.playSequentially(animList);
        animSet.start();
    }

    private void hideMenu(int cx, int cy, float startRadius, float endRadius) {
        List<Animator> animList = new ArrayList<>();

        for (int i = arcLayout.getChildCount() - 1; i >= 0; i--) {
            animList.add(createHideItemAnimator(arcLayout.getChildAt(i)));
        }

        animList.add(createHideItemAnimator(centerItem));

        Animator revealAnim = createCircularReveal(menuLayout, cx, cy, startRadius, endRadius);
        revealAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        revealAnim.setDuration(200);
        revealAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                menuLayout.setVisibility(View.INVISIBLE);
            }
        });

        animList.add(revealAnim);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playSequentially(animList);
        animSet.start();

    }

    private Animator createShowItemAnimator(View item) {
        float dx = centerItem.getX() - item.getX();
        float dy = centerItem.getY() - item.getY();

        item.setScaleX(0f);
        item.setScaleY(0f);
        item.setTranslationX(dx);
        item.setTranslationY(dy);

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.scaleX(0f, 1f),
                AnimatorUtils.scaleY(0f, 1f),
                AnimatorUtils.translationX(dx, 0f),
                AnimatorUtils.translationY(dy, 0f)
        );

        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(50);
        return anim;
    }

    private Animator createHideItemAnimator(final View item) {
        final float dx = centerItem.getX() - item.getX();
        final float dy = centerItem.getY() - item.getY();

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.scaleX(1f, 0f),
                AnimatorUtils.scaleY(1f, 0f),
                AnimatorUtils.translationX(0f, dx),
                AnimatorUtils.translationY(0f, dy)
        );

        anim.setInterpolator(new DecelerateInterpolator());
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                item.setTranslationX(0f);
                item.setTranslationY(0f);
            }
        });
        anim.setDuration(50);
        return anim;
    }

    private Animator createCircularReveal(final ClipRevealFrame view, int x, int y, float startRadius,
                                          float endRadius) {
        final Animator reveal;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            reveal = ViewAnimationUtils.createCircularReveal(view, x, y, startRadius, endRadius);
        } else {
            view.setClipOutLines(true);
            view.setClipCenter(x, y);
            reveal = ObjectAnimator.ofFloat(view, "ClipRadius", startRadius, endRadius);
            reveal.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setClipOutLines(false);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });
        }
        return reveal;
    }
}

