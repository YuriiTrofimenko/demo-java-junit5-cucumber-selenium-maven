package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.steps;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.facades.SmokeTestFacade;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.utils.ValueWrapper;

public class SmokeSteps {

    private SmokeTestFacade facade;
    private ValueWrapper<String> homePageHeaderValueWrapper;
    private ValueWrapper<Integer> homePageNavItemsCountValueWrapper;

    @Before
    public void setupScenario () {
        facade = new SmokeTestFacade();
        homePageHeaderValueWrapper = new ValueWrapper<>();
        homePageNavItemsCountValueWrapper = new ValueWrapper<>();
    }

    @Given("Пользователь переходит по начальному адресу сайта {string} и попадает на страницу входа")
    public void openAuthPage(final String url) {
        facade.open(url);
    }

    @When("Пользователь входит на сайт, выбрав страну {string}, введя телефон {string} и пароль {string}")
    public void findProductsByCategory(
            final String countryName,
            final String phone,
            final String password
    ) throws InterruptedException {
        System.out.printf("%s %s %s", countryName, phone, password);
        facade.login(countryName, phone, password);
    }

    @Then("Пользователь попадает на страницу с заголовком {string}")
    public void checkHomePageHeaderText(final String expectedHeaderText) {
        facade.getHomePageHeaderText(homePageHeaderValueWrapper);
        System.out.println(expectedHeaderText);
        System.out.println(homePageHeaderValueWrapper.value);
        Assert.isTrue(
                homePageHeaderValueWrapper.value.equals(expectedHeaderText),
                String.format("Ожидаемый заголовок %s не найден", expectedHeaderText)
        );
    }

    @Then("Пользователь видит на панели навигации список из {int} заголовка разделов")
    public void checkHomePageHeaderText(final Integer expectedNavItemsCount) {
        facade.getHomePageNavItemsCount(homePageNavItemsCountValueWrapper);
        Assert.isTrue(
                homePageNavItemsCountValueWrapper.value.equals(expectedNavItemsCount),
                String.format(
                        "Ожидалось количество пунктов навигационного меню %s, найдено %s",
                        expectedNavItemsCount,
                        homePageNavItemsCountValueWrapper.value
                )
        );
    }

    @After
    public void tearDownScenario() {
        facade.close();
    }
}
