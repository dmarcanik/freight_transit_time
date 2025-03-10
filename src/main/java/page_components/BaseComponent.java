package page_components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Interface which should represent any element no matter if static or variable
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
        //This can be useful when clicking on any element, It should center it to avoid any overlay issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try {
            //selenium click
            element.click();
        } catch (Exception e) {
            //I sometimes spotted issues with clicking even if element was ready to click
            System.out.println("Normal click failed, using JavaScript click...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

}
