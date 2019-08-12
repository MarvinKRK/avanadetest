package com.avanade.pages;

import com.avanade.support.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobPage extends BasePage {

    @FindBy(css = ".mainDetails")
    private WebElement jobDescription;

    public JobPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isWord(String word, String[] sections) {
        List<WebElement> lists = jobDescription.findElements(By.xpath(".//*[contains(text(), '" + word + "')]"));
        for (WebElement element : lists) {
            WebElement parent = element.findElement(By.xpath("./.."));
            while (parent != jobDescription) {
                for (String section : sections) {
                    if (parent.getText().contains(section)) {
                        return true;
                    }
                }
                parent = parent.findElement(By.xpath("./.."));
            }
        }
        return false;
    }
}
