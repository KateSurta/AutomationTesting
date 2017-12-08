package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FactoryPages {

        protected WebDriver driver;

        protected FactoryPages  (WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(this.driver, this);
        }

        public String assertCurrentURL(){
            String currentUrl = driver.getCurrentUrl();
            return currentUrl;
        }
}

