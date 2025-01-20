package net.max_di.rtw.common.blocks;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.blocks.custom.SawmillBlock;
import net.max_di.rtw.common.items.ModItemsRW;
import net.max_di.rtw.common.utils.ModBlockSetTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocksRW {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, RTW.MOD_ID);


    public static final Supplier<Block> GINGERBREAD_DOUGH_BLOCK = registerBlock("gingerbread_dough_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.5F).sound(SoundType.HONEY_BLOCK)));
    public static final Supplier<Block> CHOCOLATE_GINGERBREAD_DOUGH_BLOCK = registerBlock("chocolate_gingerbread_dough_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.HONEY_BLOCK)));

    public static final Supplier<Block> GINGERBREAD_BLOCK = registerBlock("gingerbread_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> CHOCOLATE_GINGERBREAD_BLOCK = registerBlock("chocolate_gingerbread_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<RotatedPillarBlock> GLAZED_GINGERBREAD_BLOCK = registerBlock("glazed_gingerbread_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocksRW.GINGERBREAD_BLOCK.get())));
    public static final Supplier<RotatedPillarBlock> GLAZED_CHOCOLATE_GINGERBREAD_BLOCK = registerBlock("glazed_chocolate_gingerbread_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get())));

    public static final Supplier<Block> GINGERBREAD_BRICKS = registerBlock("gingerbread_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> CHOCOLATE_GINGERBREAD_BRICKS = registerBlock("chocolate_gingerbread_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));

    public static final Supplier<Block> GLAZED_GINGERBREAD_BRICKS = registerBlock("glazed_gingerbread_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> GLAZED_CHOCOLATE_GINGERBREAD_BRICKS = registerBlock("glazed_chocolate_gingerbread_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));


    public static final Supplier<DoorBlock> GINGERBREAD_DOOR = registerBlock("gingerbread_door",
            () -> new DoorBlock(ModBlockSetTypes.GINGERBREAD, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).sound(SoundType.CANDLE).strength(0.5F).sound(SoundType.CANDLE)
                    .noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<DoorBlock> CHOCOLATE_GINGERBREAD_DOOR = registerBlock("chocolate_gingerbread_door",
            () -> new DoorBlock(ModBlockSetTypes.GINGERBREAD, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.CANDLE).strength(0.5F).sound(SoundType.CANDLE)
                    .noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final Supplier<TrapDoorBlock> GINGERBREAD_TRAPDOOR = registerBlock("gingerbread_trapdoor",
            () -> new TrapDoorBlock(ModBlockSetTypes.GINGERBREAD, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)
                    .noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<TrapDoorBlock> CHOCOLATE_GINGERBREAD_TRAPDOOR = registerBlock("chocolate_gingerbread_trapdoor",
            () -> new TrapDoorBlock(ModBlockSetTypes.GINGERBREAD, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)
                    .noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> GINGERBREAD_BLOCK_STAIRS = registerBlock("gingerbread_block_stairs",
            () -> new StairBlock(ModBlocksRW.GINGERBREAD_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> CHOCOLATE_GINGERBREAD_BLOCK_STAIRS = registerBlock("chocolate_gingerbread_block_stairs",
            () -> new StairBlock(ModBlocksRW.CHOCOLATE_GINGERBREAD_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> GINGERBREAD_BRICKS_STAIRS = registerBlock("gingerbread_bricks_stairs",
            () -> new StairBlock(ModBlocksRW.GINGERBREAD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> CHOCOLATE_GINGERBREAD_BRICKS_STAIRS = registerBlock("chocolate_gingerbread_bricks_stairs",
            () -> new StairBlock(ModBlocksRW.CHOCOLATE_GINGERBREAD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> GLAZED_GINGERBREAD_BRICKS_STAIRS = registerBlock("glazed_gingerbread_bricks_stairs",
            () -> new StairBlock(ModBlocksRW.GLAZED_GINGERBREAD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_STAIRS = registerBlock("glazed_chocolate_gingerbread_bricks_stairs",
            () -> new StairBlock(ModBlocksRW.GLAZED_CHOCOLATE_GINGERBREAD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));

    public static final Supplier<Block> GINGERBREAD_BLOCK_SLAB = registerBlock("gingerbread_block_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> CHOCOLATE_GINGERBREAD_BLOCK_SLAB = registerBlock("chocolate_gingerbread_block_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> GINGERBREAD_BRICKS_SLAB = registerBlock("gingerbread_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> CHOCOLATE_GINGERBREAD_BRICKS_SLAB = registerBlock("chocolate_gingerbread_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> GLAZED_GINGERBREAD_BRICKS_SLAB = registerBlock("glazed_gingerbread_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.CANDLE)));
    public static final Supplier<Block> GLAZED_CHOCOLATE_GINGERBREAD_BRICKS_SLAB = registerBlock("glazed_chocolate_gingerbread_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.CANDLE)));

    public static final Supplier<Block> OAK_PARQUET = registerBlock("oak_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_PARQUET = registerBlock("spruce_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_PARQUET = registerBlock("birch_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_PARQUET = registerBlock("jungle_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_PARQUET = registerBlock("acacia_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> CHERRY_PARQUET = registerBlock("cherry_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> DARK_OAK_PARQUET = registerBlock("dark_oak_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_PARQUET = registerBlock("mangrove_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CRIMSON_PARQUET = registerBlock("crimson_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_PARQUET = registerBlock("warped_parquet",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    public static final Supplier<RotatedPillarBlock> CARVED_OAK_PLANKS = registerBlock("carved_oak_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_SPRUCE_PLANKS = registerBlock("carved_spruce_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_BIRCH_PLANKS = registerBlock("carved_birch_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_JUNGLE_PLANKS = registerBlock("carved_jungle_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_ACACIA_PLANKS = registerBlock("carved_acacia_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_CHERRY_PLANKS = registerBlock("carved_cherry_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_DARK_OAK_PLANKS = registerBlock("carved_dark_oak_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_MANGROVE_PLANKS = registerBlock("carved_mangrove_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_CRIMSON_PLANKS = registerBlock("carved_crimson_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<RotatedPillarBlock> CARVED_WARPED_PLANKS = registerBlock("carved_warped_planks",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    public static final Supplier<Block> SAWMILL = registerBlock("sawmill",
            () -> new SawmillBlock(BlockBehaviour.Properties.of().strength(3.5F).requiresCorrectToolForDrops().sound(SoundType.WOOD)));


    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> Supplier<Item> registerBlockItem(String name, Supplier<T> block) {
        return ModItemsRW.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
