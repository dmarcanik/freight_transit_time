package page_components.variable_components;

import org.openqa.selenium.WebElement;

public class TextInput implements BaseVariableComponent {
    private final WebElement inputField;

    public TextInput(WebElement inputField) {
        this.inputField = inputField;
    }

    // Method to type text into the input field
    public void typeText(String text) {
        inputField.clear();
        inputField.sendKeys(text);
    }

    // Method to get the current text inside the input field
    public String getText() {
        return inputField.getAttribute("value");
    }

    // Method to clear the input field
    public void clear() {
        inputField.clear();
    }
}
