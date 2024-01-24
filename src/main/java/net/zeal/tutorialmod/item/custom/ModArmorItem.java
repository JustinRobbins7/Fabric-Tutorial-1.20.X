package net.zeal.tutorialmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.zeal.tutorialmod.item.ModArmorMaterials;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    // Create a map that maps armor materials to status effects
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(
                            ModArmorMaterials.RUBY,
                            new StatusEffectInstance(StatusEffects.HASTE, 400, 1, false, false, true)
                    ).build());

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // If server
        if(!world.isClient()) {
            // If entity with item in inventory is a player and has a full suit of armor on
            if(entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                // See if they should get armor effect
                evaluateArmorEffects(player);
            }
        }

        // super tick function
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        // For each material to status effect map
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            // If player has correct armor material on
            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                // Add mapped status effect
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        // Get items in specified armor slot
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        // ensure player is wearing some piece of armor
        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        // Make sure armor worn is actually an ArmorItem
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        // Get armor items the player is wearing
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        // Check that the worn materials are correct
        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        // Check if player has the mapped status effect
        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            // Apply status effect by passing in the mapped status instance as a new status effect instance
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
    }
}
