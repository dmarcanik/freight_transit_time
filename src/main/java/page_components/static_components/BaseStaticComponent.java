package page_components.static_components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_components.BaseComponent;

//Interface for all components which does not change but, can appear everywhere
public interface BaseStaticComponent extends BaseComponent {

    default void initialize(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
