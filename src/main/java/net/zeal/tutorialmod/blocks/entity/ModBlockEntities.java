package net.zeal.tutorialmod.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zeal.tutorialmod.TutorialMod;
import net.zeal.tutorialmod.blocks.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<GemPolishingStationBlockEntity> GEM_POLISHING_STATION_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(TutorialMod.MOD_ID, "gem_polishing_be"),
                    FabricBlockEntityTypeBuilder.create(GemPolishingStationBlockEntity::new,
                            ModBlocks.GEM_POLISHING_STATION).build());

    public static void registerBlockEntities() {
        TutorialMod.LOGGER.info("Registering Block Entities for " + TutorialMod.MOD_ID);
    }
}
