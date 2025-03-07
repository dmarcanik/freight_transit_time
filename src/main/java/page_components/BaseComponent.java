package page_components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface BaseComponent {
    default void waitForElement(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    default void waitForElementToBeClickable(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    default void clickElement(WebElement element, WebDriverWait wait) {
        waitForElementToBeClickable(element, wait);
        element.click();
    }


    default void clickElement(WebElement element, WebDriverWait wait, WebDriver driver) {
        waitForElementToBeClickable(element, wait);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try {
            element.click(); // Normal Selenium click
        } catch (Exception e) {
            System.out.println("Normal click failed, using JavaScript click...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    default void typeText(WebElement element, String text, WebDriverWait wait) {
        waitForElement(element, wait);
        element.clear();
        element.sendKeys(text);
    }
}
