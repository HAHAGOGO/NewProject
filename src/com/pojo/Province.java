package com.pojo;

public class Province {
private Integer id;
private String provinceID;
private String province;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getProvinceID() {
	return provinceID;
}
public void setProvinceID(String provinceID) {
	this.provinceID = provinceID;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
@Override
public String toString() {
	return "Province [id=" + id + ", provinceID=" + provinceID + ", province="
			+ province + "]";
}


}
