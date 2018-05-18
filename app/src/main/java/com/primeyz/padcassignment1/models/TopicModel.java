package com.primeyz.padcassignment1.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yepyaesonetun on 5/16/18.
 **/

@SuppressWarnings("unused")
public class TopicModel implements Parcelable{
    private int image;
    private int bgImage;
    private String title;
    private String subtitle;

    public TopicModel(int image,int bgImage, String title, String subtitle) {
        this.image = image;
        this.bgImage = bgImage;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getBgImage() {
        return bgImage;
    }

    public void setBgImage(int bgImage) {
        this.bgImage = bgImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    private TopicModel(Parcel in) {
        image = in.readInt();
        bgImage = in.readInt();
        title = in.readString();
        subtitle = in.readString();
    }

    public static final Creator<TopicModel> CREATOR = new Creator<TopicModel>() {
        @Override
        public TopicModel createFromParcel(Parcel in) {
            return new TopicModel(in);
        }

        @Override
        public TopicModel[] newArray(int size) {
            return new TopicModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeInt(bgImage);
        dest.writeString(title);
        dest.writeString(subtitle);
    }
}
