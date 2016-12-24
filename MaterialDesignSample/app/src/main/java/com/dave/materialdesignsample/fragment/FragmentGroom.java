package com.dave.materialdesignsample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dave.materialdesignsample.R;

/**
 * Created by Dave on 13-12-2016.
 */

public class FragmentGroom extends Fragment {

    public FragmentGroom() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.pager_frament, container, false);
        ImageView ivImage = (ImageView) myView.findViewById(R.id.ivImage);

        ivImage.setImageResource(R.drawable.groom);

        return myView;
    }
}