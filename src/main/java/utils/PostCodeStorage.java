package utils;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class PostCodeStorage {
    private static final Map<String, List<String>> POSTAL_CODES = Map.of(
            "CZ", List.of("101 00", "104 00", "118 00", "142 00", "142 00", "153 00", "180 00",
                          "190 16", "678 01", "678 01", "679 05", "679 21", "679 32", "679 36", "679 51",
                          "679 71", "679 72", "679 73", "634 00", "642 00"
            ),
            "SE", List.of("553 24", "553 32", "556 29", "556 33", "561 83", "562 02", "562 22", "571 91",
                          "331 40", "333 73", "576 22", "574 23", "574 40", "573 40", "334 20", "574 42",
                          "343 31", "343 36", "285 40", "287 81"
            ),
            "DE", List.of("45711", "45889", "48149", "32427", "32839", "33104", "33617", "33818",
                          "44309", "44869", "58540", "59427", "59889", "53498", "53520", "54298",
                          "54314", "54518", "54550", "54558"
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
