package com.pojo;

import java.io.Serializable;

public class GoodStyle implements Serializable{
	private Integer styleId;
	private String styleName;
	public Integer getStyleId() {
		return styleId;
	}
	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	
}
