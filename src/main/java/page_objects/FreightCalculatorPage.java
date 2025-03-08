package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_components.static_components.ConsentBanner;
import utils.Utils;

public class FreightCalculatorPage extends BasePage {


    @FindBy(id = "origin-country")
    private WebElement originCountryDropdown;

    @FindBy(id = "origin-postcode")
    private WebElement originPostcodeInput;
    @FindBy(xpath = "//input[@id='origin-postcode']/following-sibling::*[contains(@class, 'zip-error-message')]")
    private WebElement originPostcodeError;

    @FindBy(id = "destination-country")
    private WebElement destinationCountryDropdown;

    @FindBy(id = "destination-postcode")
    private WebElement destinationPostcodeInput;

    @FindBy(xpath = "//input[@id='destination-postcode']/following-sibling::*[contains(@class, 'zip-error-message')]")
    private WebElement destinationPostcodeError;

    @FindBy(xpath = "//span[contains(text(), 'Calculate')]/parent::button")
    private WebElement calculateButton;

    @FindBy(xpath = "//div[contains(@class,'options-container') and contains(@style, 'display: block')]")
    private WebElement tableContainer;
    @FindBy(xpath = "//div[contains(@class,'options-container') and contains(@style, 'display: block')]//span[text()='Edit previous step']")
    private WebElement backToCalculator;



    // Constructor that passes the driver to BasePage
    public FreightCalculatorPage(WebDriver driver) {
        super(driver);
    }



    // Page actions


    public FreightCalculatorPage clickCalculateButton() {
        button(calculateButton).click(wait, driver);
        return this;
    }

    public FreightCalculatorPage waitForProductTableToBeLoaded() {
        wait.until(ExpectedConditions.visibilityOf(tableContainer));
        return this;
    }

    public FreightCalculatorPage selectOriginCountry(String country) {
        dropDown(originCountryDropdown).selectByText(country);
        return this;
    }

    public FreightCalculatorPage selectOriginPostCode(String postCode) {
        textInput(originPostcodeInput).typeText(postCode);
        return this;
    }

    public FreightCalculatorPage verifyCalculcatorErrorMessages() {
        verifyErrorMessage(originPostcodeError, "Correct postal code (e.g. no post box)*");
        verifyErrorMessage(destinationPostcodeError, "Correct postal code (e.g. no post box)*");
        return this;
    }

    public void verifyErrorMessage(WebElement element, String errorMessage) {
        Utils.compareValues(element.getText(), errorMessage);
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