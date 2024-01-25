package net.zeal.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.zeal.tutorialmod.item.ModItems;

public class TomatoCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    // Need to make this property method to ensure multiple versions of the same crop can have different ages
    public static final IntProperty AGE = IntProperty.of("age", 0, 5);
    public TomatoCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.TOMATO_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
}
