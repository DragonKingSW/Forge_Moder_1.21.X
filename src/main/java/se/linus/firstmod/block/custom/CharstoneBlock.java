package se.linus.firstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import se.linus.firstmod.item.ModItems;
import se.linus.firstmod.util.ModTags;

import java.util.List;

public class CharstoneBlock extends Block {
    public CharstoneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof LivingEntity) {
            pEntity.hurt(pLevel.damageSources().hotFloor(),1f);
        } else if (pEntity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == ModItems.FIREBARK.get()) {
                ItemStack firebarks = itemEntity.getItem();
                int count = firebarks.getCount();

                if(count >= 5) {
                    int charcoalCount = count / 5;
                    int remaningFirebark = count % 5;

                    itemEntity.setItem(new ItemStack(Items.CHARCOAL, charcoalCount));

                    if(remaningFirebark > 0) {
                        ItemStack leftoverStack = new ItemStack(ModItems.FIREBARK.get(), remaningFirebark);
                        ItemEntity leftoverEntity = new ItemEntity(pLevel,pPos.getX() + 0.0, pPos.getY() + 1.0, pPos.getZ() + 0.5, leftoverStack);
                        pLevel.addFreshEntity(leftoverEntity);
                    }
                }
            } else if (isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(ModItems.CHARRED_FLESH.get(), itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.CHARRABLE_FLESH_ITEMS);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.firstmod.charstone.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
