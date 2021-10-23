package steps;

import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I'm in google$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^Search thing$")
    public void enterSearch(){
        google.enterSearch("Argentina");
    }

    @And("^Click on the search button$")
    public void clickButton(){
        google.clickGoogleSearch();
    }

    @Then("^The result match with search$")
    public void validateResults(){
        Assert.assertEquals("", google.firstResult());
    }

}
