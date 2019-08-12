package com.avanade.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

    private static final Config CONFIG = ConfigFactory.load("configuration.conf");
    private static final Config CHROME_WEBDRIVER = CONFIG.getConfig("webdriver").getConfig("chrome");
    public static String chromedriver = CHROME_WEBDRIVER.getString("driver");
    public static String url = CONFIG.getString("url");
}
