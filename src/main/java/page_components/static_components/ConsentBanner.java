package page_components.static_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConsentBanner implements BaseStaticComponent {
    private final WebDriverWait wait;

    @FindBy(id = "onetrust-banner-sdk")
    private WebElement consentBanner;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllButton;

    public ConsentBanner(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        initialize(driver);
    }

    public void acceptAll() {
        clickElement(acceptAllButton, wait);
    }

    public boolean isDisplayed() {
        try {
            return consentBanner.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
