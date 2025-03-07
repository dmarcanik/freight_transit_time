package page_components.variable_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseVariableComponent {


    public DropDown(WebElement dropdown) {
        super(dropdown);
    }

    public void selectByText(String text) {
        new Select(element).selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        new Select(element).selectByValue(value);
    }

    public void selectByIndex(int index) {
        new Select(element).selectByIndex(index);
    }

    public String getSelectedOption() {
        return new Select(element).getFirstSelectedOption()
                     .getText();
    }

}
