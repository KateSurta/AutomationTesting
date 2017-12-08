package Pages;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static org.openqa.selenium.firefox.FirefoxOptions.FIREFOX_OPTIONS;


public class DefaultPages extends FactoryPages {

    @FindBy (css= "input[test-id ='login-input']")
    private WebElement loginField;

    @FindBy (css= "input[test-id ='pass-input']")
    private WebElement passwordField;

    @FindBy (css= "button.btn.btn-lg.btn-default.center-block")
    public WebElement singInButton;

    @FindBy(css = "div[test-id ='login-validation']")
    private WebElement errorLoginMessage;

    @FindBy(css = "div[test-id ='pass-validation']")
    private WebElement errorPasswordMessage;

    @FindBy(css = "div[test-id ='custom-auth-message']")
    public  WebElement errorCustomMessage;


    public DefaultPages(WebDriver driver)    {
        super(driver);
    }

    public void Refresh() {
        driver.navigate().refresh();
    }

    /*----------------------------------------------------------------------------*/
    // methods for login field
    public boolean isLoginFieldDisplayed(){

     return loginField.isDisplayed();
    }

    public String getLoginMessage() {
        String messageLoginTitle =  errorLoginMessage.getText();
        return  messageLoginTitle;
    }

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void clickLoginField(){
        loginField.click();
    }
    /*----------------------------------------------------------------------------*/
    // methods for password field
    public boolean isPasswordFieldDisplayed(){

        return passwordField.isDisplayed();
    }

    public void inputPassword(String pass){
        passwordField.sendKeys(pass);

    }

    public String getPasswordMessage() {
        String messagePasswordTitle = errorPasswordMessage.getText();
        return  messagePasswordTitle;
    }


    public void clearPasswordField(){
        loginField.sendKeys(Keys.BACK_SPACE);
    }

    public void clickPasswordField(){
        passwordField.click();
    }
    /*----------------------------------------------------------------------------*/
    // methods for Sing In button
    public boolean isButtonSingInDisplayed(){

        return singInButton.isDisplayed();
    }

    public void clickButtonSingIn() {

        singInButton.click();
    }

    public boolean isAuthCustomMessageDisplayed(){

        return errorCustomMessage.isDisplayed();
    }

    public String getAuthCustomMessage() {
        String messageCustomAuthTitle =   errorCustomMessage.getText();
        return  messageCustomAuthTitle;
    }

}
