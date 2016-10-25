package com.example.tuananh.gridviewcustom.data.model;

/**
 * Created by framgia on 25/10/2016.
 */
public class City {
    private String mId;
    private String mName;
    private int mIdImage;

    public City(String id, String name, int idImage) {
        mId = id;
        mName = name;
        mIdImage = idImage;
    }

    public City(String name, int idImage) {
        mName = name;
        mIdImage = idImage;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getIdImage() {
        return mIdImage;
    }
}
