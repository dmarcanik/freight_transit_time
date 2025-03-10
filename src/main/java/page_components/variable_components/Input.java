package page_components.variable_components;

import org.openqa.selenium.WebElement;

public class Input extends BaseVariableComponent {

    public Input(WebElement element) {
        super(element);

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
