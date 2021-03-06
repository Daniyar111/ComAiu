
package com.comaiu.daniyar.comalatoomobile.data.entity.timetable;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DayModel implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("other")
    @Expose
    private String other;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "DayModel{" +
                "name='" + name + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public DayModel(){}

    protected DayModel(Parcel in) {
        name = in.readString();
        other = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(other);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DayModel> CREATOR = new Parcelable.Creator<DayModel>() {
        @Override
        public DayModel createFromParcel(Parcel in) {
            return new DayModel(in);
        }

        @Override
        public DayModel[] newArray(int size) {
            return new DayModel[size];
        }
    };
}