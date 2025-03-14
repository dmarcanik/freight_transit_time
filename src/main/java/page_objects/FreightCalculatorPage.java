package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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

    @FindBy(xpath = "//div[contains(@class,'calculator--error-message') and contains(@style, 'display: block')]")
    private WebElement shipmentError;

    @FindBy(xpath = "//span[contains(text(), 'Calculate')]/parent::button")
    private WebElement calculateButton;

    @FindBy(xpath = "//div[contains(@class,'options-container') and contains(@style, 'display: block')]")
    private WebElement tableContainer;
    @FindBy(xpath = "//span[strong[text()='Committed']]/following-sibling::p/strong[contains(@class, 'product-box')]")
    private WebElement committedDeliveryDate;


    @FindBy(xpath = "//input[@id='#leadtime-datepicker']")
    private WebElement calendarInput;


    // Constructor that passes the driver to BasePage
    public FreightCalculatorPage(WebDriver driver) {
        super(driver);
    }


    // Page actions


    public FreightCalculatorPage clickCalculateButton() {
        button(calculateButton).clickOn();
        return this;
    }

    public FreightCalculatorPage waitForProductTableToBeLoaded() {
        customComponent(tableContainer).waitForElement();
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

    public FreightCalculatorPage verifyShipmentError() {
        customComponent(shipmentError).waitForElement();
        String actualErrorMessage = Utils.erasePartOfString(Utils.getTextFromString(shipmentError.getText()), "ID");
        verifyErrorMessage(
                "Unfortunately the online tool is unable to retrieve data for the specified shipment. Please try again later or contact us for assistance.",
                actualErrorMessage
        );

        return this;
    }

    public FreightCalculatorPage verifyPostcodeErrorMessages() {
        verifyErrorMessage(originPostcodeError, "Correct postal code (e.g. no post box)*");
        verifyErrorMessage(destinationPostcodeError, "Correct postal code (e.g. no post box)*");
        return this;
    }

    public void verifyErrorMessage(WebElement element, String expectedErrorMessage) {
        verifyErrorMessage(expectedErrorMessage, element.getText());
    }

    public void verifyErrorMessage(String expectedError, String actualError) {
        Assert.assertTrue(Utils.compareValues(expectedError, actualError));
    }

    public FreightCalculatorPage selectDestinationCountry(String country) {
        dropDown(destinationCountryDropdown).selectByText(country);
        return this;
    }

    public FreightCalculatorPage selectDestinationPostCode(String postCode) {
        textInput(destinationPostcodeInput).typeText(postCode);
        return this;
    }

    public FreightCalculatorPage setCalendarDate() {
        Utils.getFormatedDate(Utils.getTodayCalendar());
        return this;
    }

    public FreightCalculatorPage navigateToDHLPage() {
        driver.get("https://www.dhl.com/se-en/home/freight/tools/european-road-freight-transit-time-calculator.html");
        new ConsentBanner(driver).acceptAll();
        return this;
    }
}