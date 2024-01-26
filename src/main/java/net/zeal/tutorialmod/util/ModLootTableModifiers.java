package net.zeal.tutorialmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.zeal.tutorialmod.item.ModItems;

import java.lang.constant.ConstantDesc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {

    public static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft", "chests/jungle_temple");
    public static final Identifier CREEPER_ID =
            new Identifier("minecraft", "entities/creeper");
    public static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Modify jungle temple loot pool
            if (JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.METAL_DETECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            // Modify Creeper loot pool
            if(CREEPER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.COAL_BRIQUETTE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

        // Might be broken, unless suspicious sand block drops only work in pyramids
        // Broken by 1.20.2 update
//        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
//            if (SUSPICIOUS_SAND_ID.equals(id)) {
//                // Get original loot pool
//                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
//                // Add more entries
//                entries.add(ItemEntry.builder(ModItems.METAL_DETECTOR).build());
//                entries.add(ItemEntry.builder(ModItems.RUBY).build());
//
//                LootPool.Builder pool = LootPool.builder().with(entries);
//                return LootTable.builder().pool(pool).build();
//            }
//
//            return null;
//        });
    }
}
