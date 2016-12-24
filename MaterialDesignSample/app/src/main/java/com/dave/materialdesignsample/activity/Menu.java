package com.dave.materialdesignsample.activity;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dave.materialdesignsample.R;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().hide();
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomButtonDemoFragment())
                    .commit();
        }
    }

    class CustomButtonDemoFragment extends Fragment {

        public CustomButtonDemoFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.activity_menu, container, false);
            ImageView ivLeft = (ImageView) rootView.findViewById(R.id.ivLeft);
            ImageView ivRight = (ImageView) rootView.findViewById(R.id.ivRight);
            ImageView ivLeftBg = (ImageView) rootView.findViewById(R.id.ivLeftBg);
            ImageView ivRightBg = (ImageView) rootView.findViewById(R.id.ivRightBg);

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

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
            // Our action button is this time just a regular view!
            Button centerActionButton = (Button) rootView.findViewById(R.id.centerActionButton);

            // Add some items to the menu. They are regular views as well!
            TextView a = new TextView(getActivity());
            a.setText("Album");
            a.setBackgroundResource(android.R.drawable.btn_default_small);
            a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), BookOfLove.class));
                }
            });

            TextView b = new TextView(getActivity());
            b.setText("Events");
            b.setBackgroundResource(android.R.drawable.btn_default_small);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Events.class));
                    overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                }
            });

            TextView c = new TextView(getActivity());
            c.setText("Progress");
            c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);

                    int screenHeight = displayMetrics.heightPixels;
                    int screenWidth = displayMetrics.widthPixels;

                    final Dialog dialog = new Dialog(Menu.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.popup);
                    dialog.setCancelable(true);

                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    Window window = dialog.getWindow();
                    lp.copyFrom(window.getAttributes());
                    dialog.getWindow().setLayout(lp.WRAP_CONTENT, lp.WRAP_CONTENT);
                    dialog.show();
                }
            });

            c.setBackgroundResource(android.R.drawable.btn_default_small);
            TextView d = new TextView(getActivity());
            d.setText("Wishes");
            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Wishes.class));
                }
            });

            d.setBackgroundResource(android.R.drawable.btn_default_small);
            TextView e = new TextView(getActivity());
            e.setText("Contact");
            e.setBackgroundResource(android.R.drawable.btn_default_small);
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Contact.class));
                }
            });
            TextView f = new TextView(getActivity());
            f.setText("Gallery");
            f.setBackgroundResource(android.R.drawable.btn_default_small);
            f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Gallery.class));
                }
            });
            TextView g = new TextView(getActivity());
            g.setText("Splash");
            g.setBackgroundResource(android.R.drawable.btn_default_small);
            g.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Splash.class));
                }
            });
            TextView h = new TextView(getActivity());
            h.setText("h");
            h.setBackgroundResource(android.R.drawable.btn_default_small);

            FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            a.setLayoutParams(tvParams);
            b.setLayoutParams(tvParams);
            c.setLayoutParams(tvParams);
            d.setLayoutParams(tvParams);
            e.setLayoutParams(tvParams);
            f.setLayoutParams(tvParams);
            g.setLayoutParams(tvParams);
            h.setLayoutParams(tvParams);


            SubActionButton.Builder subBuilder = new SubActionButton.Builder(getActivity());

            FloatingActionMenu circleMenu = new FloatingActionMenu.Builder(getActivity())
                    .setStartAngle(0) // A whole circle!
                    .setEndAngle(360)
                    .setRadius(200)
                    .addSubActionView(a)
                    .addSubActionView(b)
                    .addSubActionView(c)
                    .addSubActionView(d)
                    .addSubActionView(e)
                    .addSubActionView(f)
                    .addSubActionView(g)
                    .addSubActionView(h)
                    .attachTo(centerActionButton)
                    .build();

            return rootView;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

//        new AlertDialog.Builder(this)
//                .setMessage("Are you sure you want to exit?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        Menu.this.finish();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.dismiss();
//                    }
//                })
//                .setCancelable(true)
//                .show();
    }
}

