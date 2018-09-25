
package com.example.daniyar.comalatoomobile.data.entity.timetable;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TwoB implements Parcelable {

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
        return "TwoB{" +
                "name='" + name + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public TwoB(){}

    protected TwoB(Parcel in) {
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
    public static final Parcelable.Creator<TwoB> CREATOR = new Parcelable.Creator<TwoB>() {
        @Override
        public TwoB createFromParcel(Parcel in) {
            return new TwoB(in);
        }

        @Override
        public TwoB[] newArray(int size) {
            return new TwoB[size];
        }
    };
}