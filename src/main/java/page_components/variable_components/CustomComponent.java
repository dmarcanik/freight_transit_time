package page_components.variable_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_components.BaseComponent;

//Interface which can serves for all variable element, like buttons, dropdowns, inputs etc.
public class CustomComponent implements BaseComponent {
    private final WebElement element;
    private final WebDriverWait wait;
    private final WebDriver driver;

    public CustomComponent(WebElement element, WebDriverWait wait, WebDriver driver) {
        this.element = element;
        this.wait = wait;
        this.driver = driver;

    }


    protected WebElement getElement() {
        return element;
    }

    public void clickOn() {
        clickElement(element, wait, driver);
    }

    public void waitForElement() {
        waitForElement(element, wait);
    }
}
