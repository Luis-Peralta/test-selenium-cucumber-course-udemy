package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

//This page use pageFactory
public class GooglePage extends BasePage{

    @FindBy(xpath = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]")
    @CacheLookup
    WebElement btnSearch;
    //private String btnSearch = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]";

    @FindBy(xpath = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    @CacheLookup
    WebElement searchField;
    //private String searchField = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]";

    private String firstResult = "";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com/");
    }

    public void clickGoogleSearch(){
        btnSearch.click();
    }

    public void enterSearch(String criteria){
        searchField.sendKeys(criteria);
    }

    public String firstResult(){
        return textElement(firstResult);
    }

}
