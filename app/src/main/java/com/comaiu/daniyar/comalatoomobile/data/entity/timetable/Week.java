
package com.comaiu.daniyar.comalatoomobile.data.entity.timetable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Week implements Parcelable {

    @SerializedName("1a")
    @Expose
    private ArrayList<DayModel> mOneAS = null;
    @SerializedName("1b")
    @Expose
    private ArrayList<DayModel> mOneBS = null;
    @SerializedName("2")
    @Expose
    private ArrayList<DayModel> mTwos = null;
    @SerializedName("3")
    @Expose
    private ArrayList<DayModel> mThrees = null;
    @SerializedName("4")
    @Expose
    private ArrayList<DayModel> mFours = null;
    @SerializedName("2a")
    @Expose
    private ArrayList<DayModel> mTwoAS = null;
    @SerializedName("2b")
    @Expose
    private ArrayList<DayModel> mTwoBS = null;

    public ArrayList<DayModel> getOneAS() {
        return mOneAS;
    }

    public void setOneAS(ArrayList<DayModel> oneAS) {
        mOneAS = oneAS;
    }

    public ArrayList<DayModel> getOneBS() {
        return mOneBS;
    }

    public void setOneBS(ArrayList<DayModel> oneBS) {
        mOneBS = oneBS;
    }

    public ArrayList<DayModel> getTwos() {
        return mTwos;
    }

    public void setTwos(ArrayList<DayModel> twos) {
        mTwos = twos;
    }

    public ArrayList<DayModel> getThrees() {
        return mThrees;
    }

    public void setThrees(ArrayList<DayModel> threes) {
        mThrees = threes;
    }

    public ArrayList<DayModel> getFours() {
        return mFours;
    }

    public void setFours(ArrayList<DayModel> fours) {
        mFours = fours;
    }

    public ArrayList<DayModel> getTwoAS() {
        return mTwoAS;
    }

    public void setTwoAS(ArrayList<DayModel> twoAS) {
        mTwoAS = twoAS;
    }

    public ArrayList<DayModel> getTwoBS() {
        return mTwoBS;
    }

    public void setTwoBS(ArrayList<DayModel> twoBS) {
        mTwoBS = twoBS;
    }

    @Override
    public String toString() {
        return "Week{" +
                "mOneAS=" + mOneAS +
                ", mOneBS=" + mOneBS +
                ", mTwos=" + mTwos +
                ", mThrees=" + mThrees +
                ", mFours=" + mFours +
                ", mTwoAS=" + mTwoAS +
                ", mTwoBS=" + mTwoBS +
                '}';
    }

    public Week(){}

    protected Week(Parcel in) {
        if (in.readByte() == 0x01) {
            mOneAS = new ArrayList<DayModel>();
            in.readList(mOneAS, DayModel.class.getClassLoader());
        } else {
            mOneAS = null;
        }
        if (in.readByte() == 0x01) {
            mOneBS = new ArrayList<DayModel>();
            in.readList(mOneBS, DayModel.class.getClassLoader());
        } else {
            mOneBS = null;
        }
        if (in.readByte() == 0x01) {
            mTwos = new ArrayList<DayModel>();
            in.readList(mTwos, DayModel.class.getClassLoader());
        } else {
            mTwos = null;
        }
        if (in.readByte() == 0x01) {
            mThrees = new ArrayList<DayModel>();
            in.readList(mThrees, DayModel.class.getClassLoader());
        } else {
            mThrees = null;
        }
        if (in.readByte() == 0x01) {
            mFours = new ArrayList<DayModel>();
            in.readList(mFours, DayModel.class.getClassLoader());
        } else {
            mFours = null;
        }
        if (in.readByte() == 0x01) {
            mTwoAS = new ArrayList<DayModel>();
            in.readList(mTwoAS, DayModel.class.getClassLoader());
        } else {
            mTwoAS = null;
        }
        if (in.readByte() == 0x01) {
            mTwoBS = new ArrayList<DayModel>();
            in.readList(mTwoBS, DayModel.class.getClassLoader());
        } else {
            mTwoBS = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mOneAS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mOneAS);
        }
        if (mOneBS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mOneBS);
        }
        if (mTwos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mTwos);
        }
        if (mThrees == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mThrees);
        }
        if (mFours == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mFours);
        }
        if (mTwoAS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mTwoAS);
        }
        if (mTwoBS == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mTwoBS);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Week> CREATOR = new Parcelable.Creator<Week>() {
        @Override
        public Week createFromParcel(Parcel in) {
            return new Week(in);
        }

        @Override
        public Week[] newArray(int size) {
            return new Week[size];
        }
    };
}