package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AdminPages extends FactoryPages {


    public static final String ADMIN_PAGE_URL = "https://ec3admindev.mybluemix.net/";

    @FindBy(css = "div.home-page")
    private WebElement homePages;

    @FindBy(css = "p.navbar-text")
    private WebElement homePagesText;

    @FindBy(css = "div.hidden-xs h2")
    private WebElement homeFirstTitle;

    @FindBy(css = "div.hidden-xs h1")
    private WebElement homeSecondTitle;

    @FindBy (css = "")
    private WebElement UserName;


    public AdminPages(WebDriver driver) {
        super(driver);
    }


    public boolean isAtributeFieldDisplayed(){
        return homePages.isDisplayed();
    }

    public boolean isNavbarTextisDisplayed(){
        return  homePagesText.isDisplayed();
    }

    public boolean ishomeFirstTitleisDisplayed(){
        return  homeFirstTitle.isDisplayed();
    }

    public boolean ishomeSecondTitleisDisplayed(){
        return  homeSecondTitle.isDisplayed();
    }

    public String getHomePagesText() {
        String homePagesTitle =  homePagesText.getText();
        return  homePagesTitle;
    }

    public String gethomeFirstText() {
        String homeFirstText =   homeFirstTitle.getText();
        return  homeFirstText;
    }

    public String gethomeSecondText() {
        String homeSecondText =   homeSecondTitle.getText();
        return  homeSecondText;
    }


}
