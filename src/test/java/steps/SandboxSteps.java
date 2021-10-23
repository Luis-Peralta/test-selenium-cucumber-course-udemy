package steps;

import cucumber.api.java.en.*;
import pages.SandboxPage;

public class SandboxSteps {
    SandboxPage sandboxPage = new SandboxPage();

    @Given("^Navigate Sandbox Page$")
    public void navigateToSandbox(){
        sandboxPage.navigateToSandBox();
    }

    @And("^Select dropdown$")
    public void selectDropdown(){
        sandboxPage.selectCategory("audi");
    }

}
