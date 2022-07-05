package Steps;

import Pages.BasePage;
import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
    SearchPage google = new SearchPage();
    @Given("Navigate to Search page {}")
    public void navigate(String url){
        SearchPage.navigateToSearchPage(url);
    }
    @When("Type on search box the value {}")
    public void enterValue(String character){
        SearchPage.TypeInSearchBox(character);
    }

    @When("clicks on {}")
    public void clickButton(String buttonId){
        SearchPage.ClickButton(buttonId);
    }

    @Then("shows a card which includes the name {}, the real name {}, and current location {}")
    public void CheckCard(String ExpectedValueName,
                          String ExpectedValueRealName,
                          String ExpectedValueCurrentLocation) {
        
        SearchPage.CheckCardValues(ExpectedValueName,ExpectedValueRealName,ExpectedValueCurrentLocation);
    };


    @When("enter a valid data: {}, {}, {}, {}, {}")
    public void AddItems(
            String THUMBNAIL,
            String NAME,
            String REALNAME,
            String LOCATION,
            String ALIVE
            ) {
        SearchPage.addItemsValues(THUMBNAIL, NAME, REALNAME, LOCATION, ALIVE);
    }
}
