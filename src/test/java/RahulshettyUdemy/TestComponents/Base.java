package RahulshettyUdemy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RahulshettyUdemy.Pageobjects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	 
	public  WebDriver driver;
	public  Login login;
	
	public  WebDriver Initializedriver() throws IOException {
	
	Properties prop=new Properties();
    FileInputStream fis=new FileInputStream("C:\\Preethi\\New Workspace\\Selenium\\src\\main\\java\\RahulshettyUdemy\\Resources\\GlobalData.properties");
    prop.load(fis);
    String browsername=System.getProperty("browser") != null?  System.getProperty("browser") :prop.getProperty("browser");
   
    
    if(browsername.contains("chrome"))
    {
    ChromeOptions options=new ChromeOptions();
	WebDriverManager.chromedriver().setup();
    if(browsername.contains("headless")) {
    options.addArguments("headless");
    }
	 driver=new ChromeDriver();
	 driver.manage().window().setSize(new Dimension(1440,900));
    }
    
    else if(browsername.equals("firefox"))
    {
    	  System.setProperty("WebDriver.gecko.driver", "C:\\Preethi\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
    	   driver=new FirefoxDriver();
   
    		}
    		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	return driver;
}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//Reading json to string
		String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		//converting string to hashmap to do that we need external utility called jackson bind
		ObjectMapper map=new ObjectMapper();
		List<HashMap<String,String>> data=map.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
	return data;
		
	}
	

	
	public String Takescreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	@BeforeMethod(alwaysRun=true)
	public  Login LaunchApp() throws IOException {
		driver=Initializedriver();
		 login=new Login(driver);
		login.url();
		return login;
		
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.quit();
	}

}