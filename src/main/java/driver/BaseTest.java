package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Paths;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp(ITestContext context) {
        System.out.println("Starting Test: " + context.getName());
        String browser = System.getProperty("browser");

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
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
