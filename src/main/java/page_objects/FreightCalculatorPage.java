package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_components.static_components.ConsentBanner;

public class FreightCalculatorPage extends BasePage {


    @FindBy(id = "origin-country")
    private WebElement originCountryDropdown;

    @FindBy(id = "origin-postcode")
    private WebElement originPostcodeInput;

    @FindBy(id = "destination-country")
    private WebElement destinationCountryDropdown;

    @FindBy(id = "destination-postcode")
    private WebElement destinationPostcodeInput;

    @FindBy(xpath = "//span[contains(text(), 'Calculate')]/parent::button")
    private WebElement calculateButton;


    // Constructor that passes the driver to BasePage
    public FreightCalculatorPage(WebDriver driver) {
        super(driver);
    }



    // Page actions


    public void clickCalculateButton() {
        button(calculateButton).click(wait, driver);

    }

    public FreightCalculatorPage selectOriginCountry(String country) {
        dropDown(originCountryDropdown).selectByText(country);
        return this;
    }

    public FreightCalculatorPage selectOriginPostCode(String postCode) {
        textInput(originPostcodeInput).typeText(postCode);
        return this;
    }


    public FreightCalculatorPage selectDestinationCountry(String country) {
        dropDown(destinationCountryDropdown).selectByText(country);
        return this;
    }

    public FreightCalculatorPage selectDestinationPostCode(String postCode) {
        textInput(destinationPostcodeInput).typeText(postCode);
        return this;
    }

    public FreightCalculatorPage navigateToDHLPage() {
        driver.get("https://www.dhl.com/se-en/home/freight/tools/european-road-freight-transit-time-calculator.html");
        new ConsentBanner(driver).acceptAll();
        return this;
    }
}