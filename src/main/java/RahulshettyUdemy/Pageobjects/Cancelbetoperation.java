package RahulshettyUdemy.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyUdemy.AbstractComponents.AbstractComponent;



public class Cancelbetoperation extends AbstractComponent{
WebDriver driver;
	 
	public Cancelbetoperation(WebDriver driver) {
		  super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	     @FindBy (xpath="(//div[@class='ant-table-content']//input[@type='checkbox'])[1]")
	     WebElement selectcheckbox;
	     
	     @FindBy (id="actionsDrop")
	     WebElement clickonactiondropdown;
	     
	     @FindBy (xpath="//*[@title='Cancel bets']")
	     WebElement selectcancelbets;
	     
	     @FindBy (xpath="//*[@id='reason'][@name='reason']")
	     WebElement clickonreasondropdown;
	     
	     @FindBy (xpath="//*[@title='Late bet']")
	     WebElement selectreasonlatebet;
	     
	     @FindBy (xpath="//*[@id='comments']")
	     WebElement comments;
	     
	     
	     @FindBy (xpath="//span[text()=' OK ']")
	     WebElement selectokbutton;
	     
	     @FindBy (xpath="//span[text()=' OK ']")
	     WebElement clickokbutton;
	     
	     
	
	public Logout cancellingbet(String comment) throws InterruptedException {
		selectcheckbox.click();	
		clickonactiondropdown.click();
		selectcancelbets.click();
		clickonreasondropdown.click();
		selectreasonlatebet.click();
		comments.sendKeys(comment);
		waitforelement();
		selectokbutton.click();
		waitforelement();
		clickokbutton.click();
		Logout logout=new Logout(driver);
		return logout;
		
		
		
		
	}

}
