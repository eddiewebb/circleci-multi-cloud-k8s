package com.edwardawebb.circleci.demo.it;

import org.junit.*;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * This is not a local test, but is intended to be paired with Rigor to execute remote tests. It will be ignored thorugh normal test lifecycle.
 *  To run explicitly, use ./mvnw -Dtest=HeadlessFlowTests test -Dtest-groups=rigor -DbaseURL="http://dark.blueskygreenbuilds.com"
 */
@RunWith(SpringJUnit4ClassRunner.class)
@IfProfileValue(name="test-groups", values={"rigor"})
public class HeadlessFlowTests {

    private String baseURL;

    private WebClient webClient;

    @Before
    public void setup() {
        baseURL = System.getProperty("baseURL","http://example.com");
        System.err.println("Using: " + baseURL);
        webClient = new WebClient();
    }

    @After
    public void close() {
        webClient.close();
    }

    @Test
    public void homePageHtmlUnit() throws Exception {
        HtmlPage currentPage = webClient.getPage(baseURL);
        Assert.assertEquals("Blue Sky, Green Builds", currentPage.getTitleText());
        HtmlAnchor link = (HtmlAnchor) currentPage.getElementById("car-btn-1");
        HtmlPage result = link.click();
        assertThat( result.getBody().getTextContent(), containsString("Start Today"));
    }
}
