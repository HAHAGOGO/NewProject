package com.cloopen.message;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSDK;

public class SendMessage {
public static String sendMessage(String phone){
	HashMap<String, Object> result = null; 
	 CCPRestSDK restAPI = new CCPRestSDK();
	 restAPI.init("app.cloopen.com", "8883");
	 // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883. 
	 restAPI.setAccount("8a216da85c62c9ad015ca5f55f1d17e3", "77467f5323704b68b44252fc22e9f6bd");
	 // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
	 restAPI.setAppId("8a216da85c62c9ad015ca5f55f5517e7");
	 // 请使用管理控制台中已创建应用的APPID。
	 Random random = new Random();
	 String string="1234567890";
	 String code="";
	 for(int i=0;i<4;i++){
		 
		 code+=string.charAt(random.nextInt(10));
	 }
	 result = restAPI.sendTemplateSMS(phone,"1" ,new String[]{code,"3"});
	 System.out.println("SDKTestGetSubAccounts result=" + result); 
	 if("000000".equals(result.get("statusCode"))){
	 //正常返回输出data包体信息（map）
	 HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
				Set<String> keySet = data.keySet();
	 for(String key:keySet){ 
	 Object object = data.get(key); 
	 System.out.println(key +" = "+object); 
	 }
	 }else{
	 //异常返回输出错误码和错误信息
	 System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
	 }
	return code;
}
}
