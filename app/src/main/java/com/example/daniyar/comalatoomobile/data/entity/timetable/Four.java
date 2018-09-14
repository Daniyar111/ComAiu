
package com.example.daniyar.comalatoomobile.data.entity.timetable;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Four extends RealmObject {

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
        return "Four{" +
                "name='" + name + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
