package com.edwardawebb.circleci.demo.it;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AboutPageIT extends AbstractWebIT {

    @Test
    public void testAboutPageLoads() throws Exception {
        WebDriver webDriver = createWebDriver();
        webDriver.get(getBaseUrl() + "/about");
        assertThat("Did not find correct aboutPage title",webDriver.getTitle(),is("Get Started with Blue Sky, Green Builds"));
    }



}
