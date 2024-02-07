package net.zeal.tutorialmod.entity.client.stitched;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.zeal.tutorialmod.TutorialMod;
import net.zeal.tutorialmod.entity.client.ModModelLayers;
import net.zeal.tutorialmod.entity.client.PorcupineModel;
import net.zeal.tutorialmod.entity.custom.StitchedBipedBodyEntity;

public class StitchedBipedBodyRenderer extends EntityRenderer<StitchedBipedBodyEntity> {
    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/stitched_body.png");
    public StitchedBipedBodyRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(StitchedBipedBodyEntity entity) {
        return TEXTURE;
    }
}
