Java
package com.antimoddetect;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AntiModDetectClient implements ClientModInitializer {
    public static final String MOD_ID = "antimoddetect";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("AntiModDetect đã được khởi chạy thành công trên Minecraft 1.21.1!");
    }
}
