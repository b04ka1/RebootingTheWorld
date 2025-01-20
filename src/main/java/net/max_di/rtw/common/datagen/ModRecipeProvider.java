package net.max_di.rtw.common.datagen;

import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.items.ModItemsRW;
import net.max_di.rtw.common.utils.ModSingleItemRecipeBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    List<ItemLike> LOGS = List.of(
            Items.OAK_LOG,
            Items.DARK_OAK_LOG,
            Items.BIRCH_LOG,
            Items.SPRUCE_LOG,
            Items.JUNGLE_LOG,
            Items.ACACIA_LOG,
            Items.MANGROVE_LOG,
            Items.CHERRY_LOG);

    List<ItemLike> STRIPPED_LOGS = List.of(
            Items.STRIPPED_OAK_LOG,
            Items.STRIPPED_DARK_OAK_LOG,
            Items.STRIPPED_BIRCH_LOG,
            Items.STRIPPED_SPRUCE_LOG,
            Items.STRIPPED_JUNGLE_LOG,
            Items.STRIPPED_ACACIA_LOG,
            Items.STRIPPED_MANGROVE_LOG,
            Items.STRIPPED_CHERRY_LOG);

    List<ItemLike> BOATS = List.of(
            Items.OAK_BOAT,
            Items.DARK_OAK_BOAT,
            Items.BIRCH_BOAT,
            Items.SPRUCE_BOAT,
            Items.JUNGLE_BOAT,
            Items.ACACIA_BOAT,
            Items.MANGROVE_BOAT,
            Items.CHERRY_BOAT,
            Items.BAMBOO_RAFT);

    List<ItemLike> WOOD = List.of(
            Items.OAK_WOOD,
            Items.DARK_OAK_WOOD,
            Items.BIRCH_WOOD,
            Items.SPRUCE_WOOD,
            Items.JUNGLE_WOOD,
            Items.ACACIA_WOOD,
            Items.MANGROVE_WOOD,
            Items.CHERRY_WOOD,
            Items.BAMBOO_BLOCK);

    List<ItemLike> STRIPPED_WOOD = List.of(
            Items.STRIPPED_OAK_WOOD,
            Items.STRIPPED_DARK_OAK_WOOD,
            Items.STRIPPED_BIRCH_WOOD,
            Items.STRIPPED_SPRUCE_WOOD,
            Items.STRIPPED_JUNGLE_WOOD,
            Items.STRIPPED_ACACIA_WOOD,
            Items.STRIPPED_MANGROVE_WOOD,
            Items.STRIPPED_CHERRY_WOOD,
            Items.STRIPPED_BAMBOO_BLOCK);

    List<ItemLike> PLANKS = List.of(
            Items.OAK_PLANKS,
            Items.DARK_OAK_PLANKS,
            Items.BIRCH_PLANKS,
            Items.SPRUCE_PLANKS,
            Items.JUNGLE_PLANKS,
            Items.ACACIA_PLANKS,
            Items.MANGROVE_PLANKS,
            Items.CHERRY_PLANKS,
            Items.BAMBOO_PLANKS);

    List<ItemLike> STAIRS = List.of(
            Items.OAK_STAIRS,
            Items.DARK_OAK_STAIRS,
            Items.BIRCH_STAIRS,
            Items.SPRUCE_STAIRS,
            Items.JUNGLE_STAIRS,
            Items.ACACIA_STAIRS,
            Items.MANGROVE_STAIRS,
            Items.CHERRY_STAIRS,
            Items.BAMBOO_STAIRS);

    List<ItemLike> SLABS = List.of(
            Items.OAK_SLAB,
            Items.DARK_OAK_SLAB,
            Items.BIRCH_SLAB,
            Items.SPRUCE_SLAB,
            Items.JUNGLE_SLAB,
            Items.ACACIA_SLAB,
            Items.MANGROVE_SLAB,
            Items.CHERRY_SLAB,
            Items.BAMBOO_SLAB);

    List<ItemLike> FENCES = List.of(
            Items.OAK_FENCE,
            Items.DARK_OAK_FENCE,
            Items.BIRCH_FENCE,
            Items.SPRUCE_FENCE,
            Items.JUNGLE_FENCE,
            Items.ACACIA_FENCE,
            Items.MANGROVE_FENCE,
            Items.CHERRY_FENCE,
            Items.BAMBOO_FENCE);

    List<ItemLike> FENCE_GATES = List.of(
            Items.OAK_FENCE_GATE,
            Items.DARK_OAK_FENCE_GATE,
            Items.BIRCH_FENCE_GATE,
            Items.SPRUCE_FENCE_GATE,
            Items.JUNGLE_FENCE_GATE,
            Items.ACACIA_FENCE_GATE,
            Items.MANGROVE_FENCE_GATE,
            Items.CHERRY_FENCE_GATE,
            Items.BAMBOO_FENCE_GATE);

    List<ItemLike> RAW_GINGERBREADS = List.of(
            ModItemsRW.RAW_GINGERBREAD.get(),
            ModItemsRW.RAW_CHOCOLATE_GINGERBREAD.get(),
            ModItemsRW.RAW_GINGERBREAD_BRICK.get(),
            ModItemsRW.RAW_CHOCOLATE_GINGERBREAD_BRICK.get(),
            ModItemsRW.RAW_GINGERBREAD_HEART.get(),
            ModItemsRW.RAW_GINGERBREAD_MAN.get(),
            ModItemsRW.RAW_GINGERBREAD_PINE.get(),
            ModItemsRW.RAW_GINGERBREAD_CREEPER.get(),
            ModItemsRW.RAW_GINGERBREAD_NOTE.get(),
            ModItemsRW.RAW_GINGERBREAD_STAR.get(),
            ModBlocksRW.GINGERBREAD_DOUGH_BLOCK.get().asItem(),
            ModBlocksRW.CHOCOLATE_GINGERBREAD_DOUGH_BLOCK.get().asItem());

    List<ItemLike> GINGERBREADS = List.of(
            ModItemsRW.GINGERBREAD.get(),
            ModItemsRW.CHOCOLATE_GINGERBREAD.get(),
            ModItemsRW.GINGERBREAD_BRICK.get(),
            ModItemsRW.CHOCOLATE_GINGERBREAD_BRICK.get(),
            ModItemsRW.GINGERBREAD_HEART.get(),
            ModItemsRW.GINGERBREAD_MAN.get(),
            ModItemsRW.GINGERBREAD_PINE.get(),
            ModItemsRW.GINGERBREAD_CREEPER.get(),
            ModItemsRW.GINGERBREAD_NOTE.get(),
            ModItemsRW.GINGERBREAD_STAR.get(),
            ModBlocksRW.GINGERBREAD_BLOCK.get().asItem(),
            ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get().asItem());

    List<ItemLike> GLAZED_GINGERBREADS = List.of(
            ModItemsRW.GLAZED_GINGERBREAD.get(),
            ModItemsRW.GLAZED_CHOCOLATE_GINGERBREAD.get(),
            ModItemsRW.GLAZED_GINGERBREAD_BRICK.get(),
            ModItemsRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICK.get(),
            ModItemsRW.GLAZED_GINGERBREAD_HEART.get(),
            ModItemsRW.GLAZED_GINGERBREAD_MAN.get(),
            ModItemsRW.GLAZED_GINGERBREAD_PINE.get(),
            ModItemsRW.GLAZED_GINGERBREAD_CREEPER.get(),
            ModItemsRW.GLAZED_GINGERBREAD_NOTE.get(),
            ModItemsRW.GLAZED_GINGERBREAD_STAR.get());

    List<ItemLike> PARQUETS = List.of(
            ModBlocksRW.OAK_PARQUET.get(),
            ModBlocksRW.DARK_OAK_PARQUET.get(),
            ModBlocksRW.BIRCH_PARQUET.get(),
            ModBlocksRW.SPRUCE_PARQUET.get(),
            ModBlocksRW.JUNGLE_PARQUET.get(),
            ModBlocksRW.ACACIA_PARQUET.get(),
            ModBlocksRW.MANGROVE_PARQUET.get(),
            ModBlocksRW.CHERRY_PARQUET.get(),
            ModBlocksRW.WARPED_PARQUET.get(),
            ModBlocksRW.CRIMSON_PARQUET.get());

    List<ItemLike> CARVED_PLANKS = List.of(
            ModBlocksRW.CARVED_OAK_PLANKS.get(),
            ModBlocksRW.CARVED_DARK_OAK_PLANKS.get(),
            ModBlocksRW.CARVED_BIRCH_PLANKS.get(),
            ModBlocksRW.CARVED_SPRUCE_PLANKS.get(),
            ModBlocksRW.CARVED_JUNGLE_PLANKS.get(),
            ModBlocksRW.CARVED_ACACIA_PLANKS.get(),
            ModBlocksRW.CARVED_MANGROVE_PLANKS.get(),
            ModBlocksRW.CARVED_CHERRY_PLANKS.get(),
            ModBlocksRW.CARVED_WARPED_PLANKS.get(),
            ModBlocksRW.CARVED_CRIMSON_PLANKS.get());

    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(packOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        for (int i = 0; i < WOOD.size(); i++) {
            sawmilling(recipeOutput, RecipeCategory.MISC, WOOD.get(i), STRIPPED_WOOD.get(i), 1);
            sawmilling(recipeOutput, RecipeCategory.MISC, WOOD.get(i), PLANKS.get(i), 4);
            sawmilling(recipeOutput, RecipeCategory.MISC, WOOD.get(i), BOATS.get(i), 1);
            sawmilling(recipeOutput, RecipeCategory.MISC, STRIPPED_WOOD.get(i), PLANKS.get(i), 4);
            sawmilling(recipeOutput, RecipeCategory.MISC, STRIPPED_WOOD.get(i), BOATS.get(i), 1);
        }
        for (int i = 0; i < LOGS.size(); i++) {
            sawmilling(recipeOutput, RecipeCategory.MISC, LOGS.get(i), STRIPPED_LOGS.get(i), 1);
            sawmilling(recipeOutput, RecipeCategory.MISC, LOGS.get(i), PLANKS.get(i), 4);
            sawmilling(recipeOutput, RecipeCategory.MISC, LOGS.get(i), BOATS.get(i), 1);
            sawmilling(recipeOutput, RecipeCategory.MISC, STRIPPED_LOGS.get(i), PLANKS.get(i), 4);
            sawmilling(recipeOutput, RecipeCategory.MISC, STRIPPED_LOGS.get(i), BOATS.get(i), 1);
        }
        for (int i = 0; i < PLANKS.size(); i++) {
            sawmilling(recipeOutput, RecipeCategory.MISC, PLANKS.get(i), STAIRS.get(i), 1);
            sawmilling(recipeOutput, RecipeCategory.MISC, PLANKS.get(i), SLABS.get(i), 2);
            sawmilling(recipeOutput, RecipeCategory.MISC, PLANKS.get(i), FENCES.get(i), 2);
            sawmilling(recipeOutput, RecipeCategory.MISC, PLANKS.get(i), FENCE_GATES.get(i), 1);
        }
        for (int i = 0; i < RAW_GINGERBREADS.size(); i++) {
            simpleCookingRecipe(recipeOutput, "smelting", RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, 200, RAW_GINGERBREADS.get(i), GINGERBREADS.get(i), 0.1F);
            simpleCookingRecipe(recipeOutput, "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100, RAW_GINGERBREADS.get(i), GINGERBREADS.get(i), 0.1F);
            simpleCookingRecipe(recipeOutput, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 400, RAW_GINGERBREADS.get(i), GINGERBREADS.get(i), 0.1F);
        }
        for (int i = 0; i < GLAZED_GINGERBREADS.size(); i++) {
            glazing(recipeOutput, GINGERBREADS.get(i), GLAZED_GINGERBREADS.get(i));
        }
        for (int i = 0; i < PARQUETS.size() - 2; i++) {
            sawmilling(recipeOutput, RecipeCategory.MISC, PLANKS.get(i), PARQUETS.get(i), 1);
            sawmilling(recipeOutput, RecipeCategory.MISC, LOGS.get(i), PARQUETS.get(i), 4);
            parquet(recipeOutput, PARQUETS.get(i), PLANKS.get(i));
        }

        for (int i = 0; i < CARVED_PLANKS.size() - 2; i++) {
            sawmilling(recipeOutput, RecipeCategory.MISC, PLANKS.get(i), CARVED_PLANKS.get(i), 1);
            sawmilling(recipeOutput, RecipeCategory.MISC, LOGS.get(i), CARVED_PLANKS.get(i), 4);
            carvedPlanks(recipeOutput, CARVED_PLANKS.get(i), PLANKS.get(i));
        }

        twoByTwoPacker(recipeOutput, RecipeCategory.MISC, ModBlocksRW.GINGERBREAD_BRICKS.get(), ModItemsRW.GINGERBREAD_BRICK.get());
        twoByTwoPacker(recipeOutput, RecipeCategory.MISC, ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get(), ModItemsRW.CHOCOLATE_GINGERBREAD_BRICK.get());
        twoByTwoPacker(recipeOutput, RecipeCategory.MISC, ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get(), ModItemsRW.GLAZED_GINGERBREAD_BRICK.get());
        twoByTwoPacker(recipeOutput, RecipeCategory.MISC, ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get(), ModItemsRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICK.get());
        twoByTwoPacker(recipeOutput, RecipeCategory.MISC, ModBlocksRW.GINGERBREAD_DOUGH_BLOCK.get(), ModItemsRW.GINGERBREAD_DOUGH.get());
        twoByTwoPacker(recipeOutput, RecipeCategory.MISC, ModBlocksRW.CHOCOLATE_GINGERBREAD_DOUGH_BLOCK.get(), ModItemsRW.CHOCOLATE_GINGERBREAD_DOUGH.get());
        slabBuilder(RecipeCategory.MISC, ModBlocksRW.GINGERBREAD_BLOCK_SLAB.get(), Ingredient.of(ModBlocksRW.GINGERBREAD_BLOCK.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        slabBuilder(RecipeCategory.MISC, ModBlocksRW.GINGERBREAD_BRICKS_SLAB.get(), Ingredient.of(ModBlocksRW.GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        slabBuilder(RecipeCategory.MISC, ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB.get(), Ingredient.of((ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get()))).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        slabBuilder(RecipeCategory.MISC, ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB.get(), Ingredient.of(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        slabBuilder(RecipeCategory.MISC, ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get(), Ingredient.of(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        slabBuilder(RecipeCategory.MISC, ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get(), Ingredient.of(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        stairBuilder(ModBlocksRW.GINGERBREAD_BLOCK_STAIRS.get(), Ingredient.of(ModBlocksRW.GINGERBREAD_BLOCK.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        stairBuilder(ModBlocksRW.GINGERBREAD_BRICKS_STAIRS.get(), Ingredient.of(ModBlocksRW.GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        stairBuilder(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_STAIRS.get(), Ingredient.of(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        stairBuilder(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_STAIRS.get(), Ingredient.of(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        stairBuilder(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get(), Ingredient.of(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        stairBuilder(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get(), Ingredient.of(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        doorBuilder(ModBlocksRW.GINGERBREAD_DOOR.get(), Ingredient.of(ModBlocksRW.GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        doorBuilder(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR.get(), Ingredient.of(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocksRW.GINGERBREAD_TRAPDOOR.get(), Ingredient.of(ModBlocksRW.GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocksRW.CHOCOLATE_GINGERBREAD_TRAPDOOR.get(), Ingredient.of(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get())).unlockedBy("has_gingerbread_dough", has(ModItemsRW.GINGERBREAD_DOUGH.get())).save(recipeOutput);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.CRIMSON_PLANKS, ModBlocksRW.CRIMSON_PARQUET.get(), 1);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.WARPED_PLANKS, ModBlocksRW.WARPED_PARQUET.get(), 1);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.CRIMSON_STEM, ModBlocksRW.CRIMSON_PARQUET.get(), 4);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.WARPED_STEM, ModBlocksRW.WARPED_PARQUET.get(), 4);
        parquet(recipeOutput, ModBlocksRW.CRIMSON_PARQUET.get(), Blocks.CRIMSON_PLANKS);
        parquet(recipeOutput, ModBlocksRW.WARPED_PARQUET.get(), Blocks.WARPED_PLANKS);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.CRIMSON_PLANKS, ModBlocksRW.CARVED_CRIMSON_PLANKS.get(), 1);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.WARPED_PLANKS, ModBlocksRW.CARVED_WARPED_PLANKS.get(), 1);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.CRIMSON_STEM, ModBlocksRW.CARVED_CRIMSON_PLANKS.get(), 4);
        sawmilling(recipeOutput, RecipeCategory.MISC, Blocks.WARPED_STEM, ModBlocksRW.CARVED_WARPED_PLANKS.get(), 4);
        carvedPlanks(recipeOutput, ModBlocksRW.CARVED_CRIMSON_PLANKS.get(), Blocks.CRIMSON_PLANKS);
        carvedPlanks(recipeOutput, ModBlocksRW.CARVED_WARPED_PLANKS.get(), Blocks.WARPED_PLANKS);
        glazing(recipeOutput, ModBlocksRW.GINGERBREAD_BLOCK.get(), ModBlocksRW.GLAZED_GINGERBREAD_BLOCK.get());
        glazing(recipeOutput, ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get(), ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BLOCK.get());
        shapelessFromThreeIngredients(recipeOutput, ModItemsRW.SMALL_DYNAMITE_STICK.get(), Items.GUNPOWDER, Items.STRING, Items.PAPER);
        spiky(recipeOutput, ModItemsRW.SMALL_SPIKY_DYNAMITE_STICK.get(), ModItemsRW.SMALL_DYNAMITE_STICK.get(), Items.IRON_NUGGET);
        twoByTwoPacker(recipeOutput, RecipeCategory.TOOLS, ModItemsRW.MEDIUM_DYNAMITE_STICK.get(), ModItemsRW.SMALL_DYNAMITE_STICK.get());
        twoByTwoPacker(recipeOutput, RecipeCategory.TOOLS, ModItemsRW.MEDIUM_SPIKY_DYNAMITE_STICK.get(), ModItemsRW.SMALL_SPIKY_DYNAMITE_STICK.get());
        threeByThreePacker(recipeOutput, RecipeCategory.TOOLS, ModItemsRW.BIG_DYNAMITE_STICK.get(), ModItemsRW.SMALL_DYNAMITE_STICK.get());
        threeByThreePacker(recipeOutput, RecipeCategory.TOOLS, ModItemsRW.BIG_SPIKY_DYNAMITE_STICK.get(), ModItemsRW.SMALL_SPIKY_DYNAMITE_STICK.get());
    }

    public static void sawmilling(RecipeOutput recipeOutput, RecipeCategory category, ItemLike ingredient, ItemLike result, int count) {
        ModSingleItemRecipeBuilder.sawmilling(Ingredient.of(ingredient), category, result, count)
                .unlockedBy(getHasName(result), has(result))
                .save(recipeOutput, getConversionRecipeName(result, ingredient) + "_sawmilling");
    }

    public static void sawmilling(RecipeOutput recipeOutput, RecipeCategory category, List<ItemLike> ingredients, ItemLike result, int count) {
        for (ItemLike itemLike : ingredients) {
            ModSingleItemRecipeBuilder.sawmilling(Ingredient.of(itemLike), category, result, count)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, getConversionRecipeName(result, itemLike) + "_sawmilling");
        }
    }

    protected static void shapelessFromThreeIngredients(RecipeOutput pRecipeOutput, ItemLike result, ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 9)
                .requires(ingredient1, 1)
                .requires(ingredient2, 1)
                .requires(ingredient3, 1)
                .unlockedBy("has_gunpowder", has(Items.GUNPOWDER))
                .save(pRecipeOutput);
    }

    public static void glazing(RecipeOutput recipeOutput, ItemLike ingredient, ItemLike result) {
        shapelessFromThreeIngredients(recipeOutput, result, ingredient, Items.SUGAR, Items.MILK_BUCKET);
    }

    protected static void parquet(RecipeOutput pRecipeOutput, ItemLike pPacked, ItemLike pUnpacked) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, pPacked, 9).requires(pUnpacked, 9).unlockedBy("parquet", has(pUnpacked)).save(pRecipeOutput);
    }

    protected static void carvedPlanks(RecipeOutput pRecipeOutput, ItemLike pPacked, ItemLike pUnpacked) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pPacked, 8)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', pUnpacked)
                .unlockedBy("has_planks", has(pUnpacked))
                .save(pRecipeOutput);
    }

    protected static void spiky(RecipeOutput pRecipeOutput, ItemLike result, ItemLike centerItem, ItemLike sideItem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result, 1)
                .pattern(" # ")
                .pattern("#0#")
                .pattern(" # ")
                .define('#', sideItem)
                .define('0', centerItem)
                .unlockedBy("has_gunpowder", has(Items.GUNPOWDER))
                .save(pRecipeOutput);
    }
}
