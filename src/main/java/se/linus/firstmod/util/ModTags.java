package se.linus.firstmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import se.linus.firstmod.FirstMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SACRITE_TOOL = createTag("needs_sacrite_tool");
        public static final TagKey<Block> INCORRECT_FOR_SACRITE_TOOL = createTag("incorrect_for_sacrite_tool");
        public static final TagKey<Block> BURNABLE_BLOCKS = createTag("burnable_blocks");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CHARRABLE_FLESH_ITEMS = createTag("charrable_flesh_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }
}
