package com.avanade.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver = SeleniumController.driver;
    protected WebDriverWait wait = SeleniumController.wait;
    protected Actions actions = SeleniumController.actions;

    protected boolean isElement(By by) {
        List<WebElement> elements = driver.findElements(by);
        return (elements.size() != 0);
    }
}
