package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty("webdriver.chrome.driver", "src//main//java//driver//chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,10);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void quit(){
        driver.quit();
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void elementClick(String locator){
        Find(locator).click();
    }

    public void elementWrite(String locator, String text){
        Find(locator).clear();
        Find(locator).sendKeys(text);
    }

    public void selectDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    //Method for grid page
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = String.format("%s/table/tbody/tr[%s]/td[%s]",locator,row,column);
        return Find(cellINeed).getText();
    }

    public void setValueTable(String locator, int row, int column, String stringToSend){
        String cellToFill = String.format("%s/table/tbody/tr[%s]/td[%s]",locator,row,column);
        Find(cellToFill).sendKeys(stringToSend);
    }


    //Iframe
    public void switchToIframe(int indexIframe){
        driver.switchTo().frame(indexIframe);
    }

    //For get back path or another iframe
    public void switchParentIframe(){
        driver.switchTo().parentFrame();
    }

    //Alerts
    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }

    }

    //For page google:
    public String textElement(String locator){
        return Find(locator).getText();
    }

    //Element enabled - displayed - selected
    public Boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public Boolean elementDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public Boolean elementSelected(String locator){
        return Find(locator).isSelected();
    }

    //List
    public List<WebElement> bringMeAllElement(String locator){
        return driver.findElements(By.className(locator));
    }

}
