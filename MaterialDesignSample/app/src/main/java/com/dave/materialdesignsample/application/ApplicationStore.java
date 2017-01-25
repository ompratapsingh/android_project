package com.dave.materialdesignsample.application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import io.fabric.sdk.android.Fabric;

/**
 * Created by osingh on 20-Jan-17.
 */
public class ApplicationStore extends MultiDexApplication {

    private static ApplicationStore applicationStore;
    private static HashMap<String,Object> applicationDataMap;
    private static Context context;
    private static String version;

    public static ApplicationStore getInstance() {
        if (applicationStore != null)
            return applicationStore;
        else {
            applicationStore = new ApplicationStore();
            return applicationStore;
        }
    }

    @Override
    public void onCreate() {

        super.onCreate();
        Fabric.with(this, new Crashlytics());

        context = getApplicationContext();
        version = android.os.Build.VERSION.RELEASE;

        if (applicationDataMap == null) {
            applicationDataMap = new HashMap<String, Object>();
        }
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d("Call",">>>>>>>>>>>onActivityDestroyed>>>>>>>>>>>>>");
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static void putApplicationData(String key, Object value) {
        applicationDataMap.put(key, value);
    }

    public static Object getApplicationData(String key) {
        return applicationDataMap.get(key);
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ApplicationStore.context = context;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        ApplicationStore.version = version;
    }
}
