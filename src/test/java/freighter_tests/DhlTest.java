package freighter_tests;

import driver.BaseTest;
import org.testng.annotations.Test;
import page_objects.DhlPage;

public class DhlTest extends BaseTest {

    @Test
    public void testNavigateToDHLPage() {
        DhlPage dhlPage = new DhlPage(driver);
        dhlPage.navigateToDHLPage();
        dhlPage.clickCalculateButton();
        System.out.println("Page title: " + dhlPage.getPageTitle());

    }
}
