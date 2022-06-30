package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage{

    static String inputBoxLocator = "//body/div[@id='root']/div[1]/div[1]/main[1]/section[1]/form[1]/div[1]/input[1]";
    static String searchButtonLocator = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/section[1]/form[1]/button[1]";

    static String FirstCardLocator = "//*[@id=\"root\"]/div/div[1]/main/div/div/div";

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
    public static void ClickSearchButton() {
        WebElement searchButton = searchWaitUntil(searchButtonLocator);
        WebElement FirstCard = searchWaitUntil(FirstCardLocator);
        clickButton(searchButton);
    }

    //Asserts
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
