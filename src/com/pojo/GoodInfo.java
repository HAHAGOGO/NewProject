package com.pojo;

import java.io.Serializable;

import com.sun.javafx.collections.MappingChange.Map;

public class GoodInfo implements Serializable{
	private Integer goodId;
	private Integer styleId;
	private String goodName;
	private Double goodOriginalPrice;
	private String goodPicPath;
	private Double goodDiscountedPrice;
	private String goodDesc;
	private String specification;
	private String freeDelivery;
	private Integer salsNum;
	private String goodStatus;
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public Integer getStyleId() {
		return styleId;
	}
	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Double getGoodOriginalPrice() {
		return goodOriginalPrice;
	}
	public void setGoodOriginalPrice(Double goodOriginalPrice) {
		this.goodOriginalPrice = goodOriginalPrice;
	}
	public String getGoodPicPath() {
		return goodPicPath;
	}
	public void setGoodPicPath(String goodPicPath) {
		this.goodPicPath = goodPicPath;
	}
	public Double getGoodDiscountedPrice() {
		return goodDiscountedPrice;
	}
	public void setGoodDiscountedPrice(Double goodDiscountedPrice) {
		this.goodDiscountedPrice = goodDiscountedPrice;
	}
	public String getGoodDesc() {
		return goodDesc;
	}
	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	public Integer getSalsNum() {
		return salsNum;
	}
	public void setSalsNum(Integer salsNum) {
		this.salsNum = salsNum;
	}
	public String getGoodStatus() {
		return goodStatus;
	}
	public void setGoodStatus(String goodStatus) {
		this.goodStatus = goodStatus;
	}
	@Override
	public String toString() {
		return "GoodInfo [goodId=" + goodId + ", styleId=" + styleId + ", goodName=" + goodName + ", goodOriginalPrice="
				+ goodOriginalPrice + ", goodPicPath=" + goodPicPath + ", goodDiscountedPrice=" + goodDiscountedPrice
				+ ", goodDesc=" + goodDesc + ", specification=" + specification + ", freeDelivery=" + freeDelivery
				+ ", salsNum=" + salsNum + ", goodStatus=" + goodStatus + "]";
	}
	
}
