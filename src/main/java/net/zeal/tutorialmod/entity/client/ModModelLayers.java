package net.zeal.tutorialmod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.zeal.tutorialmod.TutorialMod;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE = new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "porcupine"), "main");

    public static final EntityModelLayer STITCHED_BIPED_BODY = new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "stitched_biped_body"), "main");
    public static final EntityModelLayer STITCHED_BIPED_LEGS = new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "stitched_biped_legs"), "main");
}
