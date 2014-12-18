package com.onefinestay.onefinestay.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents one level of House model
 * Aggregates in itself other levels
 */
public class HouseLevelModel implements IHouseLevelModel {

    private String name;

    private List<IHouseLevelModel> houseLayer;

    public HouseLevelModel(String name, List<IHouseLevelModel> level) {
        this.name = name;
        this.houseLayer = level;
    }

    public String getName() {
        return name;
    }


    public List<IHouseLevelModel> getHouseLevelList() {
        return houseLayer;
    }

    protected HouseLevelModel(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0x01) {
            houseLayer = new ArrayList<IHouseLevelModel>();
            in.readList(houseLayer, IHouseLevelModel.class.getClassLoader());
        } else {
            houseLayer = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        if (houseLayer == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(houseLayer);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<HouseLevelModel> CREATOR = new Parcelable.Creator<HouseLevelModel>() {
        @Override
        public HouseLevelModel createFromParcel(Parcel in) {
            return new HouseLevelModel(in);
        }

        @Override
        public HouseLevelModel[] newArray(int size) {
            return new HouseLevelModel[size];
        }
    };

}
