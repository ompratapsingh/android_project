package com.dave.materialdesignsample.circlemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dave.materialdesignsample.R;

public class CircleActivity extends Activity
{
	private CircleMenuLayout mCircleMenuLayout;
	private String[] mItemTexts = new String[] {};
	private int[] mItemImgs = new int[] { R.drawable.a,
			R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e,
			R.drawable.f };

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
		mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

		mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener()
		{
			@Override
			public void itemClick(View view, int pos)
			{
				Toast.makeText(CircleActivity.this, mItemTexts[pos],Toast.LENGTH_SHORT).show();
			}
			@Override
			public void itemCenterClick(View view)
			{
				Toast.makeText(CircleActivity.this,"you can do something just like ccb  ",Toast.LENGTH_SHORT).show();
			}
		});
	}
}