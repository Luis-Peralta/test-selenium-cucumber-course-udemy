package steps;

import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.GridPage;

public class GridSteps {
    GridPage gridPage = new GridPage();

    @Given("^Navigate to the grid page and then the static table$")
    public void navigateToPageGrid(){
        gridPage.navigateToGrid();
    }

    @Then("^I can obtain the value of table$")
    public void returnValue(){
        String value = gridPage.getValueGrid(4,4);
        Assert.assertEquals(value,"r: 3, c: 3");
    }

    @Then("^I can validate if it's displayed$")
    public void theTableIsThere(){
        Assert.assertTrue("It exploded all!", gridPage.cellStatus());
    }

}
