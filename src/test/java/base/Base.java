package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
	
	public Properties prop;
	public Base()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
