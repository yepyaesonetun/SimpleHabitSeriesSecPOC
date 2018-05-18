package com.primeyz.padcassignment1.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yepyaesonetun on 5/16/18.
 **/

@SuppressWarnings("all")
public class ItemModel implements Parcelable{

    private int image;
    private String name;
    private String minute;

    public ItemModel(int image, String name, String minute) {
        this.image = image;
        this.name = name;
        this.minute = minute;
    }

    protected ItemModel(Parcel in) {
        image = in.readInt();
        name = in.readString();
        minute = in.readString();
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(minute);
    }
}
