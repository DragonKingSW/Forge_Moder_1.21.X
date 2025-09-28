package se.linus.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import se.linus.firstmod.FirstMod;
import se.linus.firstmod.block.ModBlocks;
import se.linus.firstmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Blocks.BURNABLE_BLOCKS)
                .add(Blocks.ACACIA_LOG)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.CHERRY_LOG)
                .add(Blocks.DARK_OAK_LOG)
                .add(Blocks.JUNGLE_LOG)
                .add(Blocks.MANGROVE_LOG)
                .add(Blocks.OAK_LOG)
                .add(Blocks.SPRUCE_LOG);

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SACRITE_BLOCK.get())
                .add(ModBlocks.SACRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SACRITE_ORE.get())
                .add(ModBlocks.INFLAMITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_INFLAMITE_ORE.get())
                .add(ModBlocks.CHARSTONE.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.FIREBARK_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SACRITE_BLOCK.get())
                .add(ModBlocks.SACRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SACRITE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.INFLAMITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_INFLAMITE_ORE.get())
                .add(ModBlocks.CHARSTONE.get());

        tag(BlockTags.FENCES).add(ModBlocks.SACRITE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.SACRITE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.SACRITE_WALL.get());
    }
}
