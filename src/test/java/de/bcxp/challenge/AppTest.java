package de.bcxp.challenge;

import de.bcxp.challenge.data.CountrieData;
import de.bcxp.challenge.data.WeatherData;
import de.bcxp.challenge.io.DataLoader;
import de.bcxp.challenge.io.DataLoaderFactory;
import de.bcxp.challenge.io.FileConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Example JUnit 5 test case.
 */
class AppTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void weatherSuccessTest() {
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
            assertEquals("14",weatherData.calculateDayWtihMinTempSpread());
        }
    }

    @Test
    void weatherFailureTest() {
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
            assertNotEquals("13",weatherData.calculateDayWtihMinTempSpread());
        }
    }

    @Test
    void countrieSuccessTest() {
        //Create a new instance of the DataLoader
        DataLoader dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.COUNTRIES_CSV);

        //Create a new instance of the CountrieData
        if (dataLoader != null) {
            CountrieData countrieData = null;
            try {
                countrieData = dataLoader.loadCountryFromSource(FileConfiguration.COUNTRIES_CSV);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            assertEquals("Malta",countrieData.calculateCountryWithHighestPopulationDensity());

        }
    }

    @Test
    void countrieFailureTest() {
        //Create a new instance of the DataLoader
        DataLoader dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.COUNTRIES_CSV);

        //Create a new instance of the CountrieData
        if (dataLoader != null) {
            CountrieData countrieData = null;
            try {
                countrieData = dataLoader.loadCountryFromSource(FileConfiguration.COUNTRIES_CSV);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            assertNotEquals("Luxembourg",countrieData.calculateCountryWithHighestPopulationDensity());
        }
    }

}