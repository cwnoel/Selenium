package jQueryUISeleniumTests.JQueryUI;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.InteractionsSectionPage;
import pageObjects.JqueryuiPage;
import resources.DriverFactory;

public class Interactions extends DriverFactory {
	private Logger log = LogManager.getLogger();
	private WebDriver driver;
	private JqueryuiPage jqPage;
	private InteractionsSectionPage isp;
	private Actions myAct;

	@BeforeTest
	public void testSetup()   {
		newDriver();
		driver = getDriver();
		jqPage = new JqueryuiPage(driver);
		isp = new InteractionsSectionPage(driver);
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
	public void test001_Draggable() {
		driver.get("https://jqueryui.com/");
		jqPage.getDraggable().click();
		jqPage.switchToDemoFrame();
		WebElement dragItem = isp.getDragItem();
		int start = dragItem.getLocation().x;
		log.info("Starting position Xcoord: " + start);
		myAct.clickAndHold(dragItem).moveByOffset(50, 0).perform();
		int end = dragItem.getLocation().x;
		log.info("Ending position Xcoord: " + end);
		assertTrue(end - start == 50);
		log.info("Item moved to correct destination");
		if(getBrowser().contentEquals("firefox")) {
		driver.quit();	
		testSetup();
		}
	}
	@Test (enabled=true)
	public void test002_Droppable() {
		driver.get("https://jqueryui.com/");
		jqPage.getDroppable().click();
		jqPage.switchToDemoFrame();
		WebElement dragItem = isp.getDragItem2();
		WebElement dropToItem = isp.getDropToItem();
		int start = dragItem.getLocation().x;
		int dest = dropToItem.getLocation().x;
		log.info("Starting position Xcoord: " + start);
		log.info("Destination position Xcoord: " + dest);
		myAct.dragAndDrop(dragItem, dropToItem).perform();
		int end = dragItem.getLocation().x;
		log.info("Ending position Xcoord: " + end);
		Assert.assertTrue(dropToItem.getText().contains("Dropped!"));
		log.info("Item Dropped to correct location");

	}
	

	@Test (enabled=true)
	public void test003_Resizable(){
		driver.get("https://jqueryui.com/");
		jqPage.getResizable().click();
		jqPage.switchToDemoFrame();
		WebElement resizeHandle = isp.getResizeHandle();
		WebElement resizeWindow = isp.getResizeWindow();
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
	
	@Test (enabled=true)
	public void test004_Selectable(){
		driver.get("https://jqueryui.com/");
		jqPage.getSelectable().click();
		jqPage.switchToDemoFrame();
		WebElement item2 = isp.getSelectable2();
		item2.click();
		Assert.assertTrue(item2.getAttribute("class").contains("ui-selected"));
		log.info("Item 2 was selected");
	}
	
	
	
	@Test (enabled=true)
	public void test005_Sortable(){
		driver.get("http://jqueryui.com");
		jqPage.getSortable().click();
		jqPage.switchToDemoFrame();
		WebElement sortItem1 = isp.getSortItem1();
		System.out.println("Original order: ");
		isp.printSortItems();
		myAct.dragAndDropBy(sortItem1, 0,50).perform();
		System.out.println("Order after sort: ");
		isp.printSortItems();
		ArrayList<WebElement> sorted = isp.getSortItems();
		Assert.assertTrue(sorted.get(0).getText().contentEquals("Item 2"));
		log.info("Item 2 was successfully moved to Item 1's position");
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
