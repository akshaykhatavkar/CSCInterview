package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[text()='Advanced search']")
	WebElement advanceSearchLink;
	
	@FindAll(@FindBy(xpath = "//a[@class='v-align-middle']"))
	List<WebElement> resultsRepo;
	
	@FindBy(xpath = "//a[@class='v-align-middle']")
	WebElement firstRepoLink;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void goToAdvancedSearch() {
		advanceSearchLink.click();
	}
	
	public void atleastOneRepoShouldBeDisplayed() {
		this.wait.until(ExpectedConditions.visibilityOf(firstRepoLink));
	}
	
	public int getNumberofReposOnCurrentPage() {
		return resultsRepo.size();
	}
	
	public String getRepoName(int location) {
		return resultsRepo.get(location-1).getText();
	}
	
	public void navigateToRepo(int location) {
		resultsRepo.get(location-1).click();
	}
}
