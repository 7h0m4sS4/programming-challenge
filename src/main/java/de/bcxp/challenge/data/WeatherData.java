package de.bcxp.challenge.data;

/**
 * Class for storing weather data points and perform operations on them.
 */
public class WeatherData {

    private final WeatherDataPoint[] dataPoints;

    public WeatherData(WeatherDataPoint[] dataPoints) {
        this.dataPoints = dataPoints;
    }

    public String calculateDayWtihMinTempSpread() {
        /**
         * Calculate the day with the minimum temperature spread.
         * @return the day with the minimum temperature spread.
         */
        int minSpread = Integer.MAX_VALUE;
        String dayWithMinSpread = null;
        for (WeatherDataPoint dataPoint : dataPoints) {
            int tempStpread = dataPoint.getTempSpread();
            if (tempStpread < minSpread) {
                minSpread = tempStpread;
                dayWithMinSpread = dataPoint.getDay();
            }
        }
        return dayWithMinSpread;
    }
}
