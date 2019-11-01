package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	private By emailText = By.xpath("//*[@id='user_email']");
	private By passwordText = By.xpath("//*[@id='user_password']");
	private By loginBtn = By.xpath("//input[@value= 'Log In']");
	
	public WebElement getEmail() {
		return driver.findElement(emailText);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passwordText);
	}
	
	public WebElement getLogin() {
		return driver.findElement(loginBtn);
	}
}
