package se.linus.firstmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import se.linus.firstmod.util.ModTags;

public class ModToolTiers {
    public static final Tier SACRITE = new ForgeTier(1400,4,5f,20,
            ModTags.Blocks.NEEDS_SACRITE_TOOL, () -> Ingredient.of(ModItems.SACRITE.get()),
            ModTags.Blocks.INCORRECT_FOR_SACRITE_TOOL);
}
