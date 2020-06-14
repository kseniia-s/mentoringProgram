package module3;

import module3.enums.BrowserType;
import org.assertj.core.util.Lists;
import org.jbehave.core.embedder.Embedder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class WikiTestsRun {

    private List<BrowserType> browserList = Lists.list(BrowserType.CHROME, BrowserType.FIREFOX, BrowserType.IE);

    @Test
    public void runTests() {

        for (BrowserType browserType : browserList) {
            try {
                BrowserRunner runner = new BrowserRunner(browserType);
                runner.run();
            } catch (Embedder.RunningStoriesFailed e) {
                // pass execution to next browser
            }
        }
    }
}