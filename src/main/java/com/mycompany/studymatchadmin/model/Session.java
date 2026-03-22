package com.mycompany.studymatchadmin.model;

public class Session {

    private int id;
    private String tutor;
    private String student;
    private double amount;
    private String status;

    public Session() {}

    public Session(int id, String tutor, String student, double amount, String status) {
        this.id = id;
        this.tutor = tutor;
        this.student = student;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}