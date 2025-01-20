package net.max_di.rtw.common.datagen;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.items.ModItemsRW;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;


public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RTW.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItemsRW.GINGERBREAD_MAN_SPAWN_EGG.get());
        basicItem(ModItemsRW.GINGERBREAD_CREEPER_SPAWN_EGG.get());
        basicItem(ModItemsRW.GINGERBREAD.get());
        basicItem(ModItemsRW.GINGERBREAD_FORM.get());
        basicItem(ModItemsRW.RAW_GINGERBREAD.get());
        basicItem(ModItemsRW.RAW_CHOCOLATE_GINGERBREAD.get());
        basicItem(ModItemsRW.GLAZED_GINGERBREAD.get());
        basicItem(ModItemsRW.CHOCOLATE_GINGERBREAD.get());
        basicItem(ModItemsRW.RAW_CHOCOLATE_GINGERBREAD_BRICK.get());
        basicItem(ModItemsRW.CHOCOLATE_GINGERBREAD_BRICK.get());
        basicItem(ModItemsRW.GLAZED_GINGERBREAD_BRICK.get());
        basicItem(ModItemsRW.GINGERBREAD_FORM_CREEPER.get());
        basicItem(ModItemsRW.RAW_GINGERBREAD_CREEPER.get());
        basicItem(ModItemsRW.GINGERBREAD_CREEPER.get());
        basicItem(ModItemsRW.GLAZED_GINGERBREAD_CREEPER.get());
        basicItem(ModItemsRW.GINGERBREAD_FORM_NOTE.get());
        basicItem(ModItemsRW.RAW_GINGERBREAD_NOTE.get());
        basicItem(ModItemsRW.GINGERBREAD_NOTE.get());
        basicItem(ModItemsRW.GLAZED_GINGERBREAD_NOTE.get());
        basicItem(ModItemsRW.GINGERBREAD_FORM_STAR.get());
        basicItem(ModItemsRW.GINGERBREAD_STAR.get());
        basicItem(ModItemsRW.RAW_GINGERBREAD_STAR.get());
        basicItem(ModItemsRW.GLAZED_GINGERBREAD_STAR.get());
        basicItem(ModItemsRW.CHOCOLATE_GINGERBREAD_DOUGH.get());
        basicItem(ModItemsRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICK.get());
        basicItem(ModItemsRW.GLAZED_CHOCOLATE_GINGERBREAD.get());
        basicItem(ModItemsRW.GLAZED_GINGERBREAD_HEART.get());
        basicItem(ModBlocksRW.GINGERBREAD_DOOR.get().asItem());
        basicItem(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR.get().asItem());
        basicItem(ModItemsRW.SMALL_DYNAMITE_STICK.get());
        basicItem(ModItemsRW.SMALL_SPIKY_DYNAMITE_STICK.get());
        basicItem(ModItemsRW.MEDIUM_DYNAMITE_STICK.get());
        basicItem(ModItemsRW.MEDIUM_SPIKY_DYNAMITE_STICK.get());
        basicItem(ModItemsRW.BIG_DYNAMITE_STICK.get());
        basicItem(ModItemsRW.BIG_SPIKY_DYNAMITE_STICK.get());
    }

    private ItemModelBuilder toolItem(Item item) {
        ResourceLocation itemLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        return getBuilder(itemLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(itemLoc.getNamespace(), "item/" + itemLoc.getPath()));
    }
}
