package me.names.sunhack.client;

import com.google.common.eventbus.EventBus;
import me.names.sunhack.SunHack;
import me.names.sunhack.api.config.LoadConfig;
import me.names.sunhack.api.setting.SettingsManager;
import me.names.sunhack.api.util.font.CFontRenderer;
import me.names.sunhack.api.util.misc.VersionChecker;
import me.names.sunhack.api.util.player.social.SocialManager;
import me.names.sunhack.api.util.render.CapeUtil;
import me.names.sunhack.client.clickgui.SunHackGUI;
import me.names.sunhack.client.clickgui.SunHackGUI;
import me.names.sunhack.client.command.CommandManager;
import me.names.sunhack.client.manager.ManagerLoader;
import me.names.sunhack.client.module.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.awt.*;

@Mod(modid = SunHack.MODID, name = SunHack.MODNAME, version = SunHack.MODVER)
public class SunHack {

    public static final String MODNAME = "SunHack";
    public static final String MODID = "sunhack";
    public static final String MODVER = "1.0.0";
    /**
     * Official release starts with a "v", dev versions start with a "d" to bypass version check
     */

    public static final Logger LOGGER = LogManager.getLogger(MODNAME);
    public static final EventBus EVENT_BUS = new EventManager();

    @Mod.Instance
    public static SunHack INSTANCE;

    public SunHack() {
        INSTANCE = this;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle(MODNAME + " " + MODVER);

        LOGGER.info("Starting up " + MODNAME + " " + MODVER + "!");
        startClient();
        LOGGER.info("Finished initialization for " + MODNAME + " " + MODVER + "!");
    }

    public CFontRenderer cFontRenderer;
    public SunHackGUI sunHackGUI;

    private void startClient() {
        VersionChecker.init();
        LOGGER.info("Version checked!");

        cFontRenderer = new CFontRenderer(new Font("Verdana", Font.PLAIN, 18), true, true);
        LOGGER.info("Custom font initialized!");

        SettingsManager.init();
        LOGGER.info("Settings initialized!");

        SocialManager.init();
        LOGGER.info("Friends/Enemies initialized!");

        ModuleManager.init();
        LOGGER.info("Modules initialized!");

        CommandManager.init();
        LOGGER.info("Commands initialized!");

        ManagerLoader.init();
        LOGGER.info("Managers initialized!");

        sunHackGUI = new SunHackGUI();
        LOGGER.info("GUI initialized!");

        CapeUtil.init();
        LOGGER.info("Capes initialized!");

        LoadConfig.init();
        LOGGER.info("Config initialized!");
    }
}