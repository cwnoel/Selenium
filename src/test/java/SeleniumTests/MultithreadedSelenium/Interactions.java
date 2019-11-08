package SeleniumTests.MultithreadedSelenium;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.InteractionsSectionPage;
import pageObjects.JqueryuiPage;
import resources.DriverFactory;

public class Interactions extends DriverFactory {
	private Logger log = LogManager.getLogger();
	private WebDriver driver;
	private JqueryuiPage jqPage;
	private InteractionsSectionPage dp;
	private Actions myAct;

	@BeforeTest
	public void testSetup() throws MalformedURLException {
		newDriver();
		driver = getDriver();
		jqPage = new JqueryuiPage(driver);
		dp = new InteractionsSectionPage(driver);
		myAct = new Actions(driver);
	}

	@Test
	public void testDraggable() {
		driver.get("https://jqueryui.com/");
		jqPage.getDraggable().click();
		jqPage.switchToDemoFrame();
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
		driver.get("https://jqueryui.com/");
		jqPage.getDroppable().click();
		jqPage.switchToDemoFrame();
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

	@Test
	public void testResizable() throws InterruptedException {
		driver.get("https://jqueryui.com/");
		jqPage.getResizable().click();
		jqPage.switchToDemoFrame();
		WebElement resizeHandle = dp.getResizeHandle();
		WebElement resizeWindow = dp.getResizeWindow();
		Dimension start = resizeWindow.getSize();
		log.info("Starting size dimension is: " + start);
		myAct.dragAndDropBy(resizeHandle, 50, 50).perform();
		Dimension end = resizeWindow.getSize();
		log.info("Ending size dimension is: " + end);
		Assert.assertTrue(end.height == start.height + 50);
		log.info("Ending height was correct");
		Assert.assertTrue(end.width == start.width + 50);
		log.info("Ending width was correct");
		log.info("Resize is correct");
	}

	@AfterTest
	public void cleanup() throws MalformedURLException {
		driver.quit();

	}

}
