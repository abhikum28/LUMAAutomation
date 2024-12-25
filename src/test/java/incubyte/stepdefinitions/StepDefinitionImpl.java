package incubyte.stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import incubyte.pageobjects.HomePage;
import incubyte.pageobjects.MyAccountPage;
import incubyte.pageobjects.SignInPage;
import incubyte.pageobjects.SignUpPage;
import incubyte.testcomponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	private HomePage homePage;
	private SignUpPage signUpPage;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	
    @Given("I am on the home page")
    public void i_am_on_the_home_page() throws IOException {
    	homePage = launchApplication();
    }
    
    @When("I click on Create an Account link")
    public void i_click_on_create_account_link() {
    	homePage.accessCreateAccount();
    }
    
    @When("I should be redirected to the Create New Customer Account page")
    public void i_should_be_redirected_to_the_create_new_customer_account_page() {
        signUpPage = homePage.waitForSignUpPage();
    } 
    
    @When("^I enter (.+), (.+), (.+) and (.+)$")
    public void i_enter_user_details(String firstName, String lastName, String email, String password) {
        signUpPage.enterPersonalInfo(firstName, lastName);
        signUpPage.enterSignInInfo(email, password);
    }
    
    @When("I click Create an Account button")
    public void i_click_create_an_account_button() {
    	signUpPage.submitAccountInfo();
    }
    
    @Then("I should be redirected to the My Account page")
    public void i_should_be_redirected_to_the_my_account_page() {
    	myAccountPage = signUpPage.waitForMyAccountPage();
    }
    
    @Then("{string} success message is displayed")
    public void success_message_is_displayed(String succMssg) {
    	Assert.assertEquals(myAccountPage.getRegSuccessMssg(), succMssg);
    	//driver.quit();
    }
    
    @When("I click on Sign In link")
    public void i_click_on_sign_in_link() {
    	homePage.accessSignIn();
    }
    
    @When("I should be redirected to the Customer Login page")
    public void i_should_be_redirected_to_the_my_customer_login_page() {
    	signInPage = homePage.waitForSignInPage();
    }   
    
    @When("^I enter sign in information (.+) and (.+)$")
    public void i_enter_sign_in_information_and(String email, String password) {
    	signInPage.enterLoginInfo(email, password);
    }
    
    @When("I click on Sign In button")
    public void i_click_on_sign_in_button() {
    	signInPage.submitLoginInfo();
    }
    
    @Then("I should be redirected to Home page")
    public void i_should_be_redirected_to_home_page() {
    	homePage = signInPage.waitForHomePage();
    }
    
    @Then("^Welcome user (.+) is displayed$")
    public void welcome_user_is_displayed(String fullName) {
    	System.out.println(homePage.getWelcomeUserText());
    	Assert.assertTrue(homePage.getWelcomeUserText().contains(fullName));
    //	driver.quit();
    }
    
	@After
	public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }		
	}
    
}
