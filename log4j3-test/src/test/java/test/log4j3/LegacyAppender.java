package test.log4j3;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.plugins.Configurable;
import org.apache.logging.log4j.plugins.Plugin;

@Plugin("Legacy")
@Configurable(elementType = Appender.ELEMENT_TYPE)
public class LegacyAppender extends AbstractAppender {

    public LegacyAppender(String name) {
        super(name, null, PatternLayout.createDefaultLayout(), false, Property.EMPTY_ARRAY);
    }

    @PluginFactory
    public static LegacyAppender createAppender(@PluginAttribute("name") String name) {
        return new LegacyAppender(name);
    }

    @Override
    public void append(LogEvent event) {
        // ignore
    }
}
