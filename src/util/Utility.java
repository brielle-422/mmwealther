package util;

import model.City;
import model.County;
import model.MmWeatherDB;
import model.Province;
import android.text.TextUtils;

public class Utility {

//�����ʹ�����������ص�ʡ������**********************************************************************

public synchronized static boolean handleProvincesResponse(MmWeatherDB mmWeatherDB, String response) {
	if (!TextUtils.isEmpty(response)) {
	String[] allProvinces = response.split(",");
	if (allProvinces != null && allProvinces.length > 0) {
	for (String p : allProvinces) {
	String[] array = p.split("\\|");
	Province province = new Province();
	province.setProvinceCode(array[0]);
	province.setProvinceName(array[1]);
// ���������������ݴ洢��Province��*************************************************************
	mmWeatherDB.saveProvince(province);
	}
	return true;
	}
	}
	return false;
	}

//�����ʹ�����������ص��м�����*****************************************************************

	public static boolean handleCitiesResponse(MmWeatherDB mmWeatherDB,String response, int provinceId) {
	if (!TextUtils.isEmpty(response)) {
	String[] allCities = response.split(",");
	if (allCities != null && allCities.length > 0) {
	for (String c : allCities) {
	String[] array = c.split("\\|");
	City city = new City();
	city.setCityCode(array[0]);
	city.setCityName(array[1]);
	city.setProvinceId(provinceId);
	mmWeatherDB.saveCity(city);// ���������������ݴ洢��City��
	}
	return true;
	}}
	return false;
	}

//�����ʹ�����������ص��ؼ�����*******************************************************************

public static boolean handleCountiesResponse(MmWeatherDB mmWeatherDB,String response, int cityId) {
if (!TextUtils.isEmpty(response)) {
String[] allCounties = response.split(",");
if (allCounties != null && allCounties.length > 0) {
for (String c : allCounties) {
String[] array = c.split("\\|");
County county = new County();
county.setCountyCode(array[0]);
county.setCountyName(array[1]);
county.setCityId(cityId);
mmWeatherDB.saveCounty(county);// ���������������ݴ洢��County��
}
return true;
}
}
return false;
}
}
