package freighter_tests;

import driver.BaseTest;
import org.testng.annotations.Test;
import page_objects.FreightCalculatorPage;
import utils.PostCodeStorage;

public class FreightCalculatorNegativeTest extends BaseTest {

    @Test
    public void testFreightCalculator() {
        FreightCalculatorPage freightCalculatorPage = new FreightCalculatorPage(driver);
        freightCalculatorPage.navigateToDHLPage()
                             .selectOriginCountry(PostCodeStorage.getCountryName("CZ"))
                             .selectDestinationCountry(PostCodeStorage.getCountryName("SE"))
                             .clickCalculateButton()
                             .verifyPostcodeErrorMessages()
                             .selectOriginPostCode(PostCodeStorage.getRandomPostalCodeFromCountry("CZ"))
                             .selectDestinationPostCode("590 52")
                             .clickCalculateButton()
                             .verifyShipmentError();


    }
}
