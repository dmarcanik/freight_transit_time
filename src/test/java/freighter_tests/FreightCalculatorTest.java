package freighter_tests;

import driver.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.FreightCalculatorPage;
import utils.PostCodeStorage;

public class FreightCalculatorTest extends BaseTest {


    @DataProvider(name = "freightDataProvider")
    public Object[][] freightDataProvider() {
        return new Object[][] {
                // Format: {originCountry, originPostcode, destinationCountry, destinationPostcode}
                {
                        PostCodeStorage.getCountryName("SE"), PostCodeStorage.getRandomPostalCodeFromCountry("SE"),
                        PostCodeStorage.getCountryName("DE"), PostCodeStorage.getRandomPostalCodeFromCountry("DE")},

                {
                        PostCodeStorage.getCountryName("CZ"), PostCodeStorage.getRandomPostalCodeFromCountry("CZ"),
                        PostCodeStorage.getCountryName("SE"), PostCodeStorage.getRandomPostalCodeFromCountry("SE")}
        };
    }


    @Test(dataProvider = "freightDataProvider")
    public void testFreightCalculator(String originCountryCode, String originPostcode, String destinationCountryCode, String destinationPostcode) {
        FreightCalculatorPage freightCalculatorPage = new FreightCalculatorPage(driver);
        freightCalculatorPage.navigateToDHLPage()
                             .selectOriginCountry(originCountryCode)
                             .selectOriginPostCode(originPostcode)
                             .selectDestinationCountry(destinationCountryCode)
                             .selectDestinationPostCode(destinationPostcode)
                             .clickCalculateButton()
                             .waitForProductTableToBeLoaded();


    }


}
