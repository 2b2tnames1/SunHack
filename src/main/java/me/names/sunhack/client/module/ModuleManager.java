package me.names.sunhack.client.module;

import me.names.sunhack.client.module.modules.combat.*;
import me.names.sunhack.client.module.modules.exploits.*;
import me.names.sunhack.client.module.modules.gui.ClickGuiModule;
import me.names.sunhack.client.module.modules.gui.ColorMain;
import me.names.sunhack.client.module.modules.gui.HUDEditor;
import me.names.sunhack.client.module.modules.hud.*;
import me.names.sunhack.client.module.modules.misc.*;
import me.names.sunhack.client.module.modules.movement.*;
import me.names.sunhack.client.module.modules.render.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;

public class ModuleManager {
    private static final LinkedHashMap<Class<? extends Module>, Module> modulesClassMap = new LinkedHashMap<>();
    private static final LinkedHashMap<String, Module> modulesNameMap = new LinkedHashMap<>();

    public static void init() {
        //Combat



        addMod(new AutoCrystal());




        addMod(new HoleFill());
        addMod(new KillAura());
        addMod(new OffHand());


        addMod(new Surround());
        //Exploits





        //Movement

        //addMod(new Blink());
        //addMod(new HoleTP());
        //addMod(new PlayerTweaks());

        addMod(new Speed());
        addMod(new Sprint());
        //addMod(new Step());
        //Misc
        //addMod(new Announcer());
        //addMod(new AutoGear());
        //addMod(new AutoGG());
        //addMod(new AutoReply());
        addMod(new AutoRespawn());
        //addMod(new AutoTool());

        addMod(new DiscordRPCModule());
        //addMod(new FastPlace());
        addMod(new FakePlayer());
        //addMod(new HotbarRefill());
        //addMod(new MCF());
        //addMod(new MCP());
        //addMod(new MultiTask());
        //addMod(new NoEntityTrace());


        //addMod(new PvPInfo());
        //addMod(new SortInventory());
        //addMod(new XCarry());
        //Render
        //addMod(new BlockHighlight());
        addMod(new BreakESP());
        //addMod(new Bucked());
        addMod(new CapesModule());
        //addMod(new Chams());
        //addMod(new CityESP());
        addMod(new ESP());
        addMod(new Freecam());
        addMod(new Fullbright());
        //addMod(new HitSpheres());
        addMod(new HoleESP());
        addMod(new LogoutSpots());
        addMod(new Nametags());
        addMod(new NoRender());
        //addMod(new RenderTweaks());
        //addMod(new ShulkerViewer());
        //addMod(new SkyColor());
        addMod(new Tracers());
        addMod(new ViewModel());
        //addMod(new VoidESP());
        //HUD
        addMod(new ArmorHUD());
        addMod(new ArrayListModule());
        //addMod(new CombatInfo());
        addMod(new Coordinates());
        addMod(new InventoryViewer());
        //addMod(new Notifications());
        //addMod(new PotionEffects());
        //addMod(new Radar());
        //addMod(new Speedometer());
        //addMod(new TabGUIModule());
        //addMod(new TargetHUD());
        //addMod(new TargetInfo());
        //addMod(new TextRadar());
        addMod(new Watermark());

        //GUI
        addMod(new ClickGuiModule());
        //addMod(new ColorMain());
        addMod(new HUDEditor());
    }

    public static void addMod(Module module) {
        modulesClassMap.put(module.getClass(), module);
        modulesNameMap.put(module.getName().toLowerCase(Locale.ROOT), module);
    }

    public static Collection<Module> getModules() {
        return modulesClassMap.values();
    }

    public static ArrayList<Module> getModulesInCategory(Category category) {
        ArrayList<Module> list = new ArrayList<>();

        for (Module module : modulesClassMap.values()) {
            if (!module.getCategory().equals(category)) continue;
            list.add(module);
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Module> T getModule(Class<T> clazz) {
        return (T) modulesClassMap.get(clazz);
    }

    public static Module getModule(String name) {
        if (name == null) return null;
        return modulesNameMap.get(name.toLowerCase(Locale.ROOT));
    }

    public static boolean isModuleEnabled(Class<? extends Module> clazz) {
        Module module = getModule(clazz);
        return module != null && module.isEnabled();
    }

    public static boolean isModuleEnabled(String name) {
        Module module = getModule(name);
        return module != null && module.isEnabled();
    }
}