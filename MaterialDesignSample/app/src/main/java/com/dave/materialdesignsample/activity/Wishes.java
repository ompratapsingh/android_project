package com.dave.materialdesignsample.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dave.materialdesignsample.R;
import com.dave.materialdesignsample.adapter.WishesAdapter;
import com.dave.materialdesignsample.database.Message;
import com.dave.materialdesignsample.global.ConnectionDetector;
import com.dave.materialdesignsample.global.God;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.dave.materialdesignsample.global.God.URL;

public class Wishes extends AppCompatActivity {
    private List<Message> allMessages;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ImageView ivSend;
    private EditText etMessage;

    private AsyncHttpClient client;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishes);
        etMessage = (EditText) findViewById(R.id.etMessage);
        ivSend = (ImageView) findViewById(R.id.ivSend);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        wishesList();

        //TODO :: Need To Work on Display of wishes from Database.
        /*setADAPTER();*/

        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendWishes();
            }
        });
    }

    private void wishesList() {
        if (!ConnectionDetector.isConnectingToInternet(Wishes.this)) {
            Toast.makeText(this, "No internet connection...", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog = ProgressDialog.show(Wishes.this, "", "Please wait...");
//
//            String deviceId = Settings.Secure.getString(this.getContentResolver(),
//                    Settings.Secure.ANDROID_ID);
            JSONObject jsonParams = new JSONObject();

            try {
                jsonParams.put("actionId", 3);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringEntity entity = null;
            try {
                Log.e("res", "to string " + jsonParams.toString());
                entity = new StringEntity(jsonParams.toString());

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            client = new AsyncHttpClient();
            client.post(Wishes.this, URL, entity, "application/json", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    progressDialog.dismiss();

                    String strResponnse = new String(responseBody);

                    Log.e("res", strResponnse);
                    Toast.makeText(Wishes.this, "" + strResponnse, Toast.LENGTH_LONG).show();


                  /*  List<Message> messages = new ArrayList<>();
                    messages.add(new Message("isbn123", "Title here", "2nd edition"))
                    messages.add(new Message("isbn456", "Title here 2", "3nd edition"))
                    messages.add(new Message("isbn789", "Title here 3", "4nd edition"))
                    SugarRecord.saveInTx(messages);*/
//                gson = new Gson();
//                logInDao = gson.fromJson(strResponnse, LogInDao.class);
//                    logInDao.getData().get(0);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    progressDialog.dismiss();
                }
            });
        }
    }

    private void sendWishes() {
        if (!ConnectionDetector.isConnectingToInternet(Wishes.this)) {
            Toast.makeText(this, "No internet connection...", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog = ProgressDialog.show(Wishes.this, "", "Please wait...");

            JSONObject jsonParams = new JSONObject();

            final long time = System.currentTimeMillis();

            try {
                jsonParams.put("actionId", 2);
                jsonParams.put("user_id", "888");
                jsonParams.put("message", etMessage.getText().toString());
                jsonParams.put("merriageId", 101);
                jsonParams.put("insertedTime", time);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringEntity entity = null;
            try {
                Log.e("res", "to string " + jsonParams.toString());
                entity = new StringEntity(jsonParams.toString());

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            client = new AsyncHttpClient();
            client.post(Wishes.this, URL, entity, "application/json", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    progressDialog.dismiss();

                    String strResponnse = new String(responseBody);

                    Log.e("res", strResponnse);
                    Toast.makeText(Wishes.this, "" + strResponnse, Toast.LENGTH_LONG).show();
//                gson = new Gson();
//                logInDao = gson.fromJson(strResponnse, LogInDao.class);
//                    logInDao.getData().get(0);

                    Message message = new Message("" + etMessage.getText().toString(), Long.toString(time), "" + God.userName);
                    message.save();

                    setADAPTER();
//                recyclerView.scrollToPosition(allMessages.size()-1);
                    recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount());
                    etMessage.setText("");
                    Log.e("str", "" + etMessage.getText().toString() + " " + Long.toString(time) + " " + God.userName);
//                etProfession.setText("");
//                Toast.makeText(Wishes.this, "Record Added", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    progressDialog.dismiss();
                }
            });
        }
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
