package com.convert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;




public class StringToTimeStamp implements Converter<String,Timestamp> {

	

	@Override
	public Timestamp convert(String arg0) {
		
		Timestamp timestamp = null;
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long time = format.parse(arg0).getTime();
			 timestamp = new Timestamp(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return timestamp;
	}

}
