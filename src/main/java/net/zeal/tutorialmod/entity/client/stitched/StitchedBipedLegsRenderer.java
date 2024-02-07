package net.zeal.tutorialmod.entity.client.stitched;

import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.zeal.tutorialmod.TutorialMod;
import net.zeal.tutorialmod.entity.client.ModModelLayers;
import net.zeal.tutorialmod.entity.custom.StitchedBipedLegsEntity;

public class StitchedBipedLegsRenderer extends EntityRenderer<StitchedBipedLegsEntity> {
    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/stitched_legs.png");
    private final StitchedBipedLegsModel model;
    public StitchedBipedLegsRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new StitchedBipedLegsModel(context.getPart(ModModelLayers.STITCHED_BIPED_LEGS));
    }

    @Override
    public Identifier getTexture(StitchedBipedLegsEntity entity) {
        return TEXTURE;
    }

    // Doesn't seem to be necessary? Handled in the model?
//    public static TexturedModelData getTexturedModelData() {
//        return StitchedBipedLegsModel.getTexturedModelData();
//    }

    @Override
    public void render(StitchedBipedLegsEntity stitchedBipedLegsEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        // This works
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(stitchedBipedLegsEntity)));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        super.render(stitchedBipedLegsEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
