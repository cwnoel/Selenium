package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JqueryuiPage {
	
	
	private WebDriver driver;

	public JqueryuiPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private By draggable = By.xpath("//aside[@class='widget']/ul/li/a[contains(text(),'Draggable')]");
	private By droppable = By.xpath("//aside[@class='widget']/ul/li/a[contains(text(),'Droppable')]");
	private By dragItem = By.id("Draggable");
	
	
	
	
	
	
	
	
	
	
	public WebElement getDraggable() {
		return driver.findElement(draggable);
		
	}
	
	public WebElement getDroppable() {
		return driver.findElement(droppable);
		
	}
	
	public WebElement getDragItem () {
		return driver.findElement(dragItem);
	}

}
