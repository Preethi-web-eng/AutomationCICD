package RahulshettyUdemy.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyUdemy.AbstractComponents.AbstractComponent;

public class Login extends AbstractComponent {
	public WebDriver driver;

	public Login(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
				
	}
	
	 @FindBy (id="Input_Username")
	 WebElement username;
     
     @FindBy (id="Input_Password")
	 WebElement password;
     
     
     @FindBy (xpath="//button[@name='Input.Button']")
	  WebElement Loginbutton;
     
     @FindBy (css=".alert-danger")
	  WebElement errormessage;
     
     public  Searchbetnumber Loginintoappl(String Username,String Password )
     {
    	 username.sendKeys(Username);
 	    password.sendKeys(Password);
 	    Loginbutton.click();
 	   Searchbetnumber sb=new Searchbetnumber(driver);
 	   return sb;
     }
     
     public void url()
     {
    	 driver.get("http://bctui.test.env.works/");
     }
     
     public String Errormessagevalidation()
 	{
 		return errormessage.getText();
 		
 	}
     
}
