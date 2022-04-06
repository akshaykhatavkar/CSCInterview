package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.AdvancedSearchPage;
import pageObjects.HomePage;
import pageObjects.RepoPage;
import pageObjects.SearchPage;

public class PageObjectManager {
	
	public HomePage homePage;
	public SearchPage searchPage;
	public AdvancedSearchPage advSearchPage;
	public RepoPage repoPage;
	
	public PageObjectManager(WebDriver driver) {
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
		advSearchPage = new AdvancedSearchPage(driver);
		repoPage = new RepoPage(driver);
	}

}
