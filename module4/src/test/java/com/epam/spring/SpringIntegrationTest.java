package com.epam.spring;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(profiles = "chrome")
public class SpringIntegrationTest {
}
