package com.example.daniyar.comalatoomobile.data.entity;

public class NewsModel {

    private String date;
    private String name;
    private String description;
    private int[] imagesId;

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

    public int[] getImagesId() {
        return imagesId;
    }

    public void setImagesId(int[] imagesId) {
        this.imagesId = imagesId;
    }
}
