Java
package com.antimoddetect;

public class AntiModDetectMonitor {
    private static int blockedPacketsCount = 0;

    public static void incrementBlockedCount() {
        blockedPacketsCount++;
        AntiModDetectClient.LOGGER.info("Đã chặn gói tin kiểm tra mod (#{})", blockedPacketsCount);
    }

    public static int getBlockedPacketsCount() {
        return blockedPacketsCount;
    }
}
