package step_definitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonSearchPage;
import utils.Driver;

public class AmazonSearchSteps {
	
	AmazonSearchPage amazonPage = new AmazonSearchPage();
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
	    Driver.getDriver().get("https://amazon.com");
	}
	
	@When("I enter the search term {string}")
	public void i_enter_the_search_term(String item) {
		amazonPage.searchBox.sendKeys(item);
	}
	
	@When("I click on search button")
	public void i_click_on_search_button() {
	    amazonPage.searchButton.click();
	}
	
	@Then("I should see the search item {string} on search result page")
	public void i_should_see_the_search_item_on_search_result_page(String item) {
	    String originalText = amazonPage.searchResultPageText.getText();
	    Assert.assertEquals(originalText.substring(1, item.length()+1), item);
	}
	
	@Then("the page title should contain the searched item {string}")
	public void the_page_title_should_contain_the_searched_item(String item) {
		// another easy way is
		Assert.assertEquals(Driver.getDriver().getTitle().substring(13), item);
		
	    String title = Driver.getDriver().getTitle();
	    Assert.assertEquals(title.substring(title.length() - item.length()), item);
	}

}
