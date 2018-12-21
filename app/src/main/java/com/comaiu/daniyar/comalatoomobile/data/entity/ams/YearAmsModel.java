package com.comaiu.daniyar.comalatoomobile.data.entity.ams;

import java.io.Serializable;
import java.util.ArrayList;

public class YearAmsModel implements Serializable {

    private String year;

    private ArrayList<TermModel> mTermModels = null;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<TermModel> getTermModels() {
        return mTermModels;
    }

    public void setTermModels(ArrayList<TermModel> termModels) {
        mTermModels = termModels;
    }

    @Override
    public String toString() {
        return "YearAmsModel{" +
                "year='" + year + '\'' +
                ", mTermModels=" + mTermModels +
                '}';
    }
}
