package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");

    private By submitBtn = By.cssSelector("#login > button");

    private By MsgOut = By.id("flash-messages");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    //input password method
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    //clicking the login button
    public SecureAreaPage clickSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new SecureAreaPage(driver);
    }

    public String getOutMsg(){
        return driver.findElement(MsgOut).getText();
    }


}
