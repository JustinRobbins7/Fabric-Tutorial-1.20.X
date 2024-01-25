package net.zeal.tutorialmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.zeal.tutorialmod.item.ModItems;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        // Can add numerous trades for the same items or
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.TOMATO_SEEDS, 7),
                    6, 5, 0.05f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.CORN_SEEDS, 7),
                    6, 5, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.GOLD_INGOT, 11),
                    new ItemStack(ModItems.TOMATO, 12),
                    6, 5, 0.05f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.DIAMOND, 2),
                    new ItemStack(ModItems.CORN, 7),
                    6, 5, 0.05f
            ));
        });

        // Can also set up trades for enchanted books
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.RUBY, 11),
                    EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.PIERCING, 2)),
                    6, 5, 0.05f
            ));
        });

        // For the wandering trader, level 1 is common items, Level 2 is rare items
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.RUBY, 11),
                    EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.POWER, 2)),
                    6, 5, 0.05f
            ));
        });
    }
}
