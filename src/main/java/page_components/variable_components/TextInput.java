package page_components.variable_components;

import org.openqa.selenium.WebElement;

public class TextInput extends BaseVariableComponent {


    public TextInput(WebElement input) {
        super(input);
    }

    // Method to type text into the input field
    public void typeText(String text) {
        element.clear();
        element.sendKeys(text);
    }

    // Method to get the current text inside the input field
    public String getText() {
        return element.getAttribute("value");
    }

    // Method to clear the input field
    public void clear() {
        element.clear();
    }
}
