package page_components.variable_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input extends CustomComponent {

    public Input(WebElement element, WebDriverWait wait, WebDriver driver) {
        super(element, wait, driver);

    }

    public void typeText(String text) {
        clear();
        super.getElement()
             .sendKeys(text);
    }

    public void clear() {
        super.getElement()
             .clear();
    }
}
