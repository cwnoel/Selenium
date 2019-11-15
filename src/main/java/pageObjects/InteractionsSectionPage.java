package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	private By sortItem1 = By.cssSelector("#sortable > li:nth-child(1)");
	private By sortItem2 = By.cssSelector("#sortable > li:nth-child(2)");
	private By sortItems = By.cssSelector(".ui-sortable-handle");
	
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
	
	public WebElement getSortItem1() {
		return driver.findElement(sortItem1);
	}
	
	public WebElement getSortItem2() {
		return driver.findElement(sortItem2);
	}
	
	public ArrayList<WebElement>  getSortItems() {

		ArrayList<WebElement> items = new ArrayList<WebElement>();		
		items = (ArrayList<WebElement>) driver.findElements(sortItems);
		
		return items;
	}
	
	public void  printSortItems() {

		ArrayList<WebElement> items = new ArrayList<WebElement>();		
		items = (ArrayList<WebElement>) driver.findElements(sortItems);
		for(WebElement e: items) {
			System.out.println(e.getText());
		}
		
	}

}
