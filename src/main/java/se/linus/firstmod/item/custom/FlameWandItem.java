package se.linus.firstmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import se.linus.firstmod.block.ModBlocks;
import se.linus.firstmod.component.ModDataComponentTypes;
import se.linus.firstmod.util.ModTags;

import java.util.List;
import java.util.Map;


public class FlameWandItem extends Item {

    public FlameWandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(isValidBlock(clickedBlock.defaultBlockState())) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(pContext.getClickedPos(), ModBlocks.FIREBARK_BLOCK.get().defaultBlockState());
                
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS);

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
            }
        }

        return InteractionResult.SUCCESS;
    }

    private boolean isValidBlock(BlockState block) {
        return block.is(ModTags.Blocks.BURNABLE_BLOCKS);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.firstmod.flame_wand.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.firstmod.flame_wand"));
        }

        if(pStack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            pTooltipComponents.add(Component.literal("§cLast Block changed at: " + pStack.get(ModDataComponentTypes.COORDINATES.get()) + "§r"));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
