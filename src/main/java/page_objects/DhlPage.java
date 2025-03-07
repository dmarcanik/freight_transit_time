package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_components.static_components.ConsentBanner;

public class DhlPage extends BasePage {

    private final ConsentBanner consentBanner;


    @FindBy(id = "origin-country")
    private WebElement originCountryDropdown;

    @FindBy(id = "origin-postcode")
    private WebElement originPostcodeInput;

    @FindBy(id = "destination-country")
    private WebElement destinationCountryDropdown;

    @FindBy(id = "destination-postcode")
    private WebElement destinationPostcodeInput;

    @FindBy(xpath = "//span[contains(text(), 'Calculate')]")
    private WebElement calculateButton;


    // Constructor that passes the driver to BasePage
    public DhlPage(WebDriver driver) {
        super(driver);
        this.consentBanner = new ConsentBanner(driver);
    }



    // Page actions


    public void clickCalculateButton() {
        calculateButton.click();
    }

    public DhlPage selectOriginCountry(String country) {
        dropDown(originCountryDropdown).selectByText(country);
        return this;
    }


    public DhlPage selectDestinationCountry(String country) {
        dropDown(destinationCountryDropdown).selectByText(country);
        return this;
    }

    public DhlPage navigateToDHLPage() {
        driver.get("https://www.dhl.com/se-en/home/freight/tools/european-road-freight-transit-time-calculator.html");
        consentBanner.acceptAll();
        return this;
    }
}