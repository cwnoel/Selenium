package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WidgetsSectionPage {
	
	
	private WebDriver driver;

	public WidgetsSectionPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private By section2 = By.id("ui-id-3");
	
	private By section2Text = By.cssSelector("#ui-id-4 p"); 
	
	
	
	public WebElement getSection2 () {
		return driver.findElement(section2);
		
	}
	
	public WebElement getSection2Text() {
		return driver.findElement(section2Text);
	}
	
	

}
