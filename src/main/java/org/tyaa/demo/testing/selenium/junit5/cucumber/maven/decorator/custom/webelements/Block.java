package org.tyaa.demo.testing.selenium.junit5.cucumber.maven.decorator.custom.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Block extends AbstractElement {
    public Block(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
