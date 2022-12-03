package test.log4j.plugin;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

@Plugin(name = "FromJar", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
public class AppenderFromJar extends AbstractAppender {

    private final List<LogEvent> events = new ArrayList<>();

    public AppenderFromJar(String name) {
        super(name, null, PatternLayout.createDefaultLayout(), false, Property.EMPTY_ARRAY);
    }

    @PluginFactory
    public static AppenderFromJar createAppender(@PluginAttribute("name") String name) {
        return new AppenderFromJar(name);
    }

    @Override
    public void append(LogEvent event) {
        if (!isFiltered(event)) {
            events.add(event.toImmutable());
        }
    }

    public List<LogEvent> getEvents() {
        return events;
    }

    public void clearEvents() {
        events.clear();
    }
}
