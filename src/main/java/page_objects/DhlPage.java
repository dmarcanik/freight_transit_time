package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DhlPage extends BasePage {

    @FindBy(id = "origin-country")
    private WebElement originCountryDropdown;

    @FindBy(id = "destination-country")
    private WebElement destinationCountryDropdown;

    @FindBy(xpath = "//span[contains(text(), 'Calculate')]")
    private WebElement calculateButton;


    // Constructor that passes the driver to BasePage
    public DhlPage(WebDriver driver) {
        super(driver);

    }

    // Page actions


    public void clickCalculateButton() {
        calculateButton.click();
    }

    public void selectOriginCountry(String country) {
        customSelect(originCountryDropdown).selectByText(country);
    }

    public void selectDestinationCountry(String country) {
        customSelect(destinationCountryDropdown).selectByText(country);
    }

    public void navigateToDHLPage() {
        driver.get("https://www.dhl.com/se-en/home/freight/tools/european-road-freight-transit-time-calculator.html");
    }
}