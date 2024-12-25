package incubyte.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import incubyte.abstractcomponent.AbstractComponent;

public class MyAccountPage extends AbstractComponent{
	private WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccounttitle;
	
	
	@FindBy(css = "div[data-bind*='prepareMessageForHtml(message.text)']")
	WebElement regSuccessMssg;

	public void waitForMyAccountPageToAppear() {
		waitForWebElementToAppear(myAccounttitle);
	}
	
	public String getRegSuccessMssg() {
		return regSuccessMssg.getText();
	}

}
