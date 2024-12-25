package incubyte.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import incubyte.abstractcomponent.AbstractComponent;

public class SignInPage extends AbstractComponent {
	private WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#email")
	WebElement email;
	
	@FindBy(css = "#pass")
	WebElement password;	
	
	@FindBy(css = "#send2")
	WebElement signIn;
	
	public void waitForSignInPageToAppear() {
		waitForWebElementToAppear(email);
	}
	
	public void enterLoginInfo(String emailAddress, String pass) {
		email.sendKeys(emailAddress);
		password.sendKeys(pass);
	}
	
	public void submitLoginInfo() {
		signIn.click();
	}
	
	public HomePage waitForHomePage() {
		HomePage homePage = new HomePage(driver);
		homePage.waitForHomePageToAppear();
		return homePage;
	}
	
}
