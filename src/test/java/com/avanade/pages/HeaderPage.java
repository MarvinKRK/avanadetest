package com.avanade.pages;

import com.avanade.support.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

    @FindBy(css = "#main-navbar a[href*='careers'][role='button']")
    private WebElement careers;

    @FindBy(css = "#main-navbar a[href*='roles-and-locations']")
    private WebElement rolesAndLocations;

    public HeaderPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnRolesAndLocations() {
        actions.moveToElement(careers).perform();
        rolesAndLocations.click();
    }

    public boolean isOpenRolesAndLocations() {
        return wait.until(ExpectedConditions.urlContains("roles-and-locations"));
    }
}
