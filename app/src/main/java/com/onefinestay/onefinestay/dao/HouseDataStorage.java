package com.onefinestay.onefinestay.dao;

import com.onefinestay.onefinestay.model.HouseLevelModel;
import com.onefinestay.onefinestay.model.IHouseLevelModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Storage of houses
 */
public class HouseDataStorage implements IHouseDataStorage {

    //Initializing available items
    public static final String UNIT = "Unit";
    public static final String GROUND_FLOOR = "Ground floor";
    public static final String FIRST_FLOOR = "First floor";
    public static final String SECOND_FLOOR = "Second floor";
    public static final String THIRD_FLOOR = "Third floor";
    public static final String GARDEN = "Garden";
    public static final String KITCHEN = "Kitchen";
    public static final String BEDROOM = "Bedroom";

    private static IHouseDataStorage instance;

    private static List<IHouseLevelModel> houseFirstLevel;

    //Initialization of hierarchy
    static{
        List<IHouseLevelModel> firstFloor = new ArrayList<IHouseLevelModel>(Arrays.asList(
                new HouseLevelModel(KITCHEN, null), new HouseLevelModel(BEDROOM, null)));
        List<IHouseLevelModel> secondFloor = new ArrayList<IHouseLevelModel>(Arrays.asList(
                new HouseLevelModel(KITCHEN, null)));
        List<IHouseLevelModel> unit = new ArrayList<IHouseLevelModel>(Arrays.asList(
                new HouseLevelModel(GROUND_FLOOR, null),new HouseLevelModel(FIRST_FLOOR, firstFloor),
                new HouseLevelModel(SECOND_FLOOR, secondFloor),
                new HouseLevelModel(THIRD_FLOOR, firstFloor),
                new HouseLevelModel(GARDEN, null)));
        houseFirstLevel = new ArrayList<IHouseLevelModel>(
                Arrays.asList(new HouseLevelModel(UNIT, unit)));
    }

    private HouseDataStorage() {}

    /**
     * Singleton factory method
     * @return instance of HouseDataStorage
     */
    public static IHouseDataStorage getInstance() {
        if (instance == null) {
            synchronized (HouseDataStorage.class) {
                if (instance == null) {
                    instance  = new HouseDataStorage();
                }
            }
        }
        return instance;
    }

    /**
     * Used to get back list of houses to clean
     */
    public  List<IHouseLevelModel> getHouseList() {
        return houseFirstLevel;
    }
}
