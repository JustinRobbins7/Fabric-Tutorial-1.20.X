package net.zeal.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zeal.tutorialmod.TutorialMod;
import net.zeal.tutorialmod.blocks.ModBlocks;

public class ModItemGroups {
    // Declares modded item groups. registeritemGroups must be called to load/run this method. Not sure how/why
    public static final ItemGroup TUTORIAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "tutorial"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.tutorial"))
                    .icon(() -> new ItemStack(ModItems.RUBY))
                    .entries((displayContent, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModBlocks.SOUND_BLOCK);
                        entries.add(ModItems.TOMATO);
                    })
                    .build());
    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering modded Item Groups for " + TutorialMod.MOD_ID);
    }
}
