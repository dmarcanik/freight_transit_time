package utils;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class PostCodeStorage {

    //Map which stores data - maybe CSV file or SQL database would be better for this kind of information
    private static final Map<String, List<String>> POSTAL_CODES = Map.of(
            "CZ", List.of("101 00", "104 00", "118 00", "142 00", "142 00", "153 00", "180 00",
                          "190 16", "678 01", "679 05"
            ),
            "SE", List.of("553 24", "553 32", "556 29", "556 33", "561 83", "571 91",
                          "331 40", "333 73"
            ),
            "DE", List.of("53498", "53520", "54298",
                          "54314", "54518", "54550", "54558"
            )
    );

    private static final Map<String, String> COUNTRY_NAMES = Map.of(
            "CZ", "Czech Republic",
            "SE", "Sweden",
            "DE", "Germany"
    );
    //returns countryName according to country code
    public static String getCountryName(String countryCode) {
        String countryName = COUNTRY_NAMES.get(countryCode);
        if (countryName == null) {
            throw new IllegalArgumentException("Invalid country code: " + countryCode);
        }
        return countryName;
    }

    //Returns random postal code according to country code
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
