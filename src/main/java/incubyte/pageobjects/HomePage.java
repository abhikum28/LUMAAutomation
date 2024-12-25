package incubyte.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import incubyte.abstractcomponent.AbstractComponent;

public class HomePage extends AbstractComponent {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement signIn;
	
	@FindBy(linkText="Create an Account")
	WebElement createAccount;
	
	@FindBy(xpath = "//span[text()='Home Page']")
	WebElement homePagetitle;
	
	public void goTo(String url)
	{
		driver.get(url);
	}
	
	public void accessCreateAccount() {
		createAccount.click();
	}

	public void accessSignIn() {
		signIn.click();
	}
	
	public SignUpPage waitForSignUpPage() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.waitForSignUpPageToAppear();
		return signUpPage;
	}
	
	public SignInPage waitForSignInPage() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.waitForSignInPageToAppear();
		return signInPage;
	}

	public void waitForHomePageToAppear() {
		waitForWebElementToAppear(homePagetitle);
	}
}
