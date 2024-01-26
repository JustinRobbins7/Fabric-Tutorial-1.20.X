package net.zeal.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.zeal.tutorialmod.blocks.ModBlocks;
import net.zeal.tutorialmod.entity.ModEntities;
import net.zeal.tutorialmod.entity.client.ModModelLayers;
import net.zeal.tutorialmod.entity.client.PorcupineModel;
import net.zeal.tutorialmod.entity.client.PorcupineRenderer;

public class TutorialModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Allows transparency
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAHLIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DAHLIA, RenderLayer.getCutout());

        // Link porcupine to its Renderer file
        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
        // Register model layers for porcupine
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
    }
}
