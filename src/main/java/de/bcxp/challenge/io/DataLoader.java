package de.bcxp.challenge.io;

import de.bcxp.challenge.data.CountrieData;
import de.bcxp.challenge.data.WeatherData;

// .txt .csv .json .xml .db
public abstract class DataLoader {
    /**
     * Load weather or countrie data from a source
     *
     * @param source The source configuration of the data
     * @return WeatherData
     * @throws Exception If the data could not be loaded from the source
     */
    public abstract WeatherData loadWeatherFromSource(FileConfiguration source) throws Exception;

    public abstract CountrieData loadCountryFromSource(FileConfiguration source) throws Exception;

}

