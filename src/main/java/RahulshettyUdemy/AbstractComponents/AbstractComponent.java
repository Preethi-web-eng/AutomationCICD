package RahulshettyUdemy.AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {
	WebDriver driver;
	 
	public AbstractComponent(WebDriver driver) {
		  
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitforelement() throws InterruptedException
	{
		Thread.sleep(2000);
	}
}
