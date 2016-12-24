package com.dave.materialdesignsample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.adapter.WishesAdapter;
import com.dave.materialdesignsample.database.Message;
import com.dave.materialdesignsample.global.God;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wishes extends AppCompatActivity {
    private List<Message> allMessages;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ImageView ivSend;
    private EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishes);
        etMessage = (EditText) findViewById(R.id.etMessage);
        ivSend = (ImageView) findViewById(R.id.ivSend);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        setADAPTER();

        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                String currentDateandTime = sdf.format(new Date());
                Message message = new Message("" + etMessage.getText().toString(), currentDateandTime, "" + God.userName);
                message.save();

                setADAPTER();
//                recyclerView.scrollToPosition(allMessages.size()-1);
                recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount());
                etMessage.setText("");
                Log.e("str", "" + etMessage.getText().toString() + " " + currentDateandTime + " " + God.userName);
//                etProfession.setText("");
//                Toast.makeText(Wishes.this, "Record Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setADAPTER() {
        allMessages = new ArrayList<Message>();
        allMessages = Message.listAll(Message.class);
        adapter = new WishesAdapter(Wishes.this, allMessages);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.invalidate();
    }
}
