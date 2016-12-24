package com.dave.materialdesignsample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.dave.materialdesignsample.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Dave on 06-12-2016.
 */

public class CalendarSample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_calendar);
        final TextView time = (TextView) findViewById(R.id.txtCountDown);

        final GregorianCalendar currentTime = new GregorianCalendar(2016, 12, 7, 0, 11, 0);
        GregorianCalendar targetTime = new GregorianCalendar(2017, 1, 18, 11, 2, 0);
        long difference = targetTime.getTimeInMillis() - currentTime.getTimeInMillis();
        new CountDownTimer(difference, 1000) {

            @Override
            public void onTick(long arg0) {
                Calendar countdownDuration = Calendar.getInstance();
                countdownDuration.setTimeInMillis(currentTime.getTimeInMillis() + arg0);
                int year = countdownDuration.get(Calendar.YEAR) - currentTime.get(Calendar.YEAR);
                int month = countdownDuration.get(Calendar.MONTH);
                int day = countdownDuration.get(Calendar.DAY_OF_MONTH) - 1;
                int hour = countdownDuration.get(Calendar.HOUR);
                int minute = countdownDuration.get(Calendar.MINUTE);
                int sec = countdownDuration.get(Calendar.SECOND);

                time.setText("Years: " + year + "\nMonth:" + month + "\nDays:" + day + "\nHour:" + hour
                        + "\nMinute" + minute + "\nSecond:" + sec);

            }

            @Override
            public void onFinish() {
                // TODO Auto-generated method stub

            }
        }.start();
    }
}