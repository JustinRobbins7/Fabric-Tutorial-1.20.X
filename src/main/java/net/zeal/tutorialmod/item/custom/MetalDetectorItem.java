package net.zeal.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // Check if we are on server
        if(!context.getWorld().isClient()) {
            // When right-clicked, check for iron or diamond ore 64 blocks beneath the player.
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            // Check blocks up to 64 blocks down from player
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                // If valuable block is found, inform the player and break from the loop
                if (isValuableBlock(state) && player != null) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            // If no block is found, inform player
            if(!foundBlock && player != null) {
                player.sendMessage(Text.literal("No Valuables Found."));
            }
        }

        // Damage item after use
        if (context.getPlayer() != null) {
            context.getStack().damage(1, context.getPlayer(),
                    playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        }

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        // Sends the player the coordinates of the valuable block that was found
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + " , " + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        // Return a boolean indicating if the block being evaluated is iron or diamond ore
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        // References an entry in the lang files to provide a translated message based on user language settings. Preferable.
        tooltip.add(Text.translatable("tooltip.tutorialmod.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
