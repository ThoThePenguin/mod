Java
package com.antimoddetect;

public class AntiModDetectFilter {
    private static boolean enabled = true;

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean value) {
        enabled = value;
    }

    // Phương thức kiểm tra và lọc các channel/gói tin gửi đến Server
    public static boolean shouldBlockChannel(String channelName) {
        if (!enabled) return false;
        // Chặn các channel phổ biến dùng để soi danh sách mod (VD: fabric:registry_sync, forge:channel, v.v.)
        return channelName.contains("fabric:registry") || channelName.contains("forge");
    }
}
