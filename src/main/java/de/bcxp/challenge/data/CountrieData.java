package de.bcxp.challenge.data;

/**
 * Class for storing countrie data points and perform operations on them.
 */
public class CountrieData {
    private final CountrieDataPoint[] dataPoints;

    public CountrieData(CountrieDataPoint[] dataPoints) {
        this.dataPoints = dataPoints;
    }

    public String calculateCountryWithHighestPopulationDensity() {
        int maxPopulationDensity = Integer.MIN_VALUE;
        String countryWithHighestPopulationDensity = null;
        for (CountrieDataPoint dataPoint : dataPoints) {
            int populationDensity = dataPoint.getPopulationDensity();
            if (populationDensity > maxPopulationDensity) {
                maxPopulationDensity = populationDensity;
                countryWithHighestPopulationDensity = dataPoint.getCountryName();
            }
        }
        return countryWithHighestPopulationDensity;
    }
}
