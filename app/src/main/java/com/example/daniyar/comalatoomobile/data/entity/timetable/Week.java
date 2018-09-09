
package com.example.daniyar.comalatoomobile.data.entity.timetable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Week implements Parcelable {

    @SerializedName("1a")
    @Expose
    private List<OneA> mOneAS = null;
    @SerializedName("1b")
    @Expose
    private List<OneB> mOneBS = null;
    @SerializedName("2")
    @Expose
    private List<Two> mTwos = null;
    @SerializedName("3")
    @Expose
    private List<Three> mThrees = null;
    @SerializedName("4")
    @Expose
    private List<Four> mFours = null;
    @SerializedName("2a")
    @Expose
    private List<TwoA> mTwoAS = null;
    @SerializedName("2b")
    @Expose
    private List<TwoB> mTwoBS = null;

    public List<OneA> getOneAS() {
        return mOneAS;
    }

    public void setOneAS(List<OneA> oneAS) {
        mOneAS = oneAS;
    }

    public List<OneB> getOneBS() {
        return mOneBS;
    }

    public void setOneBS(List<OneB> oneBS) {
        mOneBS = oneBS;
    }

    public List<Two> getTwos() {
        return mTwos;
    }

    public void setTwos(List<Two> twos) {
        mTwos = twos;
    }

    public List<Three> getThrees() {
        return mThrees;
    }

    public void setThrees(List<Three> threes) {
        mThrees = threes;
    }

    public List<Four> getFours() {
        return mFours;
    }

    public void setFours(List<Four> fours) {
        mFours = fours;
    }

    public List<TwoA> getTwoAS() {
        return mTwoAS;
    }

    public void setTwoAS(List<TwoA> twoAS) {
        mTwoAS = twoAS;
    }

    public List<TwoB> getTwoBS() {
        return mTwoBS;
    }

    public void setTwoBS(List<TwoB> twoBS) {
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
