
package com.example.daniyar.comalatoomobile.data.entity.timetable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimetableModel implements Parcelable {

    @SerializedName("times")
    @Expose
    private List<String> times = null;
    @SerializedName("weekDays")
    @Expose
    private List<String> weekDays = null;
    @SerializedName("weeks")
    @Expose
    private List<Week> weeks = null;

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<String> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<String> weekDays) {
        this.weekDays = weekDays;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
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

    protected TimetableModel(Parcel in) {
        if (in.readByte() == 0x01) {
            times = new ArrayList<String>();
            in.readList(times, String.class.getClassLoader());
        } else {
            times = null;
        }
        if (in.readByte() == 0x01) {
            weekDays = new ArrayList<String>();
            in.readList(weekDays, String.class.getClassLoader());
        } else {
            weekDays = null;
        }
        if (in.readByte() == 0x01) {
            weeks = new ArrayList<Week>();
            in.readList(weeks, Week.class.getClassLoader());
        } else {
            weeks = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (times == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(times);
        }
        if (weekDays == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(weekDays);
        }
        if (weeks == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(weeks);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TimetableModel> CREATOR = new Parcelable.Creator<TimetableModel>() {
        @Override
        public TimetableModel createFromParcel(Parcel in) {
            return new TimetableModel(in);
        }

        @Override
        public TimetableModel[] newArray(int size) {
            return new TimetableModel[size];
        }
    };
}
