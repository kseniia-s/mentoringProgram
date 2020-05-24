package com.epam.spring;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@ActiveProfiles(profiles = "chrome")
@TestExecutionListeners(value = {
        GithubTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class
})
public class SpringIntegrationTest {
}
