package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By flash_messages = By.id("flash");

    private By logOutBtn = By.cssSelector("#content > div > a");

    public SecureAreaPage(WebDriver driver) {
        //constructor
        this.driver= driver;

    }
        public String getFlashMessage(){
            return driver.findElement(flash_messages).getText();

        }

        public LoginPage clickLogOutBtn(){
        driver.findElement(logOutBtn).click();
        return new LoginPage(driver);
        }

}
