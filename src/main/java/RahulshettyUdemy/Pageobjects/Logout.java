package RahulshettyUdemy.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyUdemy.AbstractComponents.AbstractComponent;

public class Logout extends AbstractComponent {
WebDriver driver;
	
	public Logout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	     @FindBy (xpath="//span[@class='anticon anticon-down']")
	     WebElement clickonarrow;
	     
	     @FindBy (xpath="//span[text()='Logout']")
	     WebElement clickonlogout;
	     
	     public void logout() {
	    	 clickonarrow.click();
	    	 clickonlogout.click();
	    	 
	     }
}
