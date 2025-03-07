package page_components.static_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface BaseStaticComponent {

    // Default method for waiting for an element
    default void waitForElement(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Default method for clicking an element
    default void clickElement(WebElement element, WebDriverWait wait) {
        waitForElement(element, wait);
        element.click();
    }

    // Default method for typing text
    default void typeText(WebElement element, String text, WebDriverWait wait) {
        waitForElement(element, wait);
        element.clear();
        element.sendKeys(text);
    }
}
