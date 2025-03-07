package page_components.variable_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown implements BaseVariableComponent {

    private final WebElement dropDown;

    public DropDown(WebElement dropdown) {
        this.dropDown = dropdown;
    }

    public void selectByText(String text) {
        new Select(dropDown).selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        new Select(dropDown).selectByValue(value);
    }

    public void selectByIndex(int index) {
        new Select(dropDown).selectByIndex(index);
    }

    public String getSelectedOption() {
        return new Select(dropDown).getFirstSelectedOption()
                                   .getText();
    }

}
