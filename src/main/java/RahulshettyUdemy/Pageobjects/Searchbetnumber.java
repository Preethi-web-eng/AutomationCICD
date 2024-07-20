package RahulshettyUdemy.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyUdemy.AbstractComponents.AbstractComponent;


public class Searchbetnumber extends AbstractComponent {
	WebDriver driver;

	public Searchbetnumber(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
				
	}

	
	
	
	@FindBy (xpath="//*[@type='text'] [@placeholder='Search By Bet Number']")
    WebElement Searchwithbetnumber;
 
 @FindBy (id="searchButtonId")
    WebElement clicksearchbutton;

public Cancelbetoperation Searchbets(String betnumber) {
	
	 Searchwithbetnumber.sendKeys(betnumber);
	clicksearchbutton.click();
	Cancelbetoperation cb=new Cancelbetoperation(driver);
	return cb;
	
}
}
