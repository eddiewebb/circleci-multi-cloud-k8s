package com.edwardawebb.circleci.demo;

import com.edwardawebb.circleci.demo.controllers.HomeController;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class HomeControllerTests {

    @Test
    public void testCorrectRouteForAbout() throws Exception {
        HomeController controller = new HomeController();
        String route = controller.about(null);
        assertThat("Home page route did not match",route,is("about"));
        
    }



}
