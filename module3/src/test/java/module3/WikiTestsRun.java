package module3;

import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.FileSystemResultsWriter;
import io.qameta.allure.aspects.AttachmentsAspects;
import io.qameta.allure.aspects.StepsAspects;
import module3.enums.BrowserType;
import org.assertj.core.util.Lists;
import org.jbehave.core.embedder.Embedder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class WikiTestsRun {

    private List<BrowserType> browserList;

    @Test
    public void runTests() {
        String browsers = System.getProperty("browser", "chrome,firefox,ie");
        if (!browsers.isEmpty()) {
            browserList = parse(browsers);
        }

        for (BrowserType browserType : browserList) {
            try {
                BrowserRunner runner = new BrowserRunner(browserType);
                runner.run();
            } catch (Embedder.RunningStoriesFailed e) {
                // pass execution to next browser
            }
        }
    }

    private List<BrowserType> parse(String browsers) {
        return Arrays.stream(browsers.split(","))
                .map(s -> s.trim().toUpperCase())
                .map(BrowserType::valueOf)
                .collect(Collectors.toList());
    }
}