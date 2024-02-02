package de.bcxp.challenge.io;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import de.bcxp.challenge.data.CountrieData;
import de.bcxp.challenge.data.CountrieDataPoint;
import de.bcxp.challenge.data.WeatherData;
import de.bcxp.challenge.data.WeatherDataPoint;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * Concrete class for reading data from a CSV file (.csv)
 * This class uses the OpenCSV library to read the data from the file.
 */
public class CsvDataLoader extends DataLoader {
    private Path path;
    private Character delimiter;
    private boolean header;
    private CSVReader csvReader;

    /**
     * Set the configuration for reading weather data from a CSV file
     *
     * @param source The source file configuration
     */
    public void setWeatherConfiguration(FileConfiguration source) {
        this.path = Paths.get(source.path);
        this.delimiter = source.delimiter;
        this.header = source.header;
    }

    /**
     * Set the configuration for reading country data from a CSV file
     *
     * @param source The source file configuration
     */
    private void setCountrieConfiguration(FileConfiguration source) {
        this.path = Paths.get(source.path);
        this.delimiter = source.delimiter;
        this.header = source.header;
    }

    /**
     * Load weather data from a CSV file
     *
     * @param source The source file configuration
     * @return The weather data
     */
    @Override
    public WeatherData loadWeatherFromSource(FileConfiguration source) {
        setWeatherConfiguration(source);
        WeatherDataPoint[] weatherData = null;
        List<String[]> lines = readAllLines();
        if (lines != null) {
            weatherData = new WeatherDataPoint[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i);
                weatherData[i] = DataParser.parseWeatherData(line);
            }
        }
        return weatherData != null ? new WeatherData(weatherData) : null;
    }

    /**
     * Load country data from a CSV file
     *
     * @param source The source file configuration
     * @return The country data
     */
    @Override
    public CountrieData loadCountryFromSource(FileConfiguration source) {
        setCountrieConfiguration(source);
        CountrieDataPoint[] countieData = null;
        List<String[]> lines = readAllLines();

        if (lines != null) {
            countieData = new CountrieDataPoint[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i);
                countieData[i] = DataParser.parseCountryData(line);
            }
        }
        return countieData != null ? new CountrieData(countieData) : null;
    }

    /**
     * Read all lines from the file
     *
     * @return A list of all lines in the file
     * @throws RuntimeException If an error occurs while reading the file
     */
    public List<String[]> readAllLines() {
        try (Reader reader = Files.newBufferedReader(path)) {
            CSVParser parser = getParserWithConfiguration(false);
            CSVReader csvReader = getCsvReaderWithConfiguration(reader, parser, header);

            return csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get a CSVParser with the given configuration
     *
     * @param ignoreQuotations Whether to ignore quotations or not
     * @return A CSVParser with the given configuration
     */
    private CSVParser getParserWithConfiguration(boolean ignoreQuotations) {
        return new CSVParserBuilder()
                .withSeparator(delimiter)
                .withIgnoreQuotations(ignoreQuotations)
                .build();
    }

    /**
     * Get a CSVReader with the given configuration
     *
     * @param reader The reader to read the data from
     * @param parser The parser to parse the data with
     * @param header Whether the file has a header or not
     * @return A CSVReader with the given configuration
     */
    private CSVReader getCsvReaderWithConfiguration(Reader reader, CSVParser parser, boolean header) {
        if (header) {
            return new CSVReaderBuilder(reader)
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build();
        }
        return new CSVReaderBuilder(reader)
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();
    }
}
