package module3.helpers;

import org.jbehave.core.model.Story;
import org.jbehave.core.parsers.RegexStoryParser;

public class PrefixNameStoryParser extends RegexStoryParser {

    private String storyPrefix;

    public PrefixNameStoryParser(String storyPrefix) {
        super();
        this.storyPrefix = storyPrefix;
    }

    @Override
    public Story parseStory(String storyAsText, String storyPath) {
        Story story = super.parseStory(storyAsText, storyPath);
        story.namedAs(storyPrefix + ": "+ story.getName());
        return story;
    }

}
