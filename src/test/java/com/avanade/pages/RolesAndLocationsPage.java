package com.avanade.pages;

import com.avanade.support.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RolesAndLocationsPage extends BasePage {

    @FindBy(css = ".second-searchbox select")
    private WebElement countries;

    @FindBy(css = ".saveButton")
    private WebElement search;

    @FindBy(css = ".listJobs li")
    private List<WebElement> jobs;

    private By next = By.cssSelector(".nextLink");

    public RolesAndLocationsPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String country) {
        Select countriesSelect = new Select(countries);
        countriesSelect.selectByVisibleText(country);
    }

    public void clickOnSearch() {
        search.click();
    }

    public int getCountOfJobs() {
        int count = jobs.size();
        while (isElement(next)) {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(next));
            actions.moveToElement(element).perform();
            element.click();
            count += jobs.size();
        }
        return count;
    }

    public boolean isJob() {
        return (jobs.size() != 0);
    }

    public void openJob(int position) {
        jobs.get(position).click();
    }
}
