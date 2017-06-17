package com.pojo;

public class City {
private Integer id;
private String cityID;
private String city;
private Province province;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCityID() {
	return cityID;
}
public void setCityID(String cityID) {
	this.cityID = cityID;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Province getProvince() {
	return province;
}
public void setProvince(Province province) {
	this.province = province;
}
@Override
public String toString() {
	return "City [id=" + id + ", cityID=" + cityID + ", city=" + city
			+ ", province=" + province + "]";
}

}
