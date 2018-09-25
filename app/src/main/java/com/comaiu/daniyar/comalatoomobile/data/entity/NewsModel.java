package com.comaiu.daniyar.comalatoomobile.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsModel implements Parcelable {

    private String date;
    private String name;
    private String description;
    private int imageId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public NewsModel(){}

    protected NewsModel(Parcel in) {
        date = in.readString();
        name = in.readString();
        description = in.readString();
        imageId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(imageId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<NewsModel> CREATOR = new Parcelable.Creator<NewsModel>() {
        @Override
        public NewsModel createFromParcel(Parcel in) {
            return new NewsModel(in);
        }

        @Override
        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };
}
