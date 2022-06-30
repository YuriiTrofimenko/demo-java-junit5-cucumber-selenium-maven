package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.facades;

import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.pages.AuthPage;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.pages.HomePage;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.utils.ValueWrapper;

public class SmokeTestFacade extends AbstractFacade {

    public SmokeTestFacade login(String countryName, String phone, String password) {
        new AuthPage(webDriverSingletone.getDriver()).chooseCountry(countryName)
                .typePhone(phone)
                .typePassword(password)
                .clickLoginButton();
        return this;
    }

    public SmokeTestFacade getHomePageHeaderText(ValueWrapper<String> headerText) {
        headerText.value =
                new HomePage(webDriverSingletone.getDriver())
                        .getHeaderText();
        return this;
    }

    public SmokeTestFacade getHomePageNavItemsCount(ValueWrapper<Integer> count) {
        count.value =
                new HomePage(webDriverSingletone.getDriver())
                        .getNavItemsCount();
        return this;
    }
}
