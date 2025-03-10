package page_components.static_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Page component for banner, which can appear everywhere.
public class ConsentBanner implements BaseStaticComponent {
    private final WebDriverWait wait;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllButton;

    public ConsentBanner(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        initialize(driver);
    }

    public void acceptAll() {
        clickElement(acceptAllButton, wait);
    }
}
