package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    String BASEURL ="https://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        //driver.getTitle();
        //System.out.println("Title name is " + driver.getTitle());
        homePage = new HomePage(driver);

       // HomePage homePage = newHomePage(driver);
        //create a constructor Home page

    }
    @AfterMethod
     public void captureScreenShots(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/failResults/" + testResult.getName() + " _FAIL_" + testResult.getStartMillis() + ".png");
            //File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/" + testResult.getName() + "_" +testResult.getStartMillis() +".png");
            try {
                FileHandler.copy(source, destination); //hover and select more actions then select again 'try catch
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/passResults/" + testResult.getName() + " _PASS_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);//hover copy, select more.. select try and catch
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterClass
    //after class to close our browse
    public void tearDown() {
        //CLOSE THE BROWSER
        driver.quit();
    }
 }




