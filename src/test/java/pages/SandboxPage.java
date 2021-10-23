package pages;

public class SandboxPage extends BasePage{

    public String categoryDropdown = "//select[@id='cars']";

    public SandboxPage() {
        super(driver);
    }

    public void navigateToSandBox(){
        navigateTo("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
    }

    public void selectCategory(String category){
        driver.switchTo().frame("iframeResult");
        selectDropdownByValue(categoryDropdown,category);
    }

}
