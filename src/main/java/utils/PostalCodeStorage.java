package utils;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class PostalCodeStorage {

    private static final Map<String, List<String>> POSTAL_CODES = Map.of(
            "CZ", List.of("110 00", "120 00", "130 00", "140 00", "150 00", "160 00", "170 00",
                          "180 00", "190 00", "200 00", "250 01", "301 00", "400 01", "500 02",
                          "600 01", "700 30", "800 10", "900 05", "999 99"
            ),
            "SE", List.of("100 12", "111 15", "123 45", "134 56", "145 67", "156 78", "167 89",
                          "178 90", "189 01", "200 10", "211 11", "222 22", "233 33", "244 44",
                          "255 55", "266 66", "277 77", "288 88", "299 99"
            ),
            "DE", List.of("10115", "10243", "10365", "10405", "10555", "10623", "10785", "10825",
                          "10997", "11011", "12047", "13053", "14089", "15095", "16099", "17087",
                          "18059", "19055", "99998"
            )
    );

    private static final Map<String, String> COUNTRY_NAMES = Map.of(
            "CZ", "Czech Republic",
            "SE", "Sweden",
            "DE", "Germany"
    );

    public static String getCountryName(String countryCode) {
        String countryName = COUNTRY_NAMES.get(countryCode);
        if (countryName == null) {
            throw new IllegalArgumentException("Invalid country code: " + countryCode);
        }
        return countryName;
    }


    public static String getRandomPostalCodeFromCountry(String country) {
        Random random = new Random();
        List<String> postalCodes;
        switch (country) {
            case "CZ":
            case "SE":
            case "DE":
                postalCodes = POSTAL_CODES.get(country);
                break;
            default:
                throw new IllegalArgumentException("Invalid country code: " + country);

        }

        int position = random.nextInt(postalCodes.size());
        return postalCodes.get(position);
    }

}
