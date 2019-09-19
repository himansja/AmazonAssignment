package qa.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static Properties prop;
	String projectPath;
	public ConfigFileReader(String projectPath) {
		this.projectPath = projectPath;
	}

	public void loadPropertiesFile() {

		try {
			File propertyFile = new File(projectPath+ "/GlobalConfig/config.properties");
			FileInputStream fis = new FileInputStream(propertyFile);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("Config Properties File not Found at " +projectPath+ "/GlobalConfig");

		} catch (IOException e) {
			System.out.println("Properties file not loaded");
			e.printStackTrace();
		}
	}

	public String getApplicationName() {
		String appName =prop.getProperty("ApplicationName");
		if(appName != null && appName != "") {
			return appName;
		}
		else
			throw new RuntimeException("ApplicationName value is not specified");
	}
	
	public String getAppURL() {
		String URL =prop.getProperty("URL");
		if(URL != null && URL != "") {
			return URL;
		}
		else
			throw new RuntimeException("URL is not specified");
	}

	public String getBrowser() {
		String browser = prop.getProperty("Browser");
		if(browser != null && browser !="") {
			return browser;
		}
		else 
			throw new RuntimeException("Browser is not specifed");
	}

	public String getUserName() {
		String username = prop.getProperty("username");
		if(username != null && username != "") {
			return username;
		}
		else
			throw new RuntimeException("Username not specified in config file");
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		if(password != null && password != "") {
			return password;
		}
		else
			throw new RuntimeException("password not specified in config file");
	}


}
