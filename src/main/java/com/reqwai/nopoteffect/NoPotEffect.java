package com.reqwai.nopoteffect;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoPotEffect implements ModInitializer {
	public static final String MOD_ID = "no-pot-effect";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfig.load(FabricLoader.getInstance().getConfigDir());
		LOGGER.info("No Pot Effect initialized");
	}
}
