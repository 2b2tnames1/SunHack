package me.names.sunhack.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class SunHackGUI extends Screen {

    public SunHackGUI() {
        super(Text.of("SunHack GUI"));
    }

    @Override
    protected void init() {
        super.init();
        // Add initialization logic here if needed
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        drawStringWithShadow(matrices, textRenderer, client.getWindow().getScaledWidth() / 2 - textRenderer.getWidth(new TranslatableText("gui.title")), client.getWindow().getScaledHeight() / 2 - 4, Formatting.WHITE + "SunHack GUI");
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Add mouse click logic here if needed
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        // Add key press logic here if needed
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
