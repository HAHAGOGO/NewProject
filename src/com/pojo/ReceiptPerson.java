
package com.pojo;

public class ReceiptPerson {
	private Integer pid;
	private String pname;
	private String phone;
	private Integer userid;
	private Area area;
	private String addressinfo;
	private String status;
	private Integer areaid;
	
	public Integer getAreaid() {
		return areaid;
	}
	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getAddressinfo() {
		return addressinfo;
	}
	public void setAddressinfo(String addressinfo) {
		this.addressinfo = addressinfo;
	}
	
	@Override
	public String toString() {
		return "ReceiptPerson [pid=" + pid + ", pname=" + pname + ", phone="
				+ phone + ", userid=" + userid + ", area=" + area
				+ ", addressinfo=" + addressinfo + ", status=" + status
				+ ", areaid=" + areaid + "]";
	}
	
	

}
