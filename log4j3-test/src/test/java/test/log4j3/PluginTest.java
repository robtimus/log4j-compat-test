package test.log4j3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.log4j.plugin.AppenderFromJar;

class PluginTest {

    private static final Logger LOGGER = assertInstanceOf(Logger.class, LogManager.getLogger(PluginTest.class));

    private static AppenderFromJar testAppender;

    @BeforeAll
    static void initAppender() {
        assertAll(
                () -> assertInstanceOf(LocalAppender.class, LOGGER.getAppenders().get("local")),
                () -> assertInstanceOf(LegacyAppender.class, LOGGER.getAppenders().get("legacy")),
                () -> testAppender = assertInstanceOf(AppenderFromJar.class, LOGGER.getAppenders().get("from-jar"))
        );
    }

    @BeforeEach
    @AfterEach
    void clearEvents() {
        testAppender.clearEvents();
    }

    @Test
    void testAppender() {
        LOGGER.warn("warn message");

        List<LogEvent> events = testAppender.getEvents();
        assertEquals(1, events.size());

        LogEvent event = events.get(0);
        assertEquals(Level.WARN, event.getLevel());
        assertEquals("warn message", event.getMessage().getFormat());
        assertEquals("warn message", event.getMessage().getFormattedMessage());
    }
}
