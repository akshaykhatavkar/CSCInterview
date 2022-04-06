package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedSearchPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "search_language")
	WebElement language;
	
	@FindBy(id = "search_state")
	WebElement state;
	
	@FindBy(id = "search_followers")
	WebElement followers;
	
	@FindBy(id = "search_stars")
	WebElement stars;
	
	@FindBy(id = "search_license")
	WebElement license;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;
	
	public AdvancedSearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void selectLanguage(String selectText) {
		this.wait.until(ExpectedConditions.visibilityOf(language));
		Select sel = new Select(language);
		sel.selectByVisibleText(selectText);
	}
	
	public void selectState(String stateVal) {
		this.wait.until(ExpectedConditions.visibilityOf(state));
		Select sel = new Select(state);
		sel.selectByVisibleText(stateVal);
	}
	
	public void enterFollowers(String valToEnter) {
		followers.sendKeys(valToEnter);
	}
	
	public void enterStars(String starsToEnter) {
		stars.sendKeys(starsToEnter);
	}
	
	public void selectLicense(String licenseToSelect) {
		this.wait.until(ExpectedConditions.visibilityOf(license));
		Select sel = new Select(license);
		sel.selectByVisibleText(licenseToSelect);
	}
	
	public void clickSearch() {
		searchBtn.click();
	}

}
