package com.pojo;

import java.io.Serializable;

public class TurnImage implements Serializable{
	private Integer turnId;
	private String turnTitle;
	private String imagePath;
	private String imageLink;
	private String imageStatus;
	public Integer getTurnId() {
		return turnId;
	}
	public void setTurnId(Integer turnId) {
		this.turnId = turnId;
	}
	public String getTurnTitle() {
		return turnTitle;
	}
	public void setTurnTitle(String turnTitle) {
		this.turnTitle = turnTitle;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getImageStatus() {
		return imageStatus;
	}
	public void setImageStatus(String imageStatus) {
		this.imageStatus = imageStatus;
	}
	
}
