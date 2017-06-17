package com.pojo;

import java.io.Serializable;

public class GoodImage implements Serializable{
	private Integer imageId;
	private Integer goodId;
	private String picPath;
	private String picStatus;
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getPicStatus() {
		return picStatus;
	}
	public void setPicStatus(String picStatus) {
		this.picStatus = picStatus;
	}
	
}
