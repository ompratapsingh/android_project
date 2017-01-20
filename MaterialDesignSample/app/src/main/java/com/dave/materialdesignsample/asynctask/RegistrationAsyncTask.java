package com.dave.materialdesignsample.asynctask;

import android.app.Activity;
import android.os.AsyncTask;

import com.dave.materialdesignsample.businessobjects.AppBO;
import com.dave.materialdesignsample.event.RegistrationEvent;
import com.dave.materialdesignsample.model.RegistrationVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

import de.greenrobot.event.EventBus;

/**
 * Created by osingh on 20-Jan-17.
 */
public class RegistrationAsyncTask extends AsyncTask<String, String, String> {

    Activity activity;
    boolean isProgress;

    public RegistrationAsyncTask(Activity activity, boolean isProgress) {
        this.activity = activity;
        this.isProgress = isProgress;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... param) {

        String name = param[0]; // name of user
        String email = param[1]; // email of user
        String mobile = param[2]; // mobile of user
        String accept = param[3]; // accep or not
        String actionID = param[4]; // actionId
        AppBO appBO = new AppBO();
        String responsce = appBO.getRegistrationOFUser(name, email, accept, mobile, actionID);
        return responsce;
    }

    @Override
    protected void onPostExecute(String responsce) {
        super.onPostExecute(responsce);
        RegistrationVo registrationVo = null;
        if (responsce != null && !responsce.isEmpty()) {
            registrationVo = new Gson().fromJson(responsce, new TypeToken<HashMap<String, RegistrationVo>>() {
            }.getType());
        }
        RegistrationEvent registrationEvent = new RegistrationEvent(registrationVo);
        EventBus.getDefault().post(registrationEvent);
    }
}
