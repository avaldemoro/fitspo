package com.astervaldemoro.fitspo.utils;

import android.net.Uri;
import com.astervaldemoro.fitspo.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JsonUtils {
    // query is the food ID # that gets selected by the user.
    public static URL buildFoodItemUrl(String query) {
        Uri builtUri = Uri.parse(Constant.API_FOOD_ITEM_BASE_URL).buildUpon()
                .appendQueryParameter (Constant.API_QUERY_KEY, BuildConfig.API_KEY)
                .appendQueryParameter (Constant.NUTRIENTS_QUERY_KEY, Constant.PROTIEN_QUERY_ID)
                .appendQueryParameter (Constant.NUTRIENTS_QUERY_KEY, Constant.CARBS_QUERY_ID)
                .appendQueryParameter (Constant.NUTRIENTS_QUERY_KEY, Constant.FATS_QUERY_ID)
                .appendQueryParameter (Constant.NUTRIENTS_QUERY_KEY, Constant.SUGARS_QUERY_ID)
                .appendQueryParameter (Constant.NUTRIENTS_QUERY_KEY, Constant.CALORIES_QUERY_ID)
                .appendQueryParameter (Constant.FOOD_ITEM_ID_KEY, query)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    // query is what the user types into the search bar
    public static URL buildSearchUrl(String query) {
        Uri builtUri = Uri.parse(Constant.SEARCH_FOOD_BASE_URL).buildUpon()
                .appendQueryParameter (Constant.SEARCH_QUERY_KEY, query)
                .appendQueryParameter (Constant.SORT_QUERY_KEY, Constant.SORT_QUERY_VALUE)
                .appendQueryParameter (Constant.MAX_QUERY_ITEMS_KEY, Constant.MAX_QUERY_ITEM_VALUE)
                .appendQueryParameter (Constant.OFFSET_QUERY_ITEM_KEY, Constant.OFFSET_QUERY_ITEM_VALUE)
                .appendQueryParameter (Constant.API_QUERY_KEY, BuildConfig.API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner (in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
