package com.easydays.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBaseCredential {

	private static Properties properties = null;

	private static Properties getProperties() throws IOException {
		if (properties == null) {
			InputStream i = DataBaseCredential.class.getResourceAsStream("/database.properties");
			properties = new Properties();
			properties.load(i);
			i.close();
		}
		return properties;
	}

	public static String getProperty(String key) {
		try {
			return getProperties().getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}
}
