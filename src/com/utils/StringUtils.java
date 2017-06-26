package com.utils;

public class StringUtils {
	/** 
     * 将特殊字符替换为全角 
     * @param s 
     * @return 
     */  
    public static  String convertString(String s) {  
        if (s == null || s.isEmpty()) {  
            return s;  
        }  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < s.length(); i++) {  
            char c = s.charAt(i);  
            switch (c) {  
            case '>':  
                sb.append('＞');// 全角大于号  
                break;  
            case '<':  
                sb.append('＜');// 全角小于号  
                break;  
            case '\'':  
                sb.append('‘');// 全角单引号  
                break;  
            case '\"':  
                sb.append('“');// 全角双引号  
                break;  
            case '&':  
                sb.append('＆');// 全角＆  
                break;  
            case '\\':  
                sb.append('＼');// 全角斜线  
                break;  
            case '/':  
                sb.append('／');// 全角斜线  
                break;  
            case '#':  
                sb.append('＃');// 全角井号  
                break;  
            case '(':  
                sb.append('（');// 全角(号  
                break;  
            case ')':  
                sb.append('）');// 全角)号  
                break;  
            default:  
                sb.append(c);  
                break;  
            }  
        }  
        return sb.toString();  
    }  
}
