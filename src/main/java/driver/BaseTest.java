package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseTest {


    protected WebDriver driver;
//@BeforeMethod used for easier transition between test combinations when data provider is used
    @BeforeMethod
    public void setUp(ITestContext context) {
        System.out.println("Starting Test: " + context.getName());
        String browser = System.getProperty("browser");
        //switch used for possible future browsers
        switch (System.getProperty("browser")
                      .toLowerCase()) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);

        }

        this.driver.manage()
                   .window()
                   .maximize();


        context.setAttribute("WebDriver", driver);
    }

    private WebDriver setupChromeDriver() {
        String chromeDriverPath = ConfigReader.get("chromedriver_path");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.out.println("Using ChromeDriver from: " + Paths.get(chromeDriverPath)
                                                              .toAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        //to fix issue with opening port on my notebook
        options.addArguments("--remote-allow-origins=*");
        //to avoid Akamai
        options.addArguments("--disable-blink-features=AutomationControlled");
        return new ChromeDriver(options);
    }
    //@BeforeMethod used for easier transition between test combinations when data provider is used
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
