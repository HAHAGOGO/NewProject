
package com.pojo;
import java.io.Serializable;

public class ExpressSelect implements Serializable{
	private Integer expressid;
	private String  express_name;
	private String express_status;
	
	public Integer getExpressid() {
		return expressid;
	}
	public void setExpressid(Integer expressid) {
		this.expressid = expressid;
	}
	public String getExpress_name() {
		return express_name;
	}
	public void setExpress_name(String express_name) {
		this.express_name = express_name;
	}
	public String getExpress_status() {
		return express_status;
	}
	public void setExpress_status(String express_status) {
		this.express_status = express_status;
	}
	
	
}

