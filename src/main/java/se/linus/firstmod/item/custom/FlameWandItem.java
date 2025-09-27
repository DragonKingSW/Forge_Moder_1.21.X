package se.linus.firstmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import se.linus.firstmod.block.ModBlocks;

import java.util.Map;


public class FlameWandItem extends Item {
    private static final Map<Block, Block> FLAME_MAP =
            Map.of(
                    Blocks.OAK_LOG, ModBlocks.FIREBARK_BLOCK.get(),
                    Blocks.ACACIA_LOG, ModBlocks.FIREBARK_BLOCK.get(),
                    Blocks.BIRCH_LOG, ModBlocks.FIREBARK_BLOCK.get(),
                    Blocks.CHERRY_LOG, ModBlocks.FIREBARK_BLOCK.get(),
                    Blocks.DARK_OAK_LOG, ModBlocks.FIREBARK_BLOCK.get(),
                    Blocks.JUNGLE_LOG, ModBlocks.FIREBARK_BLOCK.get(),
                    Blocks.MANGROVE_LOG, ModBlocks.FIREBARK_BLOCK.get(),
                    Blocks.SPRUCE_LOG, ModBlocks.FIREBARK_BLOCK.get()
            );

    public FlameWandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(FLAME_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(pContext.getClickedPos(), FLAME_MAP.get(clickedBlock).defaultBlockState());
                
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
