package com.dave.materialdesignsample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.adapter.EventAdapter;
import com.dave.materialdesignsample.model.EventModel;

import java.util.ArrayList;
import java.util.List;

public class Events extends AppCompatActivity {
    private List<EventModel> eventList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new EventAdapter(Events.this, eventList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareEventData();
    }

    private void prepareEventData() {

        EventModel event = new EventModel("Egagement", "Sat, 03 Dec 2016, 08:15 PM", "22.996170", "72.599586","Maninagar");
        eventList.add(event);

        event = new EventModel("Dinner", "Sun, 04 Dec 2016, 08:00 PM", "23.006741", "72.596245","Kankaria");
        eventList.add(event);

        event = new EventModel("Wedding", "Sun, 04 Dec 2016, 08:00 PM", "23.0343", "72.5090","Rajpath Club");
        eventList.add(event);

        event = new EventModel("Reception", "Mon, 05 Dec 2016, 08:00 PM", "23.0196", "72.5039","Karnavati club");
        eventList.add(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
//        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
}
