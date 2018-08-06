package com.edwardawebb.circleci.demo.it;

import com.edwardawebb.circleci.demo.DemoApplication;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractWebIT {

    @LocalServerPort
    private int port;

    @Value("${sauce.platform}")
    private String platform;
    @Value("${sauce.version}")
    private String version;
    @Value("${sauce.browser}")
    private String browser; //{android, chrome, firefox, htmlunit, internet explorer, iPhone, iPad, opera, safari}
    @Value("${sauce.tunnel}")
    private String tunnel;

    // Enable Sauce Labs browser testing, compliment Open Source license.  SauceLabs.com
    private static String SAUCE_USER = System.getenv("SAUCELABS_USER"); //these must match env variables
    private static String SAUCE_ACCESS_KEY = System.getenv("SAUCELABS_KEY"); //these must match env variables
    public static final String SAUCE_URL = "http://" + SAUCE_USER + ":" + SAUCE_ACCESS_KEY + "@localhost:4445/wd/hub";


    public WebDriver  createWebDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser);
        caps.setCapability("platform", platform);
        caps.setCapability("version", version);
        caps.setCapability("tunnelIdentifier", tunnel);
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.INFO);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return new RemoteWebDriver(new URL(SAUCE_URL), caps);
    }

    String getBaseUrl(){
        String baseUrl = "http://localhost:" + port;
        return baseUrl;
    }




}
