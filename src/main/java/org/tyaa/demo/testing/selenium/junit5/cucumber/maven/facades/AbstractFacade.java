package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.facades;

import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.utils.WebDriverSingletone;

public abstract class AbstractFacade {
    protected final WebDriverSingletone webDriverSingletone;

    public AbstractFacade() {
        webDriverSingletone = WebDriverSingletone.getInstance();
    }

    public void open(String urlString) {
        webDriverSingletone.getDriver().get(urlString);
    }

    public void close() {
        webDriverSingletone.closeDriver();
    }
}
