package com.dave.materialdesignsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.database.Message;

import java.util.List;

/**
 * Created by Dave on 15-11-2016.
 */


public class WishesAdapter extends RecyclerView.Adapter<WishesAdapter.ViewHolder> {

    private List<Message> allMessages;
    private Context mContext;


    public WishesAdapter(Context mContext, List<Message> allMessages) {
        this.mContext = mContext;
        this.allMessages = allMessages;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout2, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return allMessages.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvMessage.setText("" + allMessages.get(i).getMessage() + allMessages.get(i).getDateTime());
//        viewHolder.tvEdition.setText(allMessages.get(i).getEdition());
//        id = allMessages.get(i).getId().toString();
//        viewHolder.itemImage.setImageResource(images[i]);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

//        public int currentItem;
        //        public ImageView itemImage;
        public TextView tvMessage;
//        public TextView tvEdition;
//        Button btnUpdate, btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);
//            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            tvMessage = (TextView) itemView.findViewById(R.id.tvMessage);
//            tvEdition = (TextView) itemView.findViewById(R.id.tvEdition);
//            btnUpdate = (Button) itemView.findViewById(R.id.btnUpdate);
//            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
        }
    }
}
