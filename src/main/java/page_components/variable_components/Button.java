package page_components.variable_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends BaseVariableComponent {


    public Button(WebElement element) {
        super(element);
    }

    public void click(WebDriverWait wait, WebDriver driver) {
        clickElement(getElement(), wait, driver);
    }



}
