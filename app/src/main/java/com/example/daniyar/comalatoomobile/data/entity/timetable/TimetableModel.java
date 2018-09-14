
package com.example.daniyar.comalatoomobile.data.entity.timetable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class TimetableModel extends RealmObject {

    @SerializedName("times")
    @Expose
    private RealmList<String> times = null;
    @SerializedName("weekDays")
    @Expose
    private RealmList<String> weekDays = null;
    @SerializedName("weeks")
    @Expose
    private RealmList<Week> weeks = null;

    public RealmList<String> getTimes() {
        return times;
    }

    public void setTimes(RealmList<String> times) {
        this.times = times;
    }

    public RealmList<String> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(RealmList<String> weekDays) {
        this.weekDays = weekDays;
    }

    public RealmList<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(RealmList<Week> weeks) {
        this.weeks = weeks;
    }

    @Override
    public String toString() {
        return "TimetableModel{" +
                "times=" + times +
                ", weekDays=" + weekDays +
                ", weeks=" + weeks +
                '}';
    }
}
