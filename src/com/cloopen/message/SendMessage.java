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
	 // ��ʼ����������ַ�Ͷ˿ڣ������������ó�app.cloopen.com���˿���8883. 
	 restAPI.setAccount("8a216da85c62c9ad015ca5f55f1d17e3", "77467f5323704b68b44252fc22e9f6bd");
	 // ��ʼ�����˺����ƺ����˺����ƣ���½��ͨѶ��վ�󣬿��ڿ�����ҳ�п������������˺�ACCOUNT SID�����˺�����AUTH TOKEN��
	 restAPI.setAppId("8a216da85c62c9ad015ca5f55f5517e7");
	 // ��ʹ�ù������̨���Ѵ���Ӧ�õ�APPID��
	 Random random = new Random();
	 String string="1234567890";
	 String code="";
	 for(int i=0;i<4;i++){
		 
		 code+=string.charAt(random.nextInt(10));
	 }
	 result = restAPI.sendTemplateSMS(phone,"1" ,new String[]{code,"3"});
	 System.out.println("SDKTestGetSubAccounts result=" + result); 
	 if("000000".equals(result.get("statusCode"))){
	 //�����������data������Ϣ��map��
	 HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
				Set<String> keySet = data.keySet();
	 for(String key:keySet){ 
	 Object object = data.get(key); 
	 System.out.println(key +" = "+object); 
	 }
	 }else{
	 //�쳣�������������ʹ�����Ϣ
	 System.out.println("������=" + result.get("statusCode") +" ������Ϣ= "+result.get("statusMsg"));
	 }
	return code;
}
}
