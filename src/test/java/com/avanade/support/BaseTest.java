package com.avanade.support;

import com.avanade.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static final Logger logger = LogManager.getLogger();

    @BeforeMethod
    public void setUp() {
        SeleniumController.start();
        SeleniumController.driver.get(Configuration.url);
        logger.info("Start browser");
    }

    @AfterMethod
    public void tearDown() {
        SeleniumController.stop();
        logger.info("Stop browser");
    }
}
