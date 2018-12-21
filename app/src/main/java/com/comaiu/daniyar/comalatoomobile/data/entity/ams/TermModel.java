package com.comaiu.daniyar.comalatoomobile.data.entity.ams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TermModel implements Serializable {

    private String finalExam;
    private String midterm;
    private String subject;

    public String getFinal() {
        return finalExam;
    }

    public void setFinal(String finalExam) {
        this.finalExam = finalExam;
    }

    public String getMidterm() {
        return midterm;
    }

    public void setMidterm(String midterm) {
        this.midterm = midterm;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "TermModel{" +
                "finalExam='" + finalExam + '\'' +
                ", midterm='" + midterm + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
