package freighter_tests;

import driver.BaseTest;
import org.testng.annotations.Test;
import page_objects.FreightCalculatorPage;
import utils.PostCodeStorage;

public class FreightCalculatorTest extends BaseTest {

    @Test
    public void testFreightCalculator() {
        FreightCalculatorPage freightCalculatorPage = new FreightCalculatorPage(driver);
        freightCalculatorPage.navigateToDHLPage()
                             .selectOriginCountry(PostCodeStorage.getCountryName("CZ"))
                             .selectOriginPostCode(PostCodeStorage.getRandomPostalCodeFromCountry("CZ"))
                             .selectDestinationCountry(PostCodeStorage.getCountryName("SE"))
                             .selectDestinationPostCode(PostCodeStorage.getRandomPostalCodeFromCountry("SE"))
                             .clickCalculateButton();


    }
}
