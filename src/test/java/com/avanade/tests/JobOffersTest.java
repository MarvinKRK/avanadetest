package com.avanade.tests;

import com.avanade.pages.CookiePage;
import com.avanade.pages.HeaderPage;
import com.avanade.pages.JobPage;
import com.avanade.pages.RolesAndLocationsPage;
import com.avanade.support.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class JobOffersTest extends BaseTest {

    private CookiePage cookiePage;
    private HeaderPage headerPage;
    private RolesAndLocationsPage rolesAndLocationsPage;
    private JobPage jobPage;

    @BeforeMethod()
    public void setPages() {
        cookiePage = new CookiePage();
        headerPage = new HeaderPage();
        rolesAndLocationsPage = new RolesAndLocationsPage();
        jobPage = new JobPage();
    }

    @Test()
    public void canadaTest() {
        cookiePage.acceptCookies();
        headerPage.clickOnRolesAndLocations();

        assertThat(headerPage.isOpenRolesAndLocations()).isTrue();

        rolesAndLocationsPage.selectCountry("Canada");
        rolesAndLocationsPage.clickOnSearch();
        assertThat(rolesAndLocationsPage.getCountOfJobs()).isGreaterThan(10);
    }

    @Test()
    public void denmarkTest() {
        cookiePage.acceptCookies();
        headerPage.clickOnRolesAndLocations();

        assertThat(headerPage.isOpenRolesAndLocations()).isTrue();

        rolesAndLocationsPage.selectCountry("Denmark");
        rolesAndLocationsPage.clickOnSearch();
        assertThat(rolesAndLocationsPage.isJob()).isTrue();
    }

    @Test()
    public void agileTest() {
        cookiePage.acceptCookies();
        headerPage.clickOnRolesAndLocations();

        assertThat(headerPage.isOpenRolesAndLocations()).isTrue();

        rolesAndLocationsPage.clickOnSearch();
        assertThat(rolesAndLocationsPage.isJob()).isTrue();
        rolesAndLocationsPage.openJob(0);
        if (jobPage.isWord("Agile", new String[]{"Requirements", "requirements", "Qualifications", "qualifications"})) {
            logger.info("This offer contains 'Agile'");
        } else {
            logger.info("This offer not contains 'Agile'");
        }
        if (jobPage.isWord("agile", new String[]{"Requirements", "requirements", "Qualifications", "qualifications"})) {
            logger.info("This offer contains 'agile'");
        } else {
            logger.info("This offer not contains 'agile'");
        }
    }
}
