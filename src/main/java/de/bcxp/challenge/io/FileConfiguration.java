package de.bcxp.challenge.io;

/**
 * Enum for file reader configuration with path, delimiter and header for csv files
 */
public enum FileConfiguration {
    WEATHER_CSV("src/main/resources/de/bcxp/challenge/weather.csv", ',', true),
    COUNTRIES_CSV("src/main/resources/de/bcxp/challenge/countries.csv", ';', true),
    TEST_TEXT("src/main/resources/de/bcxp/challenge/test.txt", ',', false),
    TEST_NULL("src/main/resources/de/bcxp/challenge/test", ',', false);
    public final String path;
    public final Character delimiter;

    public final Boolean header;

    FileConfiguration(String path, Character delimiter, Boolean header) {
        this.path = path;
        this.delimiter = delimiter;
        this.header = header;
    }
}
