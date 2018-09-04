package com.astervaldemoro.fitspo.utils;

public class Constant {

    /*** API INFO ***/
    public final static String API_FOOD_ITEM_BASE_URL = "https://api.nal.usda.gov/ndb/nutrients/?format=json";
    public final static String NUTRIENTS_QUERY_KEY = "nutrients";
    public final static String API_QUERY_KEY = "api_key";
    public final static String PROTIEN_QUERY_ID = "203";
    public final static String FATS_QUERY_ID = "204";
    public final static String CARBS_QUERY_ID = "205";
    public final static String CALORIES_QUERY_ID = "208";
    public final static String SUGARS_QUERY_ID = "269";
    public final static String FOOD_ITEM_ID_KEY = "ndbno";

    public final static String SEARCH_FOOD_BASE_URL = "https://api.nal.usda.gov/ndb/search/?format=json";
    public final static String SEARCH_QUERY_KEY = "q";
    public final static String SORT_QUERY_KEY = "sort";
    public final static String SORT_QUERY_VALUE = "n"; // to sort by name
    public final static String MAX_QUERY_ITEMS_KEY = "max";
    public final static String MAX_QUERY_ITEM_VALUE = "15"; // # of shown items
    public final static String OFFSET_QUERY_ITEM_KEY = "offset";
    public final static String OFFSET_QUERY_ITEM_VALUE = "0";


    /*** INTENT KEYS***/
    public final static String ADD_MEALS = "ADD_MEALS";

}
