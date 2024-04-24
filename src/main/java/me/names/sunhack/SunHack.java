package me.names.sunhack;

import net.fabricmc.api.ModInitializer;

public class SunHack implements ModInitializer {

    // Define mod metadata
    public static final String MOD_ID = "sunhack";
    public static final String MOD_NAME = "SunHack";
    public static final String MOD_VERSION = "1.0.0";
    public static final String CLIENT_NAME = "SunHack";
    public static final String AUTHOR = "2b2t_names";

    @Override
    public void onInitialize() {
        // Display mod information
        System.out.println("Mod Initialized");
        System.out.println("Mod ID: " + MOD_ID);
        System.out.println("Mod Name: " + MOD_NAME);
        System.out.println("Mod Version: " + MOD_VERSION);
        System.out.println("Client Name: " + CLIENT_NAME);
        System.out.println("Author: " + AUTHOR);
    }
}
