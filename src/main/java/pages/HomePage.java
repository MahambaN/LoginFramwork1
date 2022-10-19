package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //create a driver variable
    private WebDriver driver;

    private By formAuthentication = By.linkText("Form Authentication");

    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;

    }

    //create your constructor to make it public to receive the driver from the basetest
    //public HomePage (WebDriver driver){
     //   this.driver = driver;
    //clicking on the authentication link - Hard coded to click only on form authentication
    public LoginPage clickFormAuthenticationLink(String linkText){
        clickLinkText(linkText);
       //driver.findElement(formAuthentication).click();
         return new LoginPage(driver);
     }

    //line 30 to 32 same as line 23
   // public void formAuth(){
    //    driver.findElement(By.linkText("Form Authentication")).click();
   // }

    public void clickLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public ForgotPasswordPage clickForgotPwd(String linkText){
        clickLinkText(linkText);
        return new ForgotPasswordPage(driver);

    }


}
