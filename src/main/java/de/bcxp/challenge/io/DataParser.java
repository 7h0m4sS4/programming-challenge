package de.bcxp.challenge.io;

import de.bcxp.challenge.data.CountrieDataPoint;
import de.bcxp.challenge.data.WeatherDataPoint;

/**
 * This class is responsible for parsing the data from String[] to the appropriate data points
 *
 * @see WeatherDataPoint
 * @see CountrieDataPoint
 */
public class DataParser {

    /**
     * @param data The data to parse
     * @return A new instance of the WeatherDataPoint
     */
    public static WeatherDataPoint parseWeatherData(String[] data) {
        String day = data[0];
        int maxTemp = Integer.parseInt(data[1]);
        int minTemp = Integer.parseInt(data[2]);
        return new WeatherDataPoint(day, maxTemp, minTemp);
    }

    /**
     * @param data The data to parse
     * @return A new instance of the CountrieDataPoint
     * @throws NumberFormatException If the data is invalid
     */
    public static CountrieDataPoint parseCountryData(String[] data) throws NumberFormatException {
        String country = data[0];
        Integer population = null;
        Integer area = null;
        try {
            population = Integer.parseInt(cleanIntegerString(data[3]));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid population value for country " + country);
        }
        try {
            area = Integer.parseInt(cleanIntegerString(data[4]));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid area value for country " + country);
        }
        return (country != null && population != null && area != null) ? new CountrieDataPoint(country, population, area) : null;
    }

    private static String cleanIntegerString(String s) {
        return cleanIntegerStringFromTrailingCommaValues(cleanIntegerStringFromDot(s));
    }

    private static String cleanIntegerStringFromDot(String s) {
        return s.replaceAll("[.]", "");
    }

    private static String cleanIntegerStringFromTrailingCommaValues(String s) {
        return s.replaceAll("[.]", "").split(",")[0];
    }


}
