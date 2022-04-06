package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import managers.PageObjectManager;

public class AllSteps {

	PageObjectManager poManager;
	WebDriver driver;
	Scenario scenario;

	@Before
	public void testSetup(Scenario scenario) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		poManager = new PageObjectManager(driver);
		this.scenario = scenario;
		System.out.println(scenario.getName());
	}

	@Given("I am on GitHub Page")
	public void i_am_on_git_hub_page() {
		driver.get("https://github.com/");
	}

	@Given("I search for {string}")
	public void i_search_for(String string) {
		poManager.homePage.searchRepoWithText(string);
	}

	@Given("I click on Advanced Search")
	public void i_click_on_advanced_search() {
		poManager.searchPage.goToAdvancedSearch();
	}

	@Given("I select language as {string}")
	public void i_select_language_as(String string) {
		poManager.advSearchPage.selectLanguage(string);
	}

	@Given("I select state as {string}")
	public void i_select_state_as(String state) {
		poManager.advSearchPage.selectState(state);
	}

	@Given("I enter stars as {string}")
	public void i_enter_stars_as(String stars) {
		poManager.advSearchPage.enterStars(stars);
	}

	@Given("I enter followers as {string}")
	public void i_enter_followers_as(String followers) {
		poManager.advSearchPage.enterFollowers(followers);
	}

	@Given("I select license as {string}")
	public void i_select_license_as(String license) {
		poManager.advSearchPage.selectLicense(license);
	}

	@Given("I click on Search")
	public void i_click_on_search() {
		poManager.advSearchPage.clickSearch();
	}

	@Then("Only {int} result should be displayed")
	public void only_result_should_be_displayed(Integer int1) {
		poManager.searchPage.atleastOneRepoShouldBeDisplayed();
		int actualNoOfRresults = poManager.searchPage.getNumberofReposOnCurrentPage();
		Assert.assertEquals(int1.intValue(), actualNoOfRresults);
	}

	@Then("Repo {string} should be available at position {int}")
	public void repo_should_be_available_at_position(String string, Integer int1) {
		String actRepoName = poManager.searchPage.getRepoName(int1);
		Assert.assertEquals(string, actRepoName);
	}
	
	@Given("User nagivates to the repo")
	public void user_nagivates_to_the_repo() {
		poManager.searchPage.navigateToRepo(1);
	}
	
	@Then("Print first {int} chars of ReadMe")
	public void print_chars_of_read_me(Integer int1) {
		String intendedText = poManager.repoPage.printReadMe(int1);
		this.scenario.log(intendedText);
		
	}

	@After
	public void testTearDown() {
		driver.quit();
	}



}
