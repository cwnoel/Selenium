package jQueryUISeleniumTests.JQueryUI;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.JqueryuiPage;
import pageObjects.WidgetsSectionPage;
import resources.DriverFactory;

public class Widgets extends DriverFactory {
	private Logger log = LogManager.getLogger();
	private WebDriver driver;
	private JqueryuiPage jqPage;
	private WidgetsSectionPage wsp;
	private Actions myAct;

	@BeforeTest
	public void testSetup()   {
		newDriver();
		driver = getDriver();
		jqPage = new JqueryuiPage(driver);
		wsp = new WidgetsSectionPage(driver);
		myAct = new Actions(driver);
	}
	
//	@BeforeMethod
//	public void testSetup() throws MalformedURLException  {
//		newDriver();
//		driver = getDriver();
//		jqPage = new JqueryuiPage(driver);
//		isp = new InteractionsSectionPage(driver);
//		myAct = new Actions(driver);
//	}

	
	
	@Test (enabled=true )
	public void test001_Accordion() throws InterruptedException {
		driver.get("https://jqueryui.com/");
		jqPage.getAccordion().click();
		jqPage.switchToDemoFrame();
		wsp.getSection2().click();
		System.out.println(wsp.getSection2Text().getText());
		Assert.assertTrue(wsp.getSection2Text().getText().contains("Sed non urna."));
		log.info("Opened Section2 successfully");
		}
	
	
		
		
	@AfterMethod (enabled=true)
	public void getScreenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
		//	Dimension size = driver.manage().window().getSize();
		//	driver.manage().window().fullscreen();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println(System.getProperty("user.dir").toString() + "\\screenshots\\" + result.getName()
					+ "_screenshot.png");
			FileUtils.copyFile(src, new File(System.getProperty("user.dir").toString() + "\\screenshots\\"
					+ result.getName() + "_screenshot.png"));
		//	driver.manage().window().setSize(size);
		}
		
	}
		
	
	

	@AfterTest
	public void cleanup(){
		driver.quit();

	}

}
