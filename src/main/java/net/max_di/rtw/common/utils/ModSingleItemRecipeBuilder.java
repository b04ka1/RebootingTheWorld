package net.max_di.rtw.common.utils;

import net.max_di.rtw.common.recipes.SawmillRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ModSingleItemRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;
    private final SingleItemRecipe.Factory<?> factory;

    public ModSingleItemRecipeBuilder(RecipeCategory pCategory, SingleItemRecipe.Factory<?> pFactory, Ingredient pIngredient, ItemLike pResult, int pCount) {
        this.category = pCategory;
        this.factory = pFactory;
        this.result = pResult.asItem();
        this.ingredient = pIngredient;
        this.count = pCount;
    }

    public static ModSingleItemRecipeBuilder sawmilling(Ingredient p_251375_, RecipeCategory p_248984_, ItemLike p_250105_, int p_249506_) {
        return new ModSingleItemRecipeBuilder(p_248984_, SawmillRecipe::new, p_251375_, p_250105_, p_249506_);
    }

    public ModSingleItemRecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        this.criteria.put(pName, pCriterion);
        return this;
    }

    public ModSingleItemRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(RecipeOutput pRecipeOutput, ResourceLocation pId) {
        this.ensureValid(pId);
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        SingleItemRecipe singleitemrecipe = this.factory
                .create(Objects.requireNonNullElse(this.group, ""), this.ingredient, new ItemStack(this.result, this.count));
        pRecipeOutput.accept(pId, singleitemrecipe, advancement$builder.build(pId.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
}
