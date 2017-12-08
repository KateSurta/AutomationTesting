package tests;

import Pages.AdminPages;
import Pages.DefaultPages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.AdminPages.ADMIN_PAGE_URL;

public class LoginPageTests extends BasicTest {
    public String errorMessage = "Wrong email address format";
    public String errorMessagelog = "Please specify Intranet ID.";
    public String errorMessagepas = "Please specify password.";
    public String errorCustomMessage = "Http failure response for https://ec3-security-custom.mybluemix.net/v1/person/profile: 401 Unauthorized";




    /*Positive Tests*/
    /*Test A1*/
   @Test
    public void allItemIsDisplayed() {

        boolean l = new DefaultPages(driver).isLoginFieldDisplayed();
        boolean p = new DefaultPages(driver).isPasswordFieldDisplayed();
        boolean but = new DefaultPages(driver).isButtonSingInDisplayed();
        Assert.assertEquals(l, true);
        Assert.assertEquals(p, true);
        Assert.assertEquals(but, true);



    }
    /*Test A2*/
    @Test(dependsOnMethods = {"allItemIsDisplayed"})
    public void verifyErrorMessage() {

        new DefaultPages(driver).inputLogin("test");
        new DefaultPages(driver).inputPassword("test");
        new DefaultPages(driver).clickButtonSingIn();
        WebDriverWait mywait = new WebDriverWait(driver,10);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='login-validation']")));
        String titleErrorlog = new DefaultPages(driver).getLoginMessage();
        System.out.println("Actual result 'Test A2': "+ titleErrorlog+".");
        Assert.assertEquals(errorMessage,titleErrorlog);
        new DefaultPages(driver).Refresh();

    }

    /*Test A3*/
    @Test(dependsOnMethods = {"verifyErrorMessage"})
    public void verifyErrorPassMessage() {
        new DefaultPages(driver).inputLogin("test1@us.ibm.com");
        new DefaultPages(driver).clickButtonSingIn();
        WebDriverWait mywait = new WebDriverWait(driver,10);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='pass-validation']")));
        String titleErrorlog = new DefaultPages(driver).getPasswordMessage();
        System.out.println("Actual result 'Test A3': "+ titleErrorlog);
        Assert.assertEquals(errorMessagepas,titleErrorlog);
        new DefaultPages(driver).Refresh();
    }


    /*Test A4*/
    @Test(dependsOnMethods = {"verifyErrorPassMessage"})
    public void verifyAllErrorMessage() {
        new DefaultPages(driver).clickButtonSingIn();
        WebDriverWait mywait = new WebDriverWait(driver,10);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='login-validation']")));
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='pass-validation']")));       ;
        String titleErrorlog = new DefaultPages(driver).getLoginMessage();
        String titleErrorpass = new DefaultPages(driver).getPasswordMessage();
        System.out.println("Actual result 'Test A4': "+ titleErrorlog);
        System.out.println("Actual result 'Test A4': "+ titleErrorpass);
        Assert.assertEquals(errorMessagelog, titleErrorlog);
        Assert.assertEquals(errorMessagepas, titleErrorpass);
        new DefaultPages(driver).Refresh();
    }

    /*Test A5*/
    @Test(dependsOnMethods = {"verifyAllErrorMessage"})
    public void verifyAllErrorMessage2() {
        new DefaultPages(driver).clickLoginField();
        new DefaultPages(driver).clickPasswordField();
        new DefaultPages(driver).clickButtonSingIn();
        WebDriverWait mywait = new WebDriverWait(driver,10);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='login-validation']")));
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='pass-validation']")));       ;
        String titleErrorlog = new DefaultPages(driver).getLoginMessage();
        String titleErrorpass = new DefaultPages(driver).getPasswordMessage();
        System.out.println("Actual result 'Test A5': "+ titleErrorlog);
        System.out.println("Actual result 'Test A5': "+ titleErrorpass);
        Assert.assertEquals(errorMessagelog, titleErrorlog);
        Assert.assertEquals(errorMessagepas, titleErrorpass);
        new DefaultPages(driver).Refresh();
    }


   /* @Test(dependsOnMethods = {"VerifyErrorMessageAll"})
    public void VerifyErrorMessageAllFields() {
        new DefaultPages(driver).inputLogin("test");
        new DefaultPages(driver).inputPassword("test");
        new DefaultPages(driver).clickButtonSingIn();
        String titleError  = new DefaultPages(driver).getLoginMessage();
        Assert.assertEquals(errorMessage,titleError);
        new DefaultPages(driver).clearLoginField();
        new DefaultPages(driver).clearPasswordField();
        String titleErrorlog = new DefaultPages(driver).getLoginMessage();
        String titleErrorpass = new DefaultPages(driver).getPasswordMessage();
        Assert.assertEquals(errorMessagelog, titleErrorlog);
        Assert.assertEquals(errorMessagepas, titleErrorpass);
        new DefaultPages(driver).Refresh();
    }
*/
      /*Test A6*/
    @Test(dependsOnMethods = {"verifyAllErrorMessage2"})
    public void verifyErrorAuthMessage()  {
        new DefaultPages(driver).inputLogin("katsiaryna.surta@ibm.com");
        new DefaultPages(driver).inputPassword("test");
        new DefaultPages(driver).clickButtonSingIn();
        WebDriverWait mywait = new WebDriverWait(driver,10);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='custom-auth-message']")));
        boolean m = new DefaultPages(driver).isAuthCustomMessageDisplayed();
        Assert.assertEquals(m, true);
        String titleErrorlog = new DefaultPages(driver).getAuthCustomMessage();
        System.out.println("Actual result 'Test A6': "+ titleErrorlog);
        Assert.assertEquals(errorCustomMessage, titleErrorlog);
        new DefaultPages(driver).Refresh();
    }

    /*Test A7*/
    @Test(dependsOnMethods = {"verifyErrorAuthMessage"})
    public void verifyErrorAuth2Message()  {
        new DefaultPages(driver).inputLogin("test1@us.ibm.com");
        new DefaultPages(driver).inputPassword("test");
        new DefaultPages(driver).clickButtonSingIn();
        WebDriverWait mywait = new WebDriverWait(driver,10);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='custom-auth-message']")));
        String titleErrorlog = new DefaultPages(driver).getAuthCustomMessage();
        System.out.println("Actual result 'Test A7': "+ titleErrorlog);
        Assert.assertEquals(errorCustomMessage, titleErrorlog);
        new DefaultPages(driver).Refresh();
    }


    /*Test A8*/
    @Test(dependsOnMethods = {"verifyErrorAuth2Message"})
    public void verifyLoginFieldMessage()  {
        new DefaultPages(driver).inputLogin("тест");
        new DefaultPages(driver).inputPassword("тест");
        new DefaultPages(driver).clickButtonSingIn();
        WebDriverWait mywait = new WebDriverWait(driver,10);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[test-id ='login-validation']")));
        String titleErrorlog = new DefaultPages(driver).getLoginMessage();
        System.out.println("Actual result 'Test A8': "+ titleErrorlog);
        Assert.assertEquals(errorMessage,titleErrorlog);
        new DefaultPages(driver).Refresh();
    }


    /*Test A9*/
    @Test(dependsOnMethods = {"verifyLoginFieldMessage"})
    public void clickButtonSingIn()  {
        new DefaultPages(driver).inputLogin("admin@us.ibm.com");
        new DefaultPages(driver).inputPassword("admin");
        new DefaultPages(driver).clickButtonSingIn();
        boolean h = new AdminPages(driver).isAtributeFieldDisplayed();
        Assert.assertEquals(h, true);
    }


    /*Test A10*/
    @Test(dependsOnMethods = {"clickButtonSingIn"})
    public void AdminPagesIsDisplayed() {
        String registerURL = new AdminPages(driver).assertCurrentURL();
        System.out.println("Expected result 'Test A10': " + ADMIN_PAGE_URL);
        System.out.println("Actual result 'Test A10': " + registerURL);
        Assert.assertEquals(registerURL, ADMIN_PAGE_URL);
    }

}
