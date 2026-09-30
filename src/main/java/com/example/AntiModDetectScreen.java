Java
package com.antimoddetect;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class AntiModDetectScreen extends Screen {
    private final Screen parent;

    public AntiModDetectScreen(Screen parent) {
        super(Text.literal("AntiModDetect - Cài đặt"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        // Nút Bật/Tắt lọc mod
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Trạng thái: " + (AntiModDetectFilter.isEnabled() ? "ĐANG BẬT" : "TẮT")),
                button -> {
                    AntiModDetectFilter.setEnabled(!AntiModDetectFilter.isEnabled());
                    button.setMessage(Text.literal("Trạng thái: " + (AntiModDetectFilter.isEnabled() ? "ĐANG BẬT" : "TẮT")));
                })
                .dimensions(this.width / 2 - 100, this.height / 2 - 20, 200, 20)
                .build());

        // Nút Quay lại
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Quay lại"),
                button -> this.client.setScreen(this.parent))
                .dimensions(this.width / 2 - 100, this.height / 2 + 20, 200, 20)
                .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 40, 0xFFFFFF);
    }
}
