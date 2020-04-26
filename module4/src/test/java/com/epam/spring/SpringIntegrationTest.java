package com.epam.spring;

import com.epam.spring.configurations.ApplicationConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles(profiles = "chrome")
public class SpringIntegrationTest {

}
