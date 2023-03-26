package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BasePage {
    protected static WebDriver driver;
    public static WebDriver wait;

        static{
        ChromeOptions chromeOptions = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver_win32/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    //Navigate to url
    public static void navigateTo(String url){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
    }

    //Type keys to an object
    public static void inputCharacters(WebElement inputBox, String characters){
        inputBox.click();
        inputBox.clear();
        inputBox.sendKeys(characters);
    }
    //Clicks element, receives the object webElement
    public static void clickButton(WebElement element){
        element.click();
    }

    //Close Driver
    public static void closeDriver(){
        driver.close();
    }

    //Clear Text
    public void clearText(WebElement field) {
        field.clear();
    }

    //Seleect option from a Dropdown
    public void selectOptionFromDropdown(WebElement dropdown, String option) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    //Get a Texr from element
    public String getText(WebElement element) {
        return element.getText();
    }

    //Take a element
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    // Switch to selected window
    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }


    public class ScreenshotUtils {
        public static void takeScreenshot(WebDriver driver, String fileName) {
            // Convert the driver object to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Call the getScreenshotAs method to create an image file
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Specify the destination file path
            File destinationFile = new File(fileName);

            try {
                // Copy the source file to the destination file path
                FileUtils.copyFile(sourceFile, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
