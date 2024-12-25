package incubyte.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import incubyte.abstractcomponent.AbstractComponent;

public class SignUpPage extends AbstractComponent {
	private WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "#firstname")
	WebElement firstName;

	@FindBy(css = "#lastname")
	WebElement lastName;
	
	@FindBy(css = "#email_address")
	WebElement email;
	
	@FindBy(css = "#password")
	WebElement password;
	
	@FindBy(css = "#password-confirmation")
	WebElement confirmPassword;	
	
	@FindBy(css = "[title='Create an Account']")
	WebElement createAccount;
	
	public void waitForSignUpPageToAppear() {
		waitForWebElementToAppear(firstName);
	}
	
	public void enterPersonalInfo(String first_name, String last_name) {
		firstName.sendKeys(first_name);
		lastName.sendKeys(last_name);
	}
	
	public void enterSignInInfo(String emailAddress, String pass) {
		email.sendKeys(emailAddress);
		password.sendKeys(pass);
		confirmPassword.sendKeys(pass);
	}
	
	public void submitAccountInfo() {
		createAccount.click();
	}
	
	public MyAccountPage waitForMyAccountPage() {
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.waitForMyAccountPageToAppear();
		return myAccountPage;
	}
}
