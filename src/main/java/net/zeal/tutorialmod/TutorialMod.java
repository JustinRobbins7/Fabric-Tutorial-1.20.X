package net.zeal.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.zeal.tutorialmod.blocks.ModBlocks;
import net.zeal.tutorialmod.item.ModItemGroups;
import net.zeal.tutorialmod.item.ModItems;
import net.zeal.tutorialmod.util.ModCustomTrades;
import net.zeal.tutorialmod.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("tutorialmod");
	public static final String MOD_ID = "tutorialmod";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		// Adds fuel to registry
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);

		ModLootTableModifiers.modifyLootTables();

		ModCustomTrades.registerCustomTrades();
	}
}