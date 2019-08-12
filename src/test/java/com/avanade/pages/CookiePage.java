package com.avanade.pages;

import com.avanade.support.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookiePage extends BasePage {

    @FindBy(css = ".accept-cookies-button")
    private WebElement cookie;

    public CookiePage() {
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        cookie.click();
        wait.until(ExpectedConditions.invisibilityOf(cookie));
    }
}
