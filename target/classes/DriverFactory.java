package resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public synchronized void newDriver() throws MalformedURLException {

		final PropRetriever prop = new PropRetriever();
		final String browserName = prop.getProp("browser");
		//final String browserName = System.getProperty("browser");
		final String remote = prop.getProp("remote");
		final String grid = prop.getProp("grid");
		final OptionsRetriever optRet = new OptionsRetriever();
	
		

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString()
					+ prop.getProp("chromedriver"));
			ChromeOptions options = optRet.getChromeOptions();
			if (remote.contains("true")) {
				try {
					driver.set(new RemoteWebDriver(new URL(grid),options));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
		
			driver.set(new ChromeDriver(options));
			}
		} else if (browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir").toString()
					+ prop.getProp("geckodriver"));
			FirefoxOptions options = optRet.getFireFoxOptions();
			if (remote.contains("true")) {
				try {
					driver.set(new RemoteWebDriver(new URL(grid),options));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
			driver.set(new FirefoxDriver(options));
			}
		}else if (browserName.contains("edge")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString()
					+ prop.getProp("msedgedriver"));
			ChromeOptions options = optRet.getEdgeOptions();
			driver.set(new ChromeDriver(options));
		}
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	

	public synchronized WebDriver getDriver() {
		return driver.get();
	}
}
