package com.antimoddetect.mixin;

import com.antimoddetect.AntiModDetectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {

    protected OptionsScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void addAntiModDetectButton(CallbackInfo ci) {
        // Thêm nút mở menu AntiModDetect vào giao diện Cài đặt (Options Screen)
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("AntiModDetect"),
                button -> this.client.setScreen(new AntiModDetectScreen(this)))
                .dimensions(10, 10, 100, 20)
                .build());
    }
}
