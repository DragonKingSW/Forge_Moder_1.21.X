package se.linus.firstmod.datagen;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import se.linus.firstmod.FirstMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import se.linus.firstmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SACRITE_BLOCK);
        blockWithItem(ModBlocks.SACRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SACRITE_ORE);

        blockWithItem(ModBlocks.INFLAMITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_INFLAMITE_ORE);

        blockWithItem(ModBlocks.CHARSTONE);

        blockWithItem(ModBlocks.FIREBARK_BLOCK);


        stairsBlock(ModBlocks.SACRITE_STAIRS.get(), blockTexture(ModBlocks.SACRITE_BLOCK.get()));
        slabBlock(ModBlocks.SACRITE_SLAB.get(), blockTexture(ModBlocks.SACRITE_BLOCK.get()), blockTexture(ModBlocks.SACRITE_BLOCK.get()));

        buttonBlock(ModBlocks.SACRITE_BUTTON.get(), blockTexture(ModBlocks.SACRITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.SACRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SACRITE_BLOCK.get()));

        fenceBlock(ModBlocks.SACRITE_FENCE.get(), blockTexture(ModBlocks.SACRITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.SACRITE_FENCE_GATE.get(), blockTexture(ModBlocks.SACRITE_BLOCK.get()));
        wallBlock(ModBlocks.SACRITE_WALL.get(), blockTexture(ModBlocks.SACRITE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.SACRITE_DOOR.get(), modLoc("block/sacrite_door_bottom"), modLoc("block/sacrite_door_top"),"cutout");
        trapdoorBlockWithRenderType(ModBlocks.SACRITE_TRAPDOOR.get(), modLoc("block/sacrite_trapdoor"),true,"cutout");


        blockItem(ModBlocks.SACRITE_STAIRS);
        blockItem(ModBlocks.SACRITE_SLAB);
        blockItem(ModBlocks.SACRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.SACRITE_FENCE_GATE);
        blockItem(ModBlocks.SACRITE_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
