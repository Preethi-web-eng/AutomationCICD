package RahulshettyUdemy.stepDefinitions;

import java.io.IOException;

import RahulshettyUdemy.Pageobjects.Cancelbetoperation;
import RahulshettyUdemy.Pageobjects.Login;
import RahulshettyUdemy.Pageobjects.Searchbetnumber;
import RahulshettyUdemy.TestComponents.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cancelbetsstepdef extends Base {
    public Login login;
    public Searchbetnumber Searchbets;
    public Cancelbetoperation cancellingbet;
    
    @Given("I landed on BCT Application")
	public void I_landed_on_BCT_Application() throws IOException {
    	LaunchApp();
		
	}
    
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password) {
		
		Searchbets=login.Loginintoappl(username, password);
	}
	
	@When("^Search with the betnumber (.+)$")
	public void Search_with_betnumber(String betnumber) {
		
		cancellingbet=Searchbets.Searchbets(betnumber);
	}
	
	@Then("^cancel the bet with (.+)$")
	public void cancel_the_bet(String comment) throws InterruptedException
	{
		cancellingbet.cancellingbet(comment);
	}
}
