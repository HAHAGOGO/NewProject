package com.utils;

import java.util.Collection;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonUtil {
	   
    /** 
     * �� Array,list,set ������ Json �� 
     * @return Json �� 
     */  
    public static String arrayToJsonStr(Object objs){  
        JSONArray json = JSONArray.fromObject(objs);  
        return json.toString();  
    }  
      
    /*** 
     * ��javabean�����map���� ������ Json �� 
     * @param obj 
     * @return 
     */  
    public static String objectToJsonStr(Object obj){  
        JSONObject json = JSONObject.fromObject(obj);  
        return json.toString();  
          
    }  
      
    /*** 
     * ��javabean�������map���� ������ Json ��,ʹ��JsonConfig �������� 
     * @param obj 
     * @param config 
     * @return 
     */  
    public static String objectToJsonStr(Object obj, JsonConfig config ){  
//      JsonConfig config = new JsonConfig();  
//      config.setExcludes(new String[] { "name" });             
        JSONObject json = JSONObject.fromObject(obj,config);  
        return json.toString();  
          
    }  
      
    /** 
     * ��  Json �� ������ Array,list,set 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> Collection<T> jsonStrToArray(String jsonStr){  
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);  
        Object array = JSONArray.toArray(jsonArray);  
        return (Collection<T>) array;  
    }  
      
    /** 
     * ��  Json �� ������ Array 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T[] jsonStrToArray(String jsonStr, Class<T> clazz){  
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);  
        return (T[]) JSONArray.toArray(jsonArray,clazz);  
    }  
    /** 
     * ��  Json �� ������ Collection 
     * @return 
     */  
    public static <T> Collection<T> jsonStrToCollection(String jsonStr, Class<T> clazz){  
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);  
        @SuppressWarnings("unchecked")  
        Collection<T>  array = JSONArray.toCollection(jsonArray,clazz);  
        return array;  
    }  
      
    /** 
     * ��  Json �� ������ list  
     * @return 
     */  
    public static <T> List<T> jsonStrToList(String jsonStr, Class<T> clazz){  
        return (List<T>) jsonStrToCollection(jsonStr,clazz);  
    }  
      
    /** 
     * ��  Json �� ������ Map����javabean 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T jsonStrToObject(String jsonStr, Class<T> clazz){  
        JSONObject json = JSONObject.fromObject(jsonStr);  
        Object obj = JSONObject.toBean(json, clazz);  
        return (T) obj;  
    }  
}
