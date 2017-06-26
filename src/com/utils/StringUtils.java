package com.utils;

public class StringUtils {
	/** 
     * �������ַ��滻Ϊȫ�� 
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
                sb.append('��');// ȫ�Ǵ��ں�  
                break;  
            case '<':  
                sb.append('��');// ȫ��С�ں�  
                break;  
            case '\'':  
                sb.append('��');// ȫ�ǵ�����  
                break;  
            case '\"':  
                sb.append('��');// ȫ��˫����  
                break;  
            case '&':  
                sb.append('��');// ȫ�ǣ�  
                break;  
            case '\\':  
                sb.append('��');// ȫ��б��  
                break;  
            case '/':  
                sb.append('��');// ȫ��б��  
                break;  
            case '#':  
                sb.append('��');// ȫ�Ǿ���  
                break;  
            case '(':  
                sb.append('��');// ȫ��(��  
                break;  
            case ')':  
                sb.append('��');// ȫ��)��  
                break;  
            default:  
                sb.append(c);  
                break;  
            }  
        }  
        return sb.toString();  
    }  
}
