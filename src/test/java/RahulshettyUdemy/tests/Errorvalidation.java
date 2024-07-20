package RahulshettyUdemy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import RahulshettyUdemy.TestComponents.Base;

public class Errorvalidation extends Base{
	
	
	@Test
	public  void loginerror()
	{
	login.Loginintoappl("s.c.Bct.Admin", "Welcome@1234");
	Assert.assertEquals("Invalid username or password", login.Errormessagevalidation());

}
	
	
}
