package page_components.variable_components;

import org.openqa.selenium.WebElement;

public class TextInput implements BaseVariableComponent {
    private final WebElement inputField;

    public TextInput(WebElement inputField) {
        this.inputField = inputField;
    }

    public void typeText(String text) {
        clear();
        inputField.sendKeys(text);
    }

    public void clear() {
        inputField.clear();
    }
}
