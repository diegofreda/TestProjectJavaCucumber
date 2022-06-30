package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class BasePage {
    protected static WebDriver driver;
    public static WebDriver wait;

        static{
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
        }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }
    public static void navigateTo(String url){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
    }

    //Inputs a value in the received object
    public static void inputCharacters(WebElement inputBox, String characters){
        inputBox.click();
        inputBox.sendKeys(characters);
    }
    //Clicks button, receives the object webElement
    public static void clickButton(WebElement button){
        button.click();
    }
}
