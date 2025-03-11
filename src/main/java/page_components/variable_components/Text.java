package page_components.variable_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Text extends CustomComponent {

    public Text(WebElement element, WebDriverWait wait, WebDriver driver) {
        super(element, wait, driver);
    }
}
