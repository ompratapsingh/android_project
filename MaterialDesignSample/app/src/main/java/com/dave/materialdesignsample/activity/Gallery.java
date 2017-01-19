package com.dave.materialdesignsample.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dave.materialdesignsample.R;
import com.zhy.magicviewpager.transformer.RotateYTransformer;

/**
 * Created by Dave on 23-12-2016.
 */

public class Gallery extends AppCompatActivity {


    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    int[] imgRes = {R.drawable.a1, R.drawable.b1, R.drawable.c1, R.drawable.d1,
            R.drawable.e1, R.drawable.f1, R.drawable.g1, R.drawable.h1, R.drawable.i1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mViewPager.setPageMargin(20);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view = new ImageView(Gallery.this);
//                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                view.setLayoutParams(lp);
//                view.setText(position + ":" + view);
                view.setScaleType(ImageView.ScaleType.FIT_XY);
//                view.setBackgroundColor(Color.parseColor("#44ff0000"));
                view.setImageResource(imgRes[position]);
                container.addView(view);
//                view.setAdjustViewBounds(true);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }
        });
        mViewPager.setPageTransformer(true, new RotateYTransformer());

    }
//
//    @Override
//    public boolean onCreateOptionsMenu(android.view.Menu menu) {
//        String effect = "RotateY";
////        for (String effect)
//            menu.add(effect);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        String title = item.getTitle().toString();
//        mViewPager.setAdapter(mAdapter);
//
//        if ("RotateDown".equals(title)) {
//            mViewPager.setPageTransformer(true, new RotateDownPageTransformer());
//        } else if ("RotateUp".equals(title)) {
//            mViewPager.setPageTransformer(true, new RotateUpPageTransformer());
//        } else if ("RotateY".equals(title)) {
//            mViewPager.setPageTransformer(true, new RotateYTransformer(45));
//        } else if ("Standard".equals(title)) {
////            mViewPager.setClipChildren(false);
//            mViewPager.setPageTransformer(true, NonPageTransformer.INSTANCE);
//        } else if ("Alpha".equals(title)) {
////            mViewPager.setClipChildren(false);
//            mViewPager.setPageTransformer(true, new AlphaPageTransformer());
//        } else if ("ScaleIn".equals(title)) {
//            mViewPager.setPageTransformer(true, new ScaleInTransformer());
//        } else if ("RotateDown and Alpha".equals(title)) {
//            mViewPager.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer()));
//        } else if ("RotateDown and Alpha And ScaleIn".equals(title)) {
//            mViewPager.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));
//        }
//
//        setTitle(title);
//
//        return true;
//    }
}
