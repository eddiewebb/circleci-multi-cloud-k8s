package com.edwardawebb.circleci.demo;

import com.edwardawebb.circleci.demo.controllers.RestController;
import org.junit.Test;

import static org.apache.commons.lang3.Validate.notNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;

public class BuildInfoControllerTests {

    private final static String HASH="111abcdef222ccc";


    BuildInfo buildInfo = new BuildInfo();

    @Test
    public void testThatBuildInfoReturnedMatchesPassedReference() throws Exception {

        notNull(buildInfo);
        buildInfo.setCommitHash(HASH);
        RestController controller = new RestController(buildInfo);
        BuildInfo returned = controller.greeting();

        assertThat("Build Info Is Different",returned,is(buildInfo));
        assertThat("Provided values null",returned,notNullValue());
        assertThat("Data Mismatch",returned.getCommitHash(),is(HASH));
        //fail("Demo failing test is failing");
    }



}
