package com.onefinestay.onefinestay.dao;

import com.onefinestay.onefinestay.model.IHouseLevelModel;

import java.util.List;

/**
 * Created by stanislavsikorsyi on 18.12.14.
 */
public interface IHouseDataStorage {

     List<IHouseLevelModel> getHouseList();
}
