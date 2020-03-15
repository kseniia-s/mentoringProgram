package module3;

import module3.enums.BrowserType;
import module3.stepDefs.WikipediaPagesStepDef;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrowserRunner extends ConfigurableEmbedder {

    private BrowserType browserType;

    BrowserRunner(BrowserType type) {
        browserType = type;
    }

    @Override
    public void run() {
        System.setProperty("browser", String.valueOf(this.browserType));
        Embedder embedder = configuredEmbedder();
        try {
            embedder.runStoriesAsPaths(storyPaths());
        } finally {
            embedder.generateCrossReference();
            embedder.generateSurefireReport();
        }
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<>();
        stepFileList.add(new WikipediaPagesStepDef());
        return new InstanceStepsFactory(configuration(), stepFileList);
    }

    private List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Collections.singletonList("**/*.story"),
                        Collections.singletonList(""));
    }
}
