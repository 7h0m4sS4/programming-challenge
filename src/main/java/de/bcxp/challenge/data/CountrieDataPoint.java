package de.bcxp.challenge.data;

/**
 * This class represents a single countrie data point.
 */
public class CountrieDataPoint {
    private final String name;
    private final int population;
    private final int area;

    /**
     * Constructor for a single countrie data point.
     *
     * @param country
     * @param population
     * @param area
     */
    public CountrieDataPoint(String country, int population, int area) {
        this.name = country;
        this.population = population;
        this.area = area;
    }

    public int getPopulationDensity() {
        return population / area;
    }

    public String getCountryName() {
        return name;
    }
}
