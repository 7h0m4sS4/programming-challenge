package de.bcxp.challenge.io;

import de.bcxp.challenge.data.CountrieData;
import de.bcxp.challenge.data.WeatherData;
import de.bcxp.challenge.exceptions.NotImplementedException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {
    public DataLoader dataLoader;


    @Test
    void loadWeatherFromSourceNotImplemented() {
        dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.TEST_TEXT);
        assertThrows(NotImplementedException.class, () -> dataLoader.loadWeatherFromSource(FileConfiguration.WEATHER_CSV));

    }

    @Test
    void loadWeatherFromCSVSource() {
        dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.WEATHER_CSV);
        try {
            assertInstanceOf(WeatherData.class, dataLoader.loadWeatherFromSource(FileConfiguration.WEATHER_CSV));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void loadCountryFromSource() {
        dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.COUNTRIES_CSV);
        try {
            assertInstanceOf(CountrieData.class, dataLoader.loadCountryFromSource(FileConfiguration.COUNTRIES_CSV));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}