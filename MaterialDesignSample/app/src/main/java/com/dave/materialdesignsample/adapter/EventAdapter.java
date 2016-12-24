package com.dave.materialdesignsample.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.model.EventModel;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private List<EventModel> eventList;
    private Context context;

    public EventAdapter(Context context, List<EventModel> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView event, date;
        public ImageView ivLocation;
        String strPlace;

        public MyViewHolder(View itemView) {
            super(itemView);
            event = (TextView) itemView.findViewById(R.id.tvEventName);
            date = (TextView) itemView.findViewById(R.id.tvDateTime);
            ivLocation = (ImageView) itemView.findViewById(R.id.ivLocation);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final EventModel eventModel = eventList.get(position);
        holder.event.setText(eventModel.getEvent());
        holder.date.setText(eventModel.getDate());

//        holder.strPlace = eventModel.getLatlng();
        holder.ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Uri.parse("geo:<lat>,<long>?q=<lat>,<long>(Label+Name)");
                Uri gmmIntentUri = Uri.parse("geo:<" + eventModel.getLat() + ">,<" + eventModel.getLng() + ">?q=<" + eventModel.getPlace() + ">");
//                Uri gmmIntentUri = Uri.parse("geo:<"+eventModel.getLat()+">,<"+eventModel.getLng()+">?q=<"+eventModel.getLat()+">,<"+eventModel.getLng()+">");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });
        if (position == 0) {
            holder.event.setTextColor(Color.parseColor("#FC608C"));
            holder.date.setTextColor(Color.parseColor("#FC608C"));
//            holder.event.setTextColor(Color.parseColor(String.valueOf(R.color.colorAccent)));
//            holder.date.setTextColor(Color.parseColor(String.valueOf(R.color.colorAccent)));
//            holder.itemView.setBackgroundColor(Color.parseColor(String.valueOf(R.color.lightBg)));
            holder.itemView.setBackgroundColor(Color.parseColor("#70EFEDE7"));
        } else if (position % 2 == 1) {
            holder.event.setTextColor(Color.parseColor("#FFFFFF"));
            holder.date.setTextColor(Color.parseColor("#FFFFFF"));
//            holder.event.setTextColor(Color.parseColor(String.valueOf(R.color.whiteFont)));
//            holder.date.setTextColor(Color.parseColor(String.valueOf(R.color.whiteFont)));
            holder.itemView.setBackgroundColor(Color.parseColor("#70AEACA1"));
//            holder.itemView.setBackgroundColor(Color.parseColor(String.valueOf(R.color.darkBg)));
        } else if (position % 2 == 0) {
            holder.event.setTextColor(Color.parseColor("#FC608C"));
            holder.date.setTextColor(Color.parseColor("#FC608C"));
//            holder.event.setTextColor(Color.parseColor(String.valueOf(R.color.colorAccent)));
//            holder.date.setTextColor(Color.parseColor(String.valueOf(R.color.colorAccent)));
            holder.itemView.setBackgroundColor(Color.parseColor("#70EFEDE7"));
//            holder.itemView.setBackgroundColor(Color.parseColor(String.valueOf(R.color.lightBg)));

        }

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

}
