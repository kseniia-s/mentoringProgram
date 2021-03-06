package com.epam.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class GithubTestExecutionListener implements TestExecutionListener{
    private static final Logger logger = LoggerFactory.getLogger(GithubTestExecutionListener.class);

    public void beforeTestClass(TestContext testContext) throws Exception {
        logger.info("beforeTestClass : {}", testContext.getTestClass());
    };

    public void prepareTestInstance(TestContext testContext) throws Exception {
        logger.info("prepareTestInstance : {}", testContext.getTestClass());
    };

    public void beforeTestMethod(TestContext testContext) throws Exception {
        logger.info("beforeTestMethod : {}", testContext.getTestMethod());
    };

    public void afterTestMethod(TestContext testContext) throws Exception {
        logger.info("afterTestMethod : {}", testContext.getTestMethod());
    };

    public void afterTestClass(TestContext testContext) throws Exception {
        logger.info("afterTestClass : {}", testContext.getTestClass());
    }
}
