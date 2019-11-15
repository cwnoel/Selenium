package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JqueryuiPage {
	
	
	private WebDriver driver;

	public JqueryuiPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private By draggable = By.xpath("//a[contains(text(),'Draggable')]");
	private By droppable = By.xpath("//a[contains(text(),'Droppable')]");
	private By resizable = By.xpath("//a[contains(text(),'Resizable')]");
	private By selectable = By.xpath("//a[contains(text(),'Selectable')]");
	private By sortable = By.xpath("//a[contains(text(),'Sortable')]");
	private By demoFrame = By.xpath("//iframe[@class='demo-frame']");
	
	public WebElement getDraggable() {
		return driver.findElement(draggable);
		
	}	
	public WebElement getDroppable() {
		return driver.findElement(droppable);
		
	}
	
	public WebElement getResizable() {
		return driver.findElement(resizable);
		
	}
	
	public WebElement getSelectable() {
		return driver.findElement(selectable);
		
	}
	
	public WebElement getSortable() {
		return driver.findElement(sortable);
		
	}
	
	public WebElement getDemoFrame () {
		return driver.findElement(demoFrame);
	}
	
	public void switchToDemoFrame() {
		driver.switchTo().frame(getDemoFrame());
	}
}
