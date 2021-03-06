package com.pojo;

import java.io.Serializable;
import java.util.List;

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
	private Integer cartNumber;//商品在购物车中的数量
	private Integer cartFlag;//商品在购物车中是否被选中
	private List<String> serviceType;
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
	
	
	
	public Integer getCartFlag() {
		return cartFlag;
	}
	public Integer getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(Integer cartNumber) {
		this.cartNumber = cartNumber;
	}
	public void setCartFlag(Integer cartFlag) {
		this.cartFlag = cartFlag;
	}
	public List<String> getServiceType() {
		return serviceType;
	}
	public void setServiceType(List<String> serviceType) {
		this.serviceType = serviceType;
	}
	@Override
	public String toString() {
		return "GoodInfo [goodId=" + goodId + ", styleId=" + styleId + ", goodName=" + goodName + ", goodOriginalPrice="
				+ goodOriginalPrice + ", goodPicPath=" + goodPicPath + ", goodDiscountedPrice=" + goodDiscountedPrice
				+ ", goodDesc=" + goodDesc + ", specification=" + specification + ", freeDelivery=" + freeDelivery
				+ ", salsNum=" + salsNum + ", goodStatus=" + goodStatus + ", cartNumber=" + cartNumber + ", cartFlag="
				+ cartFlag + ", serviceType=" + serviceType + "]";
	}
	
	
}