package RahulshettyUdemy.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulshettyUdemy.Pageobjects.Cancelbetoperation;

import RahulshettyUdemy.Pageobjects.Logout;
import RahulshettyUdemy.Pageobjects.Searchbetnumber;
import RahulshettyUdemy.TestComponents.Base;


public class Cancelbets extends Base {
	 //String betnumber="1ZKS4594KK";
	              
               
	             @Test(dataProvider="getData",groups= {"Cancelbets"})
				public void Cancelbets(HashMap<String,String> input) throws IOException, InterruptedException
				{
			    Searchbetnumber sb=login.Loginintoappl(input.get("username"), input.get("password"));
			    Cancelbetoperation cb=sb.Searchbets(input.get("betnumber"));
				Logout logout=cb.cancellingbet("test");
				logout.logout();
				}

				
				/*
				 * @DataProvider public Object[][] getData() { return new Object[][]
				 * {{"s.c.Bct.Admin","Welcome@1234","1ZKS4594KK"}
				 * ,{"s.c.Bct.User","Welcome@12345","1ZKS4594KK"}}; }
				 */
				 
	             @DataProvider
	             public Object[][] getData() throws IOException   
	             {
						/*
						 * HashMap<String,String> map=new HashMap<String,String>(); map.put("username",
						 * "s.c.Bct.Admin"); map.put("password", "Welcome@1234"); map.put("betnumber",
						 * "1ZKS4594KK");
						 * 
						 * HashMap<String,String> map1=new HashMap<String,String>();
						 * map1.put("username", "s.c.Bct.User"); map1.put("password", "Welcome@12345");
						 * map1.put("betnumber", "1ZKS4594KK");
						 */
	            	 List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\RahulshettyUdemy\\Data\\Cancelbets.json");
	            	 return new Object[][] {{data.get(0)},{data.get(1)}};
	             }
	             
	             
				
				
				
				
		  
	

}
