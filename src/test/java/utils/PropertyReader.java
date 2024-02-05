package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {

	
	public Properties readProperty(){
		Properties prop = new Properties();
		File file =new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigReader.properties");
		try {
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
