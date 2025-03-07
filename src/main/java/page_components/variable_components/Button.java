package page_components.variable_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button implements BaseVariableComponent {


    private final WebElement button;

    public Button(WebElement button) {
        this.button = button;
    }

    public void click(WebDriverWait wait, WebDriver driver) {
        clickElement(button, wait, driver);
    }



}
