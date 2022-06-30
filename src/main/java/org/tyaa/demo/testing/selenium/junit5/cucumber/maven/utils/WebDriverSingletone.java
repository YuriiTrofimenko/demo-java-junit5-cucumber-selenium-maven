package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverSingletone {

    private static WebDriverSingletone instance;

    private final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingletone() {}

    public static WebDriverSingletone getInstance() {
        if (instance == null) {
            instance = new WebDriverSingletone();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        WebDriver driver;
        String driverName = new PropertiesReader().getDriverName();
        String driverLocation = new PropertiesReader().getDriverLocation();
        System.setProperty(driverName, driverLocation);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options) {
            {
                manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        };
        webDriverThreadLocal.set(driver);
        return webDriverThreadLocal.get();
    }

    public void closeDriver() {
        try {
            webDriverThreadLocal.get().quit();
        }
        catch (Exception e) {
            System.err.println("Ошибка: невозможно закрыть Webdriver.");
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}