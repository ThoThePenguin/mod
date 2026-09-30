package com.antimoddetect.mixin;

import com.antimoddetect.AntiModDetectFilter;
import com.antimoddetect.AntiModDetectMonitor;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {

    @Inject(method = "send(Lnet/minecraft/network/packet/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void onSendPacket(Packet<?> packet, CallbackInfo ci) {
        // Can thiệp vào gói tin gửi tới máy chủ để loại bỏ thông tin mod khi kết nối
        String packetName = packet.getClass().getName();
        if (AntiModDetectFilter.shouldBlockChannel(packetName)) {
            AntiModDetectMonitor.incrementBlockedCount();
            ci.cancel(); // Hủy gói tin thông báo danh sách mod
        }
    }
}
