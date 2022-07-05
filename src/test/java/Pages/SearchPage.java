package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage{

    static String inputBoxLocator = "//body/div[@id='root']/div[1]/div[1]/main[1]/section[1]/form[1]/div[1]/input[1]";
    static String searchButtonLocator = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/section[1]/form[1]/button[1]";
    static String addItemButtonLocator = "/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/button[1]";
    static String submitItemButtonLocator = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/section[1]/form[1]/div[6]/button[1]";
    static String FirstCardLocator = "//*[@id=\"root\"]/div/div[1]/main/div/div/div";

    static String thumbnailTextBoxLocator = "//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[1]/input";
    static String nameTextBoxLocator = "//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[2]/input";
    static String realNameTextBoxLocator = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/section[1]/form[1]/div[3]/input[1]";
    static String locationTextBoxLocator = "//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[4]/select";
    static String aliveTextBoxLocator = "//*[@id=\"popup-portal\"]/div/div/div[2]/section/form/div[5]/input";



    public SearchPage() {
        super(driver);
    }
    public static void navigateToSearchPage(String url){
        navigateTo(url);
    }


    public static void TypeInSearchBox(String character) {
        WebElement inputBox = searchWaitUntil(inputBoxLocator);
        inputCharacters(inputBox, character);
    }

    public static void ClickButton(String buttonId) {
        WebElement button = null;
        WebElement FirstCard = searchWaitUntil(FirstCardLocator);
        switch(buttonId){
            case "Search Submit":
                button = searchWaitUntil(searchButtonLocator);
                break;
            case "+Add Item":
                button = searchWaitUntil(addItemButtonLocator);
                break;
            case "Submit Item":searchWaitUntil(submitItemButtonLocator);
                button = searchWaitUntil(submitItemButtonLocator);
                break;

        }
        clickButton(button);
    }

    public static void addItemsValues(  String THUMBNAIL,
                                        String NAME,
                                        String REALNAME,
                                        String LOCATION,
                                        String ALIVE){
        WebElement thumbnailTextBox = searchWaitUntil(thumbnailTextBoxLocator);
        WebElement nameTextBox = searchWaitUntil(nameTextBoxLocator);
        WebElement realNameTextBox = searchWaitUntil(realNameTextBoxLocator);
        WebElement locationWebObject = searchWaitUntil(locationTextBoxLocator);
        Select locationTextBox = new Select(locationWebObject);
        WebElement aliveTextBox = searchWaitUntil(aliveTextBoxLocator);

        BasePage.inputCharacters(thumbnailTextBox, THUMBNAIL);
        BasePage.inputCharacters(nameTextBox, NAME);
        BasePage.inputCharacters(realNameTextBox, REALNAME);
        locationTextBox.selectByValue(LOCATION);
        if(ALIVE == "YES"){
            aliveTextBox.click();
        }

    }



    //Asserts ---------------------------------------------------------------------------------
    static String actualValueNameLocator = "/html/body/div[1]/div/div[1]/main/div/div/div/div[3]/span";
    static String ActualValueRealNameLocator = "/html/body/div[1]/div/div[1]/main/div/div/div/div[4]/span";
    static String ActualValueCurrentLocationLocator = "/html/body/div[1]/div/div[1]/main/div/div/div/div[5]/span";

    public static void CheckCardValues(String ExpectedValueName,
                                       String ExpectedValueRealName,
                                       String ExpectedValueCurrentLocation) {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement actualValueName = searchWaitUntil(actualValueNameLocator);
            WebElement ActualValueRealName = searchWaitUntil(ActualValueRealNameLocator);
            WebElement ActualValueCurrentLocation = searchWaitUntil(ActualValueCurrentLocationLocator);
            ArrayList<String> exceptionCapture = new ArrayList<>();
        try
        {
            Assert.assertEquals(ExpectedValueName, actualValueName.getText());
            Assert.assertEquals(ExpectedValueRealName, ActualValueRealName.getText());
            Assert.assertEquals(ExpectedValueCurrentLocation, ActualValueCurrentLocation.getText());
        }
        catch(AssertionError e)
        {
            exceptionCapture.add(e.getMessage());
        }

    }



    //Search webelements by xpath, returns an object
    public static WebElement searchWaitUntil(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return webElement;
    }

}
