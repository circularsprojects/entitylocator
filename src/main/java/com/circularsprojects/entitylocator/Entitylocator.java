package com.circularsprojects.entitylocator;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entitylocator implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("entitylocator");
    @Override
    public void onInitialize() {
        LOGGER.info("entitylocator intialized.");
    }
}
