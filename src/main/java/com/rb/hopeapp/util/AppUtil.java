package com.rb.hopeapp.util;

import java.util.Date;

import org.joda.time.DateTime;

public class AppUtil {

	private static AppUtil instance;
	
	public Date getCurrentDate() {
		return new DateTime().toDate();
	}
	
	public String getUser() {
		return "admin";
	}
	
	
	public static AppUtil getInstance() {
		if (instance==null) {
			instance = new AppUtil();
		}
		return instance;
	}
	
	
}
