package com.onefinestay.onefinestay.model;

import android.os.Parcelable;

import java.util.List;

/**
 * Class represents one level of House model
 */
public interface IHouseLevelModel extends Parcelable{

    String getName();
    List<IHouseLevelModel> getHouseLevelList();

}
