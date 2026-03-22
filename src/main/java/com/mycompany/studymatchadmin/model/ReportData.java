package com.mycompany.studymatchadmin.model;

public class ReportData {

    private String month;
    private int sessions;
    private int newUsers;
    private double accuracy;

    public ReportData(String month, int sessions, int newUsers, double accuracy) {
        this.month = month;
        this.sessions = sessions;
        this.newUsers = newUsers;
        this.accuracy = accuracy;
    }

    public String getMonth() {
        return month;
    }

    public int getSessions() {
        return sessions;
    }

    public int getNewUsers() {
        return newUsers;
    }

    public double getAccuracy() {
        return accuracy;
    }
}