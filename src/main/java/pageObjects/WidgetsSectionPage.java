package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WidgetsSectionPage {
	
	
	private WebDriver driver;

	public WidgetsSectionPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private By section2 = By.id("ui-id-3");
	private By section2Text = By.cssSelector("#ui-id-4 p"); 
	private By autoCompleteText = By.cssSelector("#tags");
	private By autoCompleteJava = By.xpath("//li[1]");
	
	
	public WebElement getSection2 () {
		return driver.findElement(section2);
		
	}
	
	public WebElement getSection2Text() {
		WebDriverWait myWait = new WebDriverWait(driver, 2);
		myWait.until(ExpectedConditions.visibilityOf(driver.findElement(section2Text)));
		return driver.findElement(section2Text);
	}
	
	public WebElement getAutoCompleteTextbox() {
		return driver.findElement(autoCompleteText);
	}
	
	public WebElement getAutoCompleteJava() {
		return driver.findElement(autoCompleteJava);
	}
	
	public String getAutoText() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	String value = (String)js.executeScript("return document.getElementById('tags').value;");
	return value;

	}
}
