package SeleniumTests.MultithreadedSelenium;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DraggablePage;
import pageObjects.JqueryuiPage;
import resources.DriverFactory;

public class Interactions extends DriverFactory {
	private Logger log = LogManager.getLogger();
	public WebDriver driver;

	
	@BeforeTest
	public void testSetup() throws MalformedURLException {
		newDriver();
		driver = getDriver();
	}

	@Test
	public void testDraggable() {
		driver.get("https://jqueryui.com/");
		JqueryuiPage jqPage = new JqueryuiPage(driver);
		jqPage.getDraggable().click();
		Actions myAct = new Actions(driver);
		DraggablePage dp = new DraggablePage(driver);
		driver.switchTo().frame(dp.getDemoFrame());
		WebElement dragItem = dp.getDragItem();
		int start = dragItem.getLocation().x;
		log.info("Starting position Xcoord: " + start);
		myAct.clickAndHold(dragItem).moveByOffset(50, 0).perform();
		int end = dragItem.getLocation().x;
		log.info("Ending position Xcoord: " + end);
		assertTrue(end - start == 50);
		log.info("Item moved to correct destination");

	}
	
	@Test
	public void testDroppable() {
		driver.navigate().back();
		JqueryuiPage jqPage = new JqueryuiPage(driver);
		jqPage.getDroppable().click();
		Actions myAct = new Actions(driver);
		DraggablePage dp = new DraggablePage(driver);
		driver.switchTo().frame(dp.getDemoFrame());
		WebElement dragItem = dp.getDragItem();
		WebElement dropToItem = dp.getDropToItem();
		int start = dragItem.getLocation().x;
		log.info("Starting position Xcoord: " + start);
		myAct.dragAndDrop(dragItem, dropToItem).perform();
		int end = dragItem.getLocation().x;
		log.info("Ending position Xcoord: " + end);
		Assert.assertTrue(dropToItem.getText().contains("Dropped!"));
		log.info("Item Dropped to correct location");

	}
	
	@AfterTest
	public void cleanup() throws MalformedURLException {
		driver.quit();
		
	}

}
