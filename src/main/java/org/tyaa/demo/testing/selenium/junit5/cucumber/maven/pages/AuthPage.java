package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.decorator.custom.webelements.Button;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.decorator.custom.webelements.TextInput;

import java.time.Duration;

public class AuthPage extends AbstractPage {

    @FindBy(css = ".filter-select")
    private TextInput countryTextInput;
    @FindBy(css = ".auth-form button[type=submit]")
    private Button loginButton;

    private String phoneTextInputSelector = ".page-login__input-holder input[placeholder='Номер телефона']";
    private String passwordTextInputSelector = ".page-login__input-holder input[placeholder='Пароль']";

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public AuthPage chooseCountry(final String countryName) {
        countryTextInput.click();
        new Button(
                driver,
                driver.findElement(By.xpath(
                        String.format("//span[contains(text(),'%s')]", countryName)
                ))
        ).safeClick(1);

        return new AuthPage(driver);
    }

    public AuthPage typePhone(String phone) {
        new TextInput(
                driver,
                driver.findElement(By.cssSelector(phoneTextInputSelector))
        ).safeSendKeys(1, phone);
        return this;
    }

    public AuthPage typePassword(String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new TextInput(
                driver,
                driver.findElement(By.cssSelector(passwordTextInputSelector))
        ).safeSendKeys(1, password);
        return this;
    }

    public AuthPage clickLoginButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginButton.safeClick(1);
        return this;
    }
}
