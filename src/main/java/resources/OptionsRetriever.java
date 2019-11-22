package resources;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class OptionsRetriever {

	private PropRetriever prop = new PropRetriever();



public ChromeOptions getChromeOptions() {
	
	ChromeOptions options = new ChromeOptions(); 
	if (prop.getProp("headless").contains("true")) {
		options.setHeadless(true);
	}
	options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
	options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	return options;
}

public FirefoxOptions getFireFoxOptions() {
	
	FirefoxOptions options = new FirefoxOptions(); 
	if (prop.getProp("headless").contains("true")) {
		options.setHeadless(true);
	}
	
	options.setLogLevel(FirefoxDriverLogLevel.TRACE);
	options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
	options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	return options;
}


public ChromeOptions getEdgeOptions() {
	
	ChromeOptions options = new ChromeOptions(); 
	options.setBinary(prop.getProp("edgeBinary"));
	if (prop.getProp("headless").contains("true")) {
		options.setHeadless(true);
	}
	options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
	options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	return options;
}




}
