package baseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

public class ForgotPwdTest extends BaseTests{

    @Test(priority = 2, dataProvider = "LoginData")
    public void forgotPwdTest(String LinkText, String Email, boolean ErrorMessage){
    //Passing the values from the test _we are at the home Page we click Forgot password , we are passing which string - go to page and inspet the forgot password, we are passng that string
         //ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPwd("Forgot Password");
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPwd(LinkText);
         //Enter email on the forgot password page
        forgotPasswordPage.enterEmail(Email);
        forgotPasswordPage.clickRetrvBtn();

        //Assert.assertEquals(forgotPasswordPage.getErrorMsg(), "Internal Server Error");
       // Assert.assertTrue(Success,forgotPasswordPage.getErrorMsg());
        // use this is you had String ErrorMessage instead of the boolean...Assert.assertEquals(forgotPasswordPage.getErrorMsg(),ErrorMessage);
        //your error message is "Internal Server Error"
        Assert.assertTrue(ErrorMessage,forgotPasswordPage.getErrorMsg());



    }
    @DataProvider()
    public Object[][] LoginData(){
        Object[][] data = new Object[4][3];
        data[0][0]="Forget Password";data[0][1]="aa@fila.com"; data[0][2]= true;
        data[1][0]="Forget Password"; data[1][1]="thanku@me.com"; data[1][2]= true;
        data[2][0]="Forget Password"; data[2][1]="just@do.it";data[2][2]=false;
        data[3][0]="Forget Password";data[3][1]="4u@me.com";data[3][2]=false;

        return data;

    }
}
