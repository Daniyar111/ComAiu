package com.example.daniyar.comalatoomobile.data.entity;

public class TimetableModel {

    private String day;
    private String course;

    public TimetableModel(String day, String course){
        this.day = day;
        this.course = course;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
