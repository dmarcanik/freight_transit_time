package page_components.variable_components;

import org.openqa.selenium.WebElement;
import page_components.BaseComponent;

//Interface which can serves for all variable element, like buttons, dropdowns, inputs etc.
public class BaseVariableComponent implements BaseComponent {
    private final WebElement element;

    public BaseVariableComponent(WebElement element) {
        this.element = element;

    }

    public WebElement getElement() {
        return element;
    }
}
