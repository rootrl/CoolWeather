package com.rootrl.coolweather.util;

import android.text.TextUtils;

import com.rootrl.coolweather.db.City;
import com.rootrl.coolweather.db.County;
import com.rootrl.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressUtil {

    // 处理省级数据
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvincies = new JSONArray(response);

                for (int i = 0; i < allProvincies.length(); i++) {
                    JSONObject provinceObject = allProvincies.getJSONObject(i);

                    Province province = new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }
                return true;
            }catch (JSONException e) {
                return false;
            }
        }

        return false;
    }

    // 处理市级数据
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allcities = new JSONArray(response);
                for (int i = 0; i < allcities.length();i++) {
                    JSONObject cityObject = allcities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e)
            {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }

    // 处理县级数据
    public static boolean handleCountyResponse(String response, int cityId)
    {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);

                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countryObject = allCounties.getJSONObject(i);

                    County county = new County();
                    county.setCountryName(countryObject.getString("name"));
                    county.setWeatherId(countryObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }

                return true;
            }catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
