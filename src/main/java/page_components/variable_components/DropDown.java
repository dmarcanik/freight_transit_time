package page_components.variable_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown extends CustomComponent {


    public DropDown(WebElement element, WebDriverWait wait, WebDriver driver) {
        super(element, wait, driver);
    }

    public void selectByText(String text) {
        new Select(getElement()).selectByVisibleText(text);
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
