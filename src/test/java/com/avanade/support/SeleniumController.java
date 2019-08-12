package com.avanade.support;

import com.avanade.config.Configuration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class SeleniumController {

    private static int driverTimeout = 20;
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    static void start() {
        System.setProperty("webdriver.chrome.driver", Configuration.chromedriver);
        if (driver != null) {
            return;
        }

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(driverTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(driverTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(driverTimeout, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1500, 800));

        wait = new WebDriverWait(driver, driverTimeout);
        actions = new Actions(driver);
    }

    static void stop() {
        if (driver != null) {
            driver.getWindowHandles().forEach(window -> driver.switchTo().window(window).close());
            driver.quit();
            driver = null;
            wait = null;
            actions = null;
        }
    }
}
