package page_components.static_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_components.BaseComponent;

//Class for all components which does not change but, can appear everywhere
public class BaseStaticComponent implements BaseComponent {

    void initialize(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
