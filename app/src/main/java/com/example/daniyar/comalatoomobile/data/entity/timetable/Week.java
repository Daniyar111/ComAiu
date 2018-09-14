
package com.example.daniyar.comalatoomobile.data.entity.timetable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Week extends RealmObject {

    @SerializedName("1a")
    @Expose
    private RealmList<OneA> mOneAS = null;
    @SerializedName("1b")
    @Expose
    private RealmList<OneB> mOneBS = null;
    @SerializedName("2")
    @Expose
    private RealmList<Two> mTwos = null;
    @SerializedName("3")
    @Expose
    private RealmList<Three> mThrees = null;
    @SerializedName("4")
    @Expose
    private RealmList<Four> mFours = null;
    @SerializedName("2a")
    @Expose
    private RealmList<TwoA> mTwoAS = null;
    @SerializedName("2b")
    @Expose
    private RealmList<TwoB> mTwoBS = null;

    public RealmList<OneA> getOneAS() {
        return mOneAS;
    }

    public void setOneAS(RealmList<OneA> oneAS) {
        mOneAS = oneAS;
    }

    public RealmList<OneB> getOneBS() {
        return mOneBS;
    }

    public void setOneBS(RealmList<OneB> oneBS) {
        mOneBS = oneBS;
    }

    public RealmList<Two> getTwos() {
        return mTwos;
    }

    public void setTwos(RealmList<Two> twos) {
        mTwos = twos;
    }

    public RealmList<Three> getThrees() {
        return mThrees;
    }

    public void setThrees(RealmList<Three> threes) {
        mThrees = threes;
    }

    public RealmList<Four> getFours() {
        return mFours;
    }

    public void setFours(RealmList<Four> fours) {
        mFours = fours;
    }

    public RealmList<TwoA> getTwoAS() {
        return mTwoAS;
    }

    public void setTwoAS(RealmList<TwoA> twoAS) {
        mTwoAS = twoAS;
    }

    public RealmList<TwoB> getTwoBS() {
        return mTwoBS;
    }

    public void setTwoBS(RealmList<TwoB> twoBS) {
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
}
