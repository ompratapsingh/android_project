package com.dave.materialdesignsample.model;

/**
 * Created by osingh on 20-Jan-17.
 */
public class RegistrationVo {

    private int userId;
    private String name;
    private String number;
    private String email;
    private String accept;
    private String marriageId;

    public RegistrationVo(int userId, String name, String number, String email, String accept, String marriageId) {
        this.userId = userId;
        this.name = name;
        this.number = number;
        this.email = email;
        this.accept = accept;
        this.marriageId = marriageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(String marriageId) {
        this.marriageId = marriageId;
    }
}
