package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BasicTest {
    public static final String START_URL = "https://ec3admindev.mybluemix.net";
    public static final By HOME_PANEL = By.cssSelector("#navbar");

    protected static WebDriver driver;



    public static WebDriver getDriver() {

        if (driver == null) {
            setChromeDriver();
            //setUpFireFox();
            //setUpEdge();
            //setUpOpera();

        }
        return driver;
    }

    public static void setChromeDriver()
    {

        System.setProperty("webdriver.chrome.driver", "d:\\surta_kate\\Automation Testing\\Test\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette",true);
        driver = new ChromeDriver(options);


    }


   public static void setUpFireFox() {
//        appropriate System Variables have already added

        String exePath =  "d:\\surta_kate\\Automation Testing\\Test\\firefoxdriver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exePath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette",true);
        driver = new FirefoxDriver();
    }

    public static void setUpEdge() {

        System.setProperty("webdriver.edge.driver","d:\\surta_kate\\Automation Testing\\Test\\MicrocoftDriver\\MicrosoftWebDriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.getCapability("marionette");
        driver = new EdgeDriver(options);
    }

    public static void setUpOpera() {
        String operaChromiumDriver = "d:\\surta_kate\\Automation Testing\\Test\\OperaDriver\\operadriver.exe";
        String operaBrowserLocation = "c:\\Program Files\\Opera\\49.0.2725.47\\opera.exe";


        System.setProperty("webdriver.opera.driver", operaChromiumDriver);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(operaBrowserLocation);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        OperaDriver browser = new OperaDriver(capabilities);
        driver = browser;

    }





    @BeforeClass(description = "Start browser")
    public void setUp() {
        getDriver().get(START_URL);
        WebElement expectedElement = (new WebDriverWait(driver, 5)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(HOME_PANEL);

            }


        });


    }

    @BeforeClass (dependsOnMethods = "setUp" )
    public void enableJavaScript(){

    }

    @BeforeClass(dependsOnMethods = "setUp", description = "Add implicite wait and maximize window")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /*@AfterClass()
        public void logger() {
        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get(LogType.DRIVER);

        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
    }
//    public void afterClass() throws Exception {
//        driver.quit();
//    }

*/

}
