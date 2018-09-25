
package com.comaiu.daniyar.comalatoomobile.data.entity.timetable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Week implements Parcelable {

    @SerializedName("1a")
    @Expose
    private ArrayList<OneA> mOneAS = null;
    @SerializedName("1b")
    @Expose
    private ArrayList<OneB> mOneBS = null;
    @SerializedName("2")
    @Expose
    private ArrayList<Two> mTwos = null;
    @SerializedName("3")
    @Expose
    private ArrayList<Three> mThrees = null;
    @SerializedName("4")
    @Expose
    private ArrayList<Four> mFours = null;
    @SerializedName("2a")
    @Expose
    private ArrayList<TwoA> mTwoAS = null;
    @SerializedName("2b")
    @Expose
    private ArrayList<TwoB> mTwoBS = null;

    public ArrayList<OneA> getOneAS() {
        return mOneAS;
    }

    public void setOneAS(ArrayList<OneA> oneAS) {
        mOneAS = oneAS;
    }

    public ArrayList<OneB> getOneBS() {
        return mOneBS;
    }

    public void setOneBS(ArrayList<OneB> oneBS) {
        mOneBS = oneBS;
    }

    public ArrayList<Two> getTwos() {
        return mTwos;
    }

    public void setTwos(ArrayList<Two> twos) {
        mTwos = twos;
    }

    public ArrayList<Three> getThrees() {
        return mThrees;
    }

    public void setThrees(ArrayList<Three> threes) {
        mThrees = threes;
    }

    public ArrayList<Four> getFours() {
        return mFours;
    }

    public void setFours(ArrayList<Four> fours) {
        mFours = fours;
    }

    public ArrayList<TwoA> getTwoAS() {
        return mTwoAS;
    }

    public void setTwoAS(ArrayList<TwoA> twoAS) {
        mTwoAS = twoAS;
    }

    public ArrayList<TwoB> getTwoBS() {
        return mTwoBS;
    }

    public void setTwoBS(ArrayList<TwoB> twoBS) {
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
            mOneAS = new ArrayList<OneA>();
            in.readList(mOneAS, OneA.class.getClassLoader());
        } else {
            mOneAS = null;
        }
        if (in.readByte() == 0x01) {
            mOneBS = new ArrayList<OneB>();
            in.readList(mOneBS, OneB.class.getClassLoader());
        } else {
            mOneBS = null;
        }
        if (in.readByte() == 0x01) {
            mTwos = new ArrayList<Two>();
            in.readList(mTwos, Two.class.getClassLoader());
        } else {
            mTwos = null;
        }
        if (in.readByte() == 0x01) {
            mThrees = new ArrayList<Three>();
            in.readList(mThrees, Three.class.getClassLoader());
        } else {
            mThrees = null;
        }
        if (in.readByte() == 0x01) {
            mFours = new ArrayList<Four>();
            in.readList(mFours, Four.class.getClassLoader());
        } else {
            mFours = null;
        }
        if (in.readByte() == 0x01) {
            mTwoAS = new ArrayList<TwoA>();
            in.readList(mTwoAS, TwoA.class.getClassLoader());
        } else {
            mTwoAS = null;
        }
        if (in.readByte() == 0x01) {
            mTwoBS = new ArrayList<TwoB>();
            in.readList(mTwoBS, TwoB.class.getClassLoader());
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