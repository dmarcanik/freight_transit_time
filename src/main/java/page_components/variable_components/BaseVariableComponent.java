package page_components.variable_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseVariableComponent {

    protected WebElement element;

    public BaseVariableComponent(WebElement element) {
        this.element = element;
    }

    public void waitForVisibility(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
