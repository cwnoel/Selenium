package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InteractionsSectionPage {
	
	
	private WebDriver driver;

	public InteractionsSectionPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private By dragItem = By.id("draggable");
	private By dropToItem = By.id("droppable");	
	private By resizeWindow = By.id("resizable");
	private By resizeHandle = By.cssSelector("#resizable .ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se");
	private By selectable2 = By.xpath("//li[contains(text(),'Item 2')]");
	
	
	public WebElement getDragItem () {
		return driver.findElement(dragItem);
	}
	
	public WebElement getDropToItem() {
		return driver.findElement(dropToItem);
	}
	
	public WebElement getResizeWindow() {
		return driver.findElement(resizeWindow);
	}
	
	public WebElement getResizeHandle() {
		return driver.findElement(resizeHandle);
	}
	
	public WebElement getSelectable2() {
		return driver.findElement(selectable2);
	}

}
