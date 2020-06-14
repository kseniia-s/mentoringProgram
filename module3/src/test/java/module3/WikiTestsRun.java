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
import java.util.List;

@RunWith(JUnit4.class)
public class WikiTestsRun {

    private List<BrowserType> browserList = Lists.list(BrowserType.CHROME, BrowserType.FIREFOX, BrowserType.IE);

    @Test
    public void runTests() {

        FileSystemResultsWriter results = new FileSystemResultsWriter(Paths.get("target/allure-results"));
        final AllureLifecycle lifecycle = new AllureLifecycle(results);
        StepsAspects.setLifecycle(lifecycle);
        AttachmentsAspects.setLifecycle(lifecycle);

        for (BrowserType browserType : browserList) {
            try {
                BrowserRunner runner = new BrowserRunner(browserType, lifecycle);
                runner.run();
            } catch (Embedder.RunningStoriesFailed e) {
                // pass execution to next browser
            }
        }
    }
}