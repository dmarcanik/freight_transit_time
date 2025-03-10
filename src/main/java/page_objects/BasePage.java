package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_components.variable_components.Button;
import page_components.variable_components.DropDown;
import page_components.variable_components.Text;
import page_components.variable_components.Input;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        PageFactory.initElements(driver, this);
    }


    protected DropDown dropDown(WebElement dropdownElement) {
        return new DropDown(dropdownElement);
    }

    protected Input textInput(WebElement inputElement) {
        return new Input(inputElement);
    }

    protected Button button (WebElement buttonElement){
        return new Button(buttonElement);
    }

    protected Text text(WebElement textElement){
        return new Text(textElement);
    }

}