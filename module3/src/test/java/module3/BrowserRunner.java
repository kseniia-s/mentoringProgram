package module3;

import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.FileSystemResultsWriter;
import io.qameta.allure.aspects.AttachmentsAspects;
import io.qameta.allure.aspects.StepsAspects;
import io.qameta.allure.jbehave.AllureJbehave;
import module3.enums.BrowserType;
import module3.stepDefs.WikipediaPagesStepDef;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.parsers.PrefixNameStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.jbehave.core.reporters.Format.*;

public class BrowserRunner extends ConfigurableEmbedder {

    private BrowserType browserType;

    public BrowserRunner(BrowserType type) {
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
        FileSystemResultsWriter results = new FileSystemResultsWriter(Paths.get("target/allure-results"));
        final AllureLifecycle lifecycle = new AllureLifecycle(results);
        StepsAspects.setLifecycle(lifecycle);
        AttachmentsAspects.setLifecycle(lifecycle);

        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryParser(new PrefixNameStoryParser(String.valueOf(this.browserType)))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                .withReporters(new AllureJbehave(lifecycle))
//                        .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
                .withDefaultFormats()
                .withFormats(CONSOLE, TXT, HTML, XML)
                .withCrossReference(new CrossReference()))
        //.useParameterConverters(parameterConverters);
        ;
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
