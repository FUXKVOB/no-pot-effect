package com.reqwai.nopoteffect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoPotEffect.MOD_ID);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private boolean disableFov = true;
    private boolean disableNausea = true;
    private boolean disableHurtTilt = true;

    private static ModConfig INSTANCE = new ModConfig();

    public static boolean isFovDisabled() { return INSTANCE.disableFov; }
    public static boolean isNauseaDisabled() { return INSTANCE.disableNausea; }
    public static boolean isHurtTiltDisabled() { return INSTANCE.disableHurtTilt; }

    public static void load(Path gameDir) {
        Path configPath = gameDir.resolve("config").resolve("no-pot-effect.json");
        if (Files.exists(configPath)) {
            try {
                String json = Files.readString(configPath);
                INSTANCE = GSON.fromJson(json, ModConfig.class);
                if (INSTANCE == null) INSTANCE = new ModConfig();
            } catch (Exception e) {
                LOGGER.error("Failed to load config, using defaults", e);
                INSTANCE = new ModConfig();
            }
        } else {
            INSTANCE = new ModConfig();
        }
        save(configPath);
    }

    private static void save(Path configPath) {
        try {
            Files.createDirectories(configPath.getParent());
            Files.writeString(configPath, GSON.toJson(INSTANCE));
        } catch (IOException e) {
            LOGGER.error("Failed to save config", e);
        }
    }
}
