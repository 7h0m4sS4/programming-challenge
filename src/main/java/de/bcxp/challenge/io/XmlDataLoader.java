package de.bcxp.challenge.io;

import de.bcxp.challenge.data.CountrieData;
import de.bcxp.challenge.data.WeatherData;
import de.bcxp.challenge.exceptions.NotImplementedException;

// Concrete class for reading data from an XML file (.xml)
public class XmlDataLoader extends DataLoader {

    @Override
    public WeatherData loadWeatherFromSource(FileConfiguration sourceName) throws NotImplementedException {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public CountrieData loadCountryFromSource(FileConfiguration sourceName) throws NotImplementedException {
        throw new NotImplementedException("Not implemented yet.");
    }
}
