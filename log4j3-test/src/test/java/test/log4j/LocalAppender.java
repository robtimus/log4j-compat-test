package test.log4j;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.plugins.Configurable;
import org.apache.logging.log4j.plugins.Plugin;
import org.apache.logging.log4j.plugins.PluginAttribute;
import org.apache.logging.log4j.plugins.PluginFactory;

@Configurable(elementType = Appender.ELEMENT_TYPE)
@Plugin("Local")
public class LocalAppender extends AbstractAppender {

    public LocalAppender(String name) {
        super(name, null, PatternLayout.createDefaultLayout(), false, Property.EMPTY_ARRAY);
    }

    @PluginFactory
    public static LocalAppender createAppender(@PluginAttribute("name") String name) {
        return new LocalAppender(name);
    }

    @Override
    public void append(LogEvent event) {
        // ignore
    }
}
