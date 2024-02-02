package de.bcxp.challenge.data;

/**
 * This class represents a single weather data point.
 * It contains the weather data for a single day.
 */
public class WeatherDataPoint {
    private final String day;
    private final int maxTemp; //The highest temperature of the day.
    private final int minTemp; //The lowest temperature of the day.
    private int averageTemp; //The average daily temperature (the sum of MxT and MnT divided by 2.)
    private double averageDewPoint; //The average of the dew point for each hour of the day.
    private double maxPrec; //1HrP: The maximum precipitation that fell in one hour during the day. If 0.00 is shown it indicates a Trace.
    private double totalPrec; //Tpcpn: The total precipitation for the day. T indicates a trace. 0.00 indicates either 0 precipitation fell or that the total for the day is missing.
    private int windDir; //PDir The prevailing wind direction in degrees (360 is north, 090 is east, 180 is south, 270 is west) averaged over 36 points of the compass.
    private double averageWindSpeed; //AvSp: The average wind speed in miles per hour.
    private int peakGustDirection; //Dir: The direction the peak wind gust came from in degrees (360 is north, 090 is east, 180 is south, 270 is west).
    private int maxWindSpeedGust; // MxS:The maximum wind speed gust or peak wind in miles an hour.
    private double skyCover; //SkyC: The total sky cover is tenths. 10.0 indicates total cloud cover through the entire day. 0.0 indicates nearly clear. High thin clouds may not be included in the total sky cover for some locations.
    private int maxRelHumidity; //MxR:The maximum relative humidity for the day.
    private int minRelHumidity; //MnR:The minimum relative humidity for the day.
    private double averageSeaLevel; //AvSLP:The average sea level pressure for the day.

    /**
     * Constructor for the WeatherDataPoint class.
     *
     * @param day The day of the weather data point.
     * @param maxTemp The highest temperature of the day.
     * @param minTemp The lowest temperature of the day.
     * @param averageTemp The average daily temperature (the sum of MxT and MnT divided by 2.)
     * @param averageDewPoint The average of the dew point for each hour of the day.
     * @param maxPrec The maximum precipitation that fell in one hour during the day. If 0.00 is shown it indicates a Trace.
     * @param totalPrec The total precipitation for the day. T indicates a trace. 0.00 indicates either 0 precipitation fell or that the total for the day is missing.
     * @param windDir The prevailing wind direction in degrees (360 is north, 090 is east, 180 is south, 270 is west) averaged over 36 points of the compass.
     * @param averageWindSpeed The average wind speed in miles per hour.
     * @param peakGustDirection The direction the peak wind gust came from in degrees (360 is north, 090 is east, 180 is south, 270 is west).
     * @param maxWindSpeedGust The maximum wind speed gust or peak wind in miles an hour.
     * @param skyCover The total sky cover is tenths. 10.0 indicates total cloud cover through the entire day. 0.0 indicates nearly clear. High thin clouds may not be included in the total sky cover for some locations.
     * @param maxRelHumidity The maximum relative humidity for the day.
     * @param minRelHumidity The minimum relative humidity for the day.
     * @param averageSeaLevel The average sea level pressure for the day.
     * @throws IllegalArgumentException If maxTemp is less than minTemp.
     */
    public WeatherDataPoint(String day, int maxTemp, int minTemp, int averageTemp, double averageDewPoint, double maxPrec, double totalPrec, int windDir, double averageWindSpeed, int peakGustDirection, int maxWindSpeedGust, double skyCover, int maxRelHumidity, int minRelHumidity, double averageSeaLevel) throws IllegalArgumentException {
        if (maxTemp < minTemp) {
            throw new IllegalArgumentException("maxTemp must be greater than minTemp");
        }
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.averageTemp = averageTemp;
        this.averageDewPoint = averageDewPoint;
        this.maxPrec = maxPrec;
        this.totalPrec = totalPrec;
        this.windDir = windDir;
        this.averageWindSpeed = averageWindSpeed;
        this.peakGustDirection = peakGustDirection;
        this.maxWindSpeedGust = maxWindSpeedGust;
        this.skyCover = skyCover;
        this.maxRelHumidity = maxRelHumidity;
        this.minRelHumidity = minRelHumidity;
        this.averageSeaLevel = averageSeaLevel;

    }

    /**
     * Constructor for the WeatherDataPoint class.
     *
     * @param day
     * @param maxTemp
     * @param minTemp
     * @throws IllegalArgumentException
     */
    public WeatherDataPoint(String day, int maxTemp, int minTemp) throws IllegalArgumentException {
        if (maxTemp < minTemp) {
            throw new IllegalArgumentException("maxTemp must be greater than minTemp");
        }
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getTempSpread() {
        return maxTemp - minTemp;
    }
}
