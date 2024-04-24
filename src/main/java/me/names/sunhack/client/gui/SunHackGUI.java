package me.names.sunhack.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class SunHackGUI {

    private boolean isGuiOpen = false;

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (isGuiOpen) {
                renderGui();
            }
        }
    }

    private void renderGui() {
        // Get Minecraft instance
        Minecraft mc = Minecraft.getMinecraft();

        // Get the font renderer
        FontRenderer fontRenderer = mc.fontRendererObj;

        // Get the screen resolution
        ScaledResolution scaledResolution = new ScaledResolution(mc);

        // Draw a simple GUI background
        Gui.drawRect(50, 50, scaledResolution.getScaledWidth() - 50, scaledResolution.getScaledHeight() - 50, 0x80000000);

        // Draw some text on the GUI
        fontRenderer.drawString("SunHack GUI", (scaledResolution.getScaledWidth() / 2) - (fontRenderer.getStringWidth("SunHack GUI") / 2), 60, 0xFFFFFF);
    }

    @SubscribeEvent
    public void onKeyInput(net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent event) {
        // Check if the right shift key is pressed
        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            // Toggle GUI open/close
            isGuiOpen = !isGuiOpen;
        }
    }
}
