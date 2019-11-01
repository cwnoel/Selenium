package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By signIn = By.cssSelector("[href*='sign_in']");
	private By noThanksBtn = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header = By.xpath("//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']/h3");
	
	public WebElement getLogin() {
		return driver.findElement(signIn);
	}

	public WebElement getNoThanks() {
		return driver.findElement(noThanksBtn);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
