package net.max_di.rtw.common.recipes;

import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class SawmillRecipe extends SingleItemRecipe {
    public SawmillRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(ModRecipes.SAWMILL_TYPE.get(), ModRecipes.SAWMILL_SERIALIZER.get(), pGroup, pIngredient, pResult);
    }

    public boolean matches(SingleRecipeInput pInput, Level pLevel) {
        return this.ingredient.test(pInput.item());
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocksRW.SAWMILL.get());
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public ItemStack getResult() {
        return this.result;
    }
}