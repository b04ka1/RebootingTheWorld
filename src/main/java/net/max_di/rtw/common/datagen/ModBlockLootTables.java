package net.max_di.rtw.common.datagen;

import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocksRW.GINGERBREAD_DOUGH_BLOCK.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOUGH_BLOCK.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BLOCK.get());
        this.dropSelf(ModBlocksRW.GLAZED_GINGERBREAD_BLOCK.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get());
        this.dropSelf(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BLOCK.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_TRAPDOOR.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_TRAPDOOR.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BLOCK_STAIRS.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_STAIRS.get());
        this.dropSelf(ModBlocksRW.GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocksRW.SAWMILL.get());
        this.add(ModBlocksRW.GINGERBREAD_DOOR.get(), block -> createDoorTable(ModBlocksRW.GINGERBREAD_DOOR.get()));
        this.add(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR.get(), block -> createDoorTable(ModBlocksRW.CHOCOLATE_GINGERBREAD_DOOR.get()));
        this.add(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK_SLAB.get()));
        this.add(ModBlocksRW.GINGERBREAD_BLOCK_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GINGERBREAD_BLOCK_SLAB.get()));
        this.add(ModBlocksRW.GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GINGERBREAD_BRICKS_SLAB.get()));
        this.add(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get()));
        this.add(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS_SLAB.get()));
        this.add(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get(), block -> createSlabItemTable(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB.get()));
        this.dropSelf(ModBlocksRW.OAK_PARQUET.get());
        this.dropSelf(ModBlocksRW.SPRUCE_PARQUET.get());
        this.dropSelf(ModBlocksRW.BIRCH_PARQUET.get());
        this.dropSelf(ModBlocksRW.JUNGLE_PARQUET.get());
        this.dropSelf(ModBlocksRW.ACACIA_PARQUET.get());
        this.dropSelf(ModBlocksRW.CHERRY_PARQUET.get());
        this.dropSelf(ModBlocksRW.DARK_OAK_PARQUET.get());
        this.dropSelf(ModBlocksRW.MANGROVE_PARQUET.get());
        this.dropSelf(ModBlocksRW.CRIMSON_PARQUET.get());
        this.dropSelf(ModBlocksRW.WARPED_PARQUET.get());
        this.dropSelf(ModBlocksRW.CARVED_OAK_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_SPRUCE_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_BIRCH_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_JUNGLE_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_ACACIA_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_CHERRY_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_DARK_OAK_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_MANGROVE_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_CRIMSON_PLANKS.get());
        this.dropSelf(ModBlocksRW.CARVED_WARPED_PLANKS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocksRW.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
