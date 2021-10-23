package steps;

import cucumber.api.java.en.*;
import pages.ListPage;

import java.util.List;

public class ListSteps {
    ListPage listPage = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToPage(){
        listPage.navigateToListPage();
    }

    @When("^I search (.+) in the list$")
    public void searchTheList(String state) throws InterruptedException {
        listPage.enterCriteria(state);
    }

    @Then("^I can find the (.+) in the list$")
    public void tableIsThere(String city){
        List<String> list = listPage.getAllResult();
        Boolean textIsThere = list.contains(city);

        if(textIsThere){
            System.out.println("The text is on the list: PASSED!");
        }else{
            throw new Error("Text not found on the list: FAILED!");
        }
    }

}
