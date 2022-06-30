package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesReader {
    private final static Logger logger = Logger.getLogger(String.valueOf(PropertiesReader.class));
    private final static String PATH_TO_CONFIG_PROPS = "src/main/resources/config.properties";
    private Properties property = new Properties();

    public PropertiesReader() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(PATH_TO_CONFIG_PROPS);
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            logger.info("Файл свойств не найден. Подробнее смотри в журнале.");
            System.err.printf("Ошибка: Файл свойств %s не найдел", PATH_TO_CONFIG_PROPS);
        }
    }

    public String getDriverName() {
        String CHROME_DRIVER_NAME = property.getProperty("CHROME_DRIVER_NAME");
        return CHROME_DRIVER_NAME;
    }

    public String getDriverLocation() {
        String CHROME_DRIVER_LOCATION = property.getProperty("CHROME_DRIVER_LOCATION");
        return CHROME_DRIVER_LOCATION;
    }
}