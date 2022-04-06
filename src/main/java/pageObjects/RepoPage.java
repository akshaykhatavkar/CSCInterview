package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepoPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//div[@data-target=\"readme-toc.content\"]")
	WebElement readMe;
	
	public RepoPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public String printReadMe(int noOfChars) {
		this.wait.until(ExpectedConditions.visibilityOf(readMe));
		String readMeText = readMe.getText();
		String intendedText = readMeText.substring(0, noOfChars);
		System.out.println(intendedText);
		return intendedText;
	}

}
