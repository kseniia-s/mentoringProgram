package com.epam.spring;

import com.epam.spring.configurations.ApplicationConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
//@ContextConfiguration(classes = ApplicationConfig.class)
//@ActiveProfiles(profiles = "chrome")
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/epam/spring"
)

public class CucumberRunner{
}
