package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_components.variable_components.DropDown;
import page_components.variable_components.TextInput;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor to initialize driver
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        PageFactory.initElements(driver, this);
    }



    protected DropDown dropDown(WebElement dropdownElement) {
        wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        return new DropDown(dropdownElement);
    }

    protected TextInput textInput(WebElement textInputElement) {
        wait.until(ExpectedConditions.visibilityOf(textInputElement));
        return new TextInput(textInputElement);
    }



    public String getPageTitle() {
        return driver.getTitle();
    }
}