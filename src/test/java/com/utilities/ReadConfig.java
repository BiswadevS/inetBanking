package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	
	//load the complete config file
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//read
	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	

}
