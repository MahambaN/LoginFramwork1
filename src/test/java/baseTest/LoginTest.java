package baseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTests {


    @Test(priority = 1,dataProvider = "LoginData")
    public void loginSucessfulTest(String Username, String Password, boolean Success){
       //instantiate from the base class-instantiate means create
       //BaseTests baseTests =  new BaseTests();
       //baseTests.setup();
        //access the Login Page with a variable called loginTest
        LoginPage loginPage = homePage.clickFormAuthenticationLink("Form Authentication");
        //to access the object and pass the username 'tomsmith'
        loginPage.setUsername(Username);
        loginPage.setPassword(Password);
        SecureAreaPage secureAreaPage = loginPage.clickSubmitBtn();
        secureAreaPage.getFlashMessage();
        //compare the output
       // Assert.assertTrue(secureAreaPage.getFlashMessage().contains(FlashMessage));
        Assert.assertTrue(Success,secureAreaPage.getFlashMessage());

        //click on the Logout button
        LoginPage logOutTest = secureAreaPage.clickLogOutBtn();
        //Assert.assertTrue(logOutTest.getOutMsg().contains("You logged out of the secure area!"));
        Assert.assertTrue(Success,logOutTest.getOutMsg());

    }
    @DataProvider() //annotation that provide data
    public Object[][] LoginData(){
       Object[][] data = new Object[2][3];

       data[0][0] = "tomsmith";data[0][1]="SuperSecretPassword!";data[0][2]= true;
       data[1][0] = "tomsmith2";data[1][1]="SuperSecretPassword2!";data[1][2]= false; //incorrect data captured will fail
       return data;


    }
}
