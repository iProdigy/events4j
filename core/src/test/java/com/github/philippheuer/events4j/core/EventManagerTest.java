package com.github.philippheuer.events4j.core;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
public class EventManagerTest {

    private static EventManager eventManager;

    @BeforeAll
    public static void initializeEventManager() {
        eventManager = new EventManager();
        eventManager.autoDiscovery();
    }

    @Test
    public void testAutoDiscovery() {
        Assertions.assertEquals(2, eventManager.getEventHandlers().size(), "should have discovered 2 handlers");
    }

    @Test
    public void testGetEventHandlerByClass() {
        SimpleEventHandler eventHandler = eventManager.getEventHandler(SimpleEventHandler.class);
        Assertions.assertNotNull(eventHandler, "should fine a eventHandler for class SimpleEventHandler");
    }

    @Test
    public void testHasEventHandlerByClass() {
        Assertions.assertTrue(eventManager.hasEventHandler(SimpleEventHandler.class), "should fine a eventHandler for class SimpleEventHandler");
    }

    @AfterAll
    public static void shutdownEventManager() {
        eventManager.close();
    }

}
