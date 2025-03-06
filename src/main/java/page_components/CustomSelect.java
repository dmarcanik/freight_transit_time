package page_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomSelect {

    private final Select select;

    public CustomSelect(WebElement dropdownElement) {
        this.select = new Select(dropdownElement);
    }

    public void selectByText(String text) {
        select.selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        select.selectByValue(value);
    }

    public void selectByIndex(int index) {
        select.selectByIndex(index);
    }

    public String getSelectedOption() {
        return select.getFirstSelectedOption()
                     .getText();
    }

}
