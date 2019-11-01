package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropRetriever {
	private Logger log = LogManager.getLogger();
	private Properties prop = new Properties();

	public String getProp(String property) {

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir").toString() + "\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			log.error("Could not locate properties file");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Could not open properties file for unknown reason");
			e.printStackTrace();
		}

		return prop.getProperty(property);

	}

}
