package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.decorator.custom.webelements.Button;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.decorator.custom.webelements.TextBlock;
import org.tyaa.demo.testing.selenium.junit5.cucumber.maven.decorator.custom.webelements.TextInput;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = "h1.page-header__header")
    private TextBlock headerTextBlock;
    @FindBy(css = ".aside__nav span")
    private List<WebElement> navbar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return headerTextBlock.getText();
    }

    public Integer getNavItemsCount() {
        return navbar.size();
    }
}
