package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage{

    private String searchField = "//body/form[1]/input[1]";
    private String searchResult = "name";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterCriteria(String state) throws InterruptedException {
        try{
            Thread.sleep(1500);
            elementWrite(searchField,state);
        }catch (NoSuchElementException e){
            System.out.println("WebElement not found ");
            e.printStackTrace();
        }

    }

    public List<String> getAllResult(){
        List<WebElement> list = bringMeAllElement(searchResult);
        List<String> stringList = new ArrayList<>();
        list.forEach(element -> stringList.add(element.getText()));
        return  stringList;
    }

}
