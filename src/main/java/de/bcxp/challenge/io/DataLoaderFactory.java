package de.bcxp.challenge.io;

public class DataLoaderFactory {
    /**
     * Factory pattern to create a DataLoader based on the file extension
     *
     * @param source FileConfiguration
     * @return DataLoader or null if the file extension is not supported
     */
    public static DataLoader getDataLoader(FileConfiguration source) {
        if (source.path.endsWith(".txt")) {
            return new TxtDataLoader();
        } else if (source.path.endsWith(".csv")) {
            return new CsvDataLoader();
        } else if (source.path.endsWith(".json")) {
            return new JsonDataLoader();
        } else if (source.path.endsWith(".xml")) {
            return new XmlDataLoader();
        } else {
            return null;
        }
    }
}
