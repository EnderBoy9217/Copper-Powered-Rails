package com.enderboy9217.copperrails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

import static com.enderboy9217.copperrails.EndersCopperRails.MOD_ID;


public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        // Copper Ingots for Powered Rail
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.POWERED_RAIL, 6)
                .pattern("X X")
                .pattern("X#X")
                .pattern("XRX")
                .input('X', Items.COPPER_INGOT)
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.RAIL), conditionsFromItem(Items.RAIL))
                .offerTo(consumer, new Identifier(MOD_ID, "recipes/misc/" + getRecipeName(Items.POWERED_RAIL)));
    }
}
