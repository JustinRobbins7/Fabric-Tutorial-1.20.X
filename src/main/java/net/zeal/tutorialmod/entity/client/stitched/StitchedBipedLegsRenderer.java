package net.zeal.tutorialmod.entity.client.stitched;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.zeal.tutorialmod.TutorialMod;
import net.zeal.tutorialmod.entity.custom.StitchedBipedLegsEntity;

public class StitchedBipedLegsRenderer extends EntityRenderer<StitchedBipedLegsEntity> {
    private static final Identifier TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/entity/stitched_legs.png");
    public StitchedBipedLegsRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(StitchedBipedLegsEntity entity) {
        return TEXTURE;
    }
}
