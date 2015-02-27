package com.bjj.tools;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;
/**
 * 
 * @author JiangLi
 *
 * CreateTime 2013-8-16 上午10:32:22
 */
@Component
public class PropertiesUtil {
	private InputStream in;
	//private static String filePath=PropertiesUtil.class.getClassLoader().getResource("com/bingdian/resource/swicher.properties").getFile();
	private InputStream filePath = PropertiesUtil.class.getClassLoader().getResourceAsStream("com/bjj/resources/props/mail.properties");
	private Properties props;
	
	public PropertiesUtil(){
		props = new Properties();
		try {
			in = new BufferedInputStream(filePath);
			props.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readStringValue(String key){
		return props.getProperty(key);
	}
	
	public int readIntValue(String key){
		return Integer.parseInt(props.getProperty(key));
	}
	
	public String[] readStringArray(String key, String regex){
		String val = props.getProperty(key);
		String[] result = val.split(regex);
		return result;
	}
}
