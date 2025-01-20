package net.max_di.rtw.common.datagen;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RTW.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocksRW.OAK_PARQUET.get())
                .add(ModBlocksRW.SPRUCE_PARQUET.get())
                .add(ModBlocksRW.BIRCH_PARQUET.get())
                .add(ModBlocksRW.JUNGLE_PARQUET.get())
                .add(ModBlocksRW.ACACIA_PARQUET.get())
                .add(ModBlocksRW.CHERRY_PARQUET.get())
                .add(ModBlocksRW.DARK_OAK_PARQUET.get())
                .add(ModBlocksRW.MANGROVE_PARQUET.get())
                .add(ModBlocksRW.CRIMSON_PARQUET.get())
                .add(ModBlocksRW.WARPED_PARQUET.get())
                .add(ModBlocksRW.CARVED_OAK_PLANKS.get())
                .add(ModBlocksRW.CARVED_SPRUCE_PLANKS.get())
                .add(ModBlocksRW.CARVED_BIRCH_PLANKS.get())
                .add(ModBlocksRW.CARVED_JUNGLE_PLANKS.get())
                .add(ModBlocksRW.CARVED_ACACIA_PLANKS.get())
                .add(ModBlocksRW.CARVED_CHERRY_PLANKS.get())
                .add(ModBlocksRW.CARVED_DARK_OAK_PLANKS.get())
                .add(ModBlocksRW.CARVED_MANGROVE_PLANKS.get())
                .add(ModBlocksRW.CARVED_CRIMSON_PLANKS.get())
                .add(ModBlocksRW.CARVED_WARPED_PLANKS.get());

        tag(BlockTags.PLANKS)
                .add(ModBlocksRW.OAK_PARQUET.get())
                .add(ModBlocksRW.SPRUCE_PARQUET.get())
                .add(ModBlocksRW.BIRCH_PARQUET.get())
                .add(ModBlocksRW.JUNGLE_PARQUET.get())
                .add(ModBlocksRW.ACACIA_PARQUET.get())
                .add(ModBlocksRW.CHERRY_PARQUET.get())
                .add(ModBlocksRW.DARK_OAK_PARQUET.get())
                .add(ModBlocksRW.MANGROVE_PARQUET.get())
                .add(ModBlocksRW.CRIMSON_PARQUET.get())
                .add(ModBlocksRW.WARPED_PARQUET.get())
                .add(ModBlocksRW.CARVED_OAK_PLANKS.get())
                .add(ModBlocksRW.CARVED_SPRUCE_PLANKS.get())
                .add(ModBlocksRW.CARVED_BIRCH_PLANKS.get())
                .add(ModBlocksRW.CARVED_JUNGLE_PLANKS.get())
                .add(ModBlocksRW.CARVED_ACACIA_PLANKS.get())
                .add(ModBlocksRW.CARVED_CHERRY_PLANKS.get())
                .add(ModBlocksRW.CARVED_DARK_OAK_PLANKS.get())
                .add(ModBlocksRW.CARVED_MANGROVE_PLANKS.get())
                .add(ModBlocksRW.CARVED_CRIMSON_PLANKS.get())
                .add(ModBlocksRW.CARVED_WARPED_PLANKS.get());
    }
}
