package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DraggablePage {
	
	
	private WebDriver driver;

	public DraggablePage (WebDriver driver) {
		this.driver = driver;
	}
	
	
	private By dragItem = By.id("draggable");
	private By demoFrame = By.xpath("//iframe[@class='demo-frame']");
	
//	private By dragItem = By.id("draggable");
	private By dropToItem = By.id("droppable");
//	private By demoFrame = By.xpath("//iframe[@class='demo-frame']");
	
	public WebElement getDragItem () {
		return driver.findElement(dragItem);
	}
	
	public WebElement getDemoFrame () {
		return driver.findElement(demoFrame);
	}
	
	public WebElement getDropToItem() {
		return driver.findElement(dropToItem);
	}

}
