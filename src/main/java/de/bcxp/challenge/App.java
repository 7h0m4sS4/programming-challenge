package de.bcxp.challenge;

import de.bcxp.challenge.data.CountrieData;
import de.bcxp.challenge.data.WeatherData;
import de.bcxp.challenge.io.DataLoader;
import de.bcxp.challenge.io.DataLoaderFactory;
import de.bcxp.challenge.io.FileConfiguration;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        //Create a new instance of the DataLoader
        DataLoader dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.WEATHER_CSV);

        //Create a new instance of the WeatherData
        if (dataLoader != null) {
            WeatherData weatherData = null;
            try {
                weatherData = dataLoader.loadWeatherFromSource(FileConfiguration.WEATHER_CSV);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String dayWithSmallestTempSpread = weatherData.calculateDayWtihMinTempSpread();
            System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);
        }

        //Create a new instance of the DataLoader
        dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.COUNTRIES_CSV);

        //Create a new instance of the CountrieData
        if (dataLoader != null) {
            CountrieData countrieData = null;
            try {
                countrieData = dataLoader.loadCountryFromSource(FileConfiguration.COUNTRIES_CSV);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String countryWithHighestPopulationDensity = countrieData.calculateCountryWithHighestPopulationDensity();
            System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
        }
    }
}
