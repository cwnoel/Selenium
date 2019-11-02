package SeleniumTests.MultithreadedSelenium;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.DriverFactory;
import resources.PropRetriever;

public class GoogleTest extends DriverFactory{
	private PropRetriever props = new PropRetriever();
	private Logger log = LogManager.getLogger();
	//DriverFactory drvFact = new DriverFactory();
	//private WebDriver driver;
	 
	
	
	
	
	@BeforeMethod
    public void setup() throws IOException {
      newDriver();
    }
	
	

    @Test
    public void test1() {
    	WebDriver driver = getDriver();
        driver.navigate().to("https:\\www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void test2() {
    	WebDriver driver = getDriver();
        driver.navigate().to("https:\\www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    
    @Test
    public void test3() {
    	WebDriver driver = getDriver();
        driver.navigate().to("https:\\www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void test4() {
    	WebDriver driver = getDriver();
        driver.navigate().to("https:\\www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    
    @Test
    public void test5() {
    	WebDriver driver = getDriver();
        driver.navigate().to("https:\\www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    
    @Test(dataProvider = "dp")
	public void TestvalidateLogInTest(String email, String password, String text) throws IOException, InterruptedException {
        WebDriver driver = getDriver();
		driver.get(props.getProp("url"));
		log.info("Navigated to Home Page");
		LandingPage lp = new LandingPage(driver);
		try {
		lp.getNoThanks().click();
		} catch (NoSuchElementException e) {
			System.out.println("\"NO THANKS\" button was not found.");
		 }
		
		lp.getLogin().click();

		LoginPage logP = new LoginPage(driver);
		logP.getEmail().sendKeys(email);
		log.info("Entered email");
		logP.getPassword().sendKeys(password);
		log.info("Entered password");
		log.info(text);
		logP.getLogin().click();
	}

	@DataProvider(name = "dp")
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456789";
		data[1][2] = "Non Restricted User";

		return data;
	}

    @AfterMethod
    public void tearDown() {
       
        WebDriver driver = getDriver();
        driver.quit();
    }
    
}
