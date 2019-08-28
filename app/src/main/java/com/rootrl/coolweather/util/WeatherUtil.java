package com.rootrl.coolweather.util;

import com.google.gson.Gson;
import com.rootrl.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherUtil {
    public static Weather handleWeatherResponse(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);

            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();

            return new Gson().fromJson(weatherContent, Weather.class);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
