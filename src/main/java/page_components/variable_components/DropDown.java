package page_components.variable_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseVariableComponent {


    public DropDown(WebElement dropdown) {
        super(dropdown);
    }

    public void selectByText(String text) {
        new Select(super.getElement()).selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        new Select(super.getElement()).selectByValue(value);
    }

    public void selectByIndex(int index) {
        new Select(super.getElement()).selectByIndex(index);
    }

    public String getSelectedOption() {
        return new Select(super.getElement()).getFirstSelectedOption()
                                             .getText();
    }

}
