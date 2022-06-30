package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.decorator.CustomWebElementFieldDecorator;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
            webDriver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete")
        );
        PageFactory.initElements(new CustomWebElementFieldDecorator(driver), this);
    }
}
