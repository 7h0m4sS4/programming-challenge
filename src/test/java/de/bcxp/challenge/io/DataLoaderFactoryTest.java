package de.bcxp.challenge.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderFactoryTest {

    @Test
    void getCSVDataLoader() {
        DataLoader dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.COUNTRIES_CSV);
        assertTrue(dataLoader instanceof CsvDataLoader);
        dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.WEATHER_CSV);
        assertTrue(dataLoader instanceof CsvDataLoader);

    }
    @Test
    void getTxtDataLoader() {
        DataLoader dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.TEST_TEXT);
        assertTrue(dataLoader instanceof TxtDataLoader);
    }
    @Test
    void getNullDataLoader() {
        DataLoader dataLoader = DataLoaderFactory.getDataLoader(FileConfiguration.TEST_NULL);
        assertNull(dataLoader);
    }
}