package com.easydays.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MsgUtil {

	private static MsgUtil msgUtil;

	private MsgUtil() {
	    Properties props = new Properties();  
	    String path = getClass().getResource("/language_pt_BR.properties").getPath();  
	    File file = new File(path);  
	    try {  
	    	FileInputStream fis = new FileInputStream(file);
	    	props.load(fis);
	    	} catch (Exception e) {
				
			}
	}

	public static MsgUtil getInstance() {
		if (msgUtil == null) {
			msgUtil = new MsgUtil();
		}
		return msgUtil;
	}

}
