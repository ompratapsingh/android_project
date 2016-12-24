package com.dave.materialdesignsample.database;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class Message extends SugarRecord {
    private String message;
    private String dateTime;
    private String sneder;
    private Long id;

    public Message() {
    }

    public Message(String message, String dateTime,String sneder) {
        this.message = message;
        this.dateTime = dateTime;
        this.sneder = sneder;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSneder() {
        return sneder;
    }
//
    public void setSneder(String sneder) {
        this.sneder = sneder;
    }
//
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}