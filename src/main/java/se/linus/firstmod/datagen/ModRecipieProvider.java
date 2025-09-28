package se.linus.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import se.linus.firstmod.FirstMod;
import se.linus.firstmod.block.ModBlocks;
import se.linus.firstmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipieProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipieProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> SACRITE_SMELTABLES = List.of(ModItems.RAW_SACRITE.get(),
                ModBlocks.SACRITE_ORE.get(), ModBlocks.DEEPSLATE_SACRITE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SACRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SACRITE.get())
                .unlockedBy(getHasName(ModItems.SACRITE.get()), has(ModItems.SACRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLAME_WAND.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("B  ")
                .define('A', ModItems.INFLAMITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.INFLAMITE.get()), has(ModItems.INFLAMITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SACRITE.get(),9)
                .requires(ModBlocks.SACRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SACRITE_BLOCK.get()), has(ModBlocks.SACRITE_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, SACRITE_SMELTABLES, RecipeCategory.MISC, ModItems.SACRITE.get(),0.25f,200,"sacrite");
        oreBlasting(pRecipeOutput, SACRITE_SMELTABLES, RecipeCategory.MISC, ModItems.SACRITE.get(),0.25f,100,"sacrite");

        stairBuilder(ModBlocks.SACRITE_STAIRS.get(), Ingredient.of(ModItems.SACRITE.get())).group("sacrite")
                .unlockedBy(getHasName(ModItems.SACRITE.get()), has(ModItems.SACRITE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SACRITE_SLAB.get(), ModItems.SACRITE.get());

        buttonBuilder(ModBlocks.SACRITE_BUTTON.get(), Ingredient.of(ModItems.SACRITE.get())).group("sacrite")
                .unlockedBy(getHasName(ModItems.SACRITE.get()), has(ModItems.SACRITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.SACRITE_PRESSURE_PLATE.get(), ModItems.SACRITE.get());

        fenceBuilder(ModBlocks.SACRITE_FENCE.get(), Ingredient.of(ModItems.SACRITE.get())).group("sacrite")
                .unlockedBy(getHasName(ModItems.SACRITE.get()), has(ModItems.SACRITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.SACRITE_FENCE_GATE.get(), Ingredient.of(ModItems.SACRITE.get())).group("sacrite")
                .unlockedBy(getHasName(ModItems.SACRITE.get()), has(ModItems.SACRITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SACRITE_WALL.get(), ModItems.SACRITE.get());

        doorBuilder(ModBlocks.SACRITE_DOOR.get(), Ingredient.of(ModItems.SACRITE.get())).group("sacrite")
                .unlockedBy(getHasName(ModItems.SACRITE.get()), has(ModItems.SACRITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.SACRITE_TRAPDOOR.get(), Ingredient.of(ModItems.SACRITE.get())).group("sacrite")
                .unlockedBy(getHasName(ModItems.SACRITE.get()), has(ModItems.SACRITE.get())).save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,
                                                                       String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
