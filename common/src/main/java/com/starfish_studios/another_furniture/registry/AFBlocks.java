package com.starfish_studios.another_furniture.registry;

import com.starfish_studios.another_furniture.AnotherFurniture;
import com.starfish_studios.another_furniture.block.*;
import com.starfish_studios.another_furniture.block.properties.ModBlockStateProperties;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class AFBlocks {

    public static class Properties {
        public static BlockBehaviour.Properties wood = Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
        public static BlockBehaviour.Properties nether_wood = Block.Properties.of(Material.NETHER_WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
        public static BlockBehaviour.Properties weak_wood = Block.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD);
        public static BlockBehaviour.Properties nether_weak_wood = Block.Properties.of(Material.NETHER_WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD);
        
        public static BlockBehaviour.Properties curtain = Block.Properties.of(Material.WOOL).strength(0.1F).sound(SoundType.WOOL).noOcclusion();
        public static BlockBehaviour.Properties service_bell = Block.Properties.of(Material.METAL).strength(2.0F, 3.0F).sound(SoundType.METAL);
        public static BlockBehaviour.Properties lamp = wood.lightLevel((blockState) -> blockState.hasProperty(BlockStateProperties.LIT) && blockState.getValue(BlockStateProperties.LIT) ? (blockState.getValue(ModBlockStateProperties.LEVEL_1_3) * 5) : 0);
        public static BlockBehaviour.Properties tombstone = Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE);
        public static BlockBehaviour.Properties awning = Block.Properties.of(Material.WOOL).strength(0.1F).sound(SoundType.WOOL).noOcclusion();
    }

    // Version 1 / Release
    // Chair
    public static final Supplier<Block> OAK_CHAIR = registerBlock("oak_chair", () -> new ChairBlock(Properties.wood));
    public static final Supplier<Block> SPRUCE_CHAIR = registerBlock("spruce_chair", () -> new ChairBlock(Properties.wood));
    public static final Supplier<Block> BIRCH_CHAIR = registerBlock("birch_chair", () -> new ChairBlock(Properties.wood));
    public static final Supplier<Block> JUNGLE_CHAIR = registerBlock("jungle_chair", () -> new ChairBlock(Properties.wood));
    public static final Supplier<Block> ACACIA_CHAIR = registerBlock("acacia_chair", () -> new ChairBlock(Properties.wood));
    public static final Supplier<Block> DARK_OAK_CHAIR = registerBlock("dark_oak_chair", () -> new ChairBlock(Properties.wood));
    public static final Supplier<Block> MANGROVE_CHAIR = registerBlock("mangrove_chair", () -> new ChairBlock(Properties.wood));
    public static final Supplier<Block> CRIMSON_CHAIR = registerBlock("crimson_chair", () -> new ChairBlock(Properties.nether_wood));
    public static final Supplier<Block> WARPED_CHAIR = registerBlock("warped_chair", () -> new ChairBlock(Properties.nether_wood));

    // Shelf
    public static final Supplier<Block> OAK_SHELF = registerBlock("oak_shelf", () -> new ShelfBlock(Properties.wood));
    public static final Supplier<Block> SPRUCE_SHELF = registerBlock("spruce_shelf", () -> new ShelfBlock(Properties.wood));
    public static final Supplier<Block> BIRCH_SHELF = registerBlock("birch_shelf", () -> new ShelfBlock(Properties.wood));
    public static final Supplier<Block> JUNGLE_SHELF = registerBlock("jungle_shelf", () -> new ShelfBlock(Properties.wood));
    public static final Supplier<Block> ACACIA_SHELF = registerBlock("acacia_shelf", () -> new ShelfBlock(Properties.wood));
    public static final Supplier<Block> DARK_OAK_SHELF = registerBlock("dark_oak_shelf", () -> new ShelfBlock(Properties.wood));
    public static final Supplier<Block> MANGROVE_SHELF = registerBlock("mangrove_shelf", () -> new ShelfBlock(Properties.wood));
    public static final Supplier<Block> CRIMSON_SHELF = registerBlock("crimson_shelf", () -> new ShelfBlock(Properties.nether_wood));
    public static final Supplier<Block> WARPED_SHELF = registerBlock("warped_shelf", () -> new ShelfBlock(Properties.nether_wood));

    // Table
    public static final Supplier<Block> OAK_TABLE = registerBlock("oak_table", () -> new TableBlock(Properties.wood));
    public static final Supplier<Block> SPRUCE_TABLE = registerBlock("spruce_table", () -> new TableBlock(Properties.wood));
    public static final Supplier<Block> BIRCH_TABLE = registerBlock("birch_table", () -> new TableBlock(Properties.wood));
    public static final Supplier<Block> JUNGLE_TABLE = registerBlock("jungle_table", () -> new TableBlock(Properties.wood));
    public static final Supplier<Block> ACACIA_TABLE = registerBlock("acacia_table", () -> new TableBlock(Properties.wood));
    public static final Supplier<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table", () -> new TableBlock(Properties.wood));
    public static final Supplier<Block> MANGROVE_TABLE = registerBlock("mangrove_table", () -> new TableBlock(Properties.wood));
    public static final Supplier<Block> CRIMSON_TABLE = registerBlock("crimson_table", () -> new TableBlock(Properties.nether_wood));
    public static final Supplier<Block> WARPED_TABLE = registerBlock("warped_table", () -> new TableBlock(Properties.nether_wood));

    // Stool
    public static final Supplier<Block> WHITE_STOOL = registerBlock("white_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> ORANGE_STOOL = registerBlock("orange_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> MAGENTA_STOOL = registerBlock("magenta_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> LIGHT_BLUE_STOOL = registerBlock("light_blue_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> YELLOW_STOOL = registerBlock("yellow_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> LIME_STOOL = registerBlock("lime_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> PINK_STOOL = registerBlock("pink_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> GRAY_STOOL = registerBlock("gray_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> LIGHT_GRAY_STOOL = registerBlock("light_gray_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> CYAN_STOOL = registerBlock("cyan_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> PURPLE_STOOL = registerBlock("purple_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> BLUE_STOOL = registerBlock("blue_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> BROWN_STOOL = registerBlock("brown_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> GREEN_STOOL = registerBlock("green_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> RED_STOOL = registerBlock("red_stool", () -> new StoolBlock(Properties.weak_wood));
    public static final Supplier<Block> BLACK_STOOL = registerBlock("black_stool", () -> new StoolBlock(Properties.weak_wood));

    // Version 2
    // Shutter
    public static final Supplier<Block> OAK_SHUTTER = registerBlock("oak_shutter", () -> new ShutterBlock(Properties.wood.noOcclusion()));
    public static final Supplier<Block> SPRUCE_SHUTTER = registerBlock("spruce_shutter", () -> new ShutterBlock(Properties.wood.noOcclusion()));
    public static final Supplier<Block> BIRCH_SHUTTER = registerBlock("birch_shutter", () -> new ShutterBlock(Properties.wood.noOcclusion()));
    public static final Supplier<Block> JUNGLE_SHUTTER = registerBlock("jungle_shutter", () -> new ShutterBlock(Properties.wood.noOcclusion()));
    public static final Supplier<Block> ACACIA_SHUTTER = registerBlock("acacia_shutter", () -> new ShutterBlock(Properties.wood.noOcclusion()));
    public static final Supplier<Block> DARK_OAK_SHUTTER = registerBlock("dark_oak_shutter", () -> new ShutterBlock(Properties.wood.noOcclusion()));
    public static final Supplier<Block> MANGROVE_SHUTTER = registerBlock("mangrove_shutter", () -> new ShutterBlock(Properties.wood.noOcclusion()));
    public static final Supplier<Block> CRIMSON_SHUTTER = registerBlock("crimson_shutter", () -> new ShutterBlock(Properties.nether_wood.noOcclusion()));
    public static final Supplier<Block> WARPED_SHUTTER = registerBlock("warped_shutter", () -> new ShutterBlock(Properties.nether_wood.noOcclusion()));

    // Planter Box
    public static final Supplier<Block> OAK_PLANTER_BOX = registerBlock("oak_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> SPRUCE_PLANTER_BOX = registerBlock("spruce_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BIRCH_PLANTER_BOX = registerBlock("birch_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> JUNGLE_PLANTER_BOX = registerBlock("jungle_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> ACACIA_PLANTER_BOX = registerBlock("acacia_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> DARK_OAK_PLANTER_BOX = registerBlock("dark_oak_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> MANGROVE_PLANTER_BOX = registerBlock("mangrove_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> CRIMSON_PLANTER_BOX = registerBlock("crimson_planter_box", () -> new PlanterBoxBlock(Properties.nether_wood));
    public static final Supplier<Block> WARPED_PLANTER_BOX = registerBlock("warped_planter_box", () -> new PlanterBoxBlock(Properties.nether_wood));
    public static final Supplier<Block> ECOLOGICS_FLOWERING_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/ecologics/flowering_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> ECOLOGICS_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/ecologics/azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> ECOLOGICS_COCONUT_PLANTER_BOX = registerBlockEverycomp("af/ecologics/coconut_planter_box", () -> new PlanterBoxBlock(Properties.wood));

    public static final Supplier<Block> ECOLOGICS_WALNUT_PLANTER_BOX = registerBlockEverycomp("af/ecologics/walnut_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_NETHER_REED_PLANTER_BOX = registerBlockEverycomp("af/betternether/nether_reed_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_STALAGNATE_PLANTER_BOX = registerBlockEverycomp("af/betternether/stalagnate_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_WILLOW_PLANTER_BOX = registerBlockEverycomp("af/betternether/willow_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_WART_PLANTER_BOX = registerBlockEverycomp("af/betternether/wart_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_RUBEUS_PLANTER_BOX = registerBlockEverycomp("af/betternether/rubeus_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_MUSHROOM_FIR_PLANTER_BOX = registerBlockEverycomp("af/betternether/mushroom_fir_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_NETHER_MUSHROOM_PLANTER_BOX = registerBlockEverycomp("af/betternether/nether_mushroom_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_ANCHOR_TREE_PLANTER_BOX = registerBlockEverycomp("af/betternether/anchor_tree_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTERNETHER_NETHER_SAKURA_PLANTER_BOX = registerBlockEverycomp("af/betternether/nether_sakura_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> ARCHITECTS_PALETTE_TWISTED_PLANTER_BOX = registerBlockEverycomp("af/architects_palette/twisted_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_MOSSY_GLOWSHROOM_PLANTER_BOX = registerBlockEverycomp("af/betterend/mossy_glowshroom_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_PYTHADENDRON_PLANTER_BOX = registerBlockEverycomp("af/betterend/pythadendron_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_END_LOTUS_PLANTER_BOX = registerBlockEverycomp("af/betterend/end_lotus_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_LACUGROVE_PLANTER_BOX = registerBlockEverycomp("af/betterend/lacugrove_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_DRAGON_TREE_PLANTER_BOX = registerBlockEverycomp("af/betterend/dragon_tree_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_TENANEA_PLANTER_BOX = registerBlockEverycomp("af/betterend/tenanea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_HELIX_TREE_PLANTER_BOX = registerBlockEverycomp("af/betterend/helix_tree_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_UMBRELLA_TREE_PLANTER_BOX = registerBlockEverycomp("af/betterend/umbrella_tree_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_JELLYSHROOM_PLANTER_BOX = registerBlockEverycomp("af/betterend/jellyshroom_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BETTEREND_LUCERNIA_PLANTER_BOX = registerBlockEverycomp("af/betterend/lucernia_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BLOCKUS_WHITE_OAK_PLANTER_BOX = registerBlockEverycomp("af/blockus/white_oak_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BLOCKUS_LEGACY_PLANTER_BOX = registerBlockEverycomp("af/blockus/legacy_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_ASPEN_PLANTER_BOX = registerBlockEverycomp("af/byg/aspen_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_BAOBAB_PLANTER_BOX = registerBlockEverycomp("af/byg/baobab_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_BLUE_ENCHANTED_PLANTER_BOX = registerBlockEverycomp("af/byg/blue_enchanted_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_BULBIS_PLANTER_BOX = registerBlockEverycomp("af/byg/bulbis_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_CHERRY_PLANTER_BOX = registerBlockEverycomp("af/byg/cherry_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_CIKA_PLANTER_BOX = registerBlockEverycomp("af/byg/cika_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_CYPRESS_PLANTER_BOX = registerBlockEverycomp("af/byg/cypress_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_EBONY_PLANTER_BOX = registerBlockEverycomp("af/byg/ebony_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_ETHER_PLANTER_BOX = registerBlockEverycomp("af/byg/ether_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_FIR_PLANTER_BOX = registerBlockEverycomp("af/byg/fir_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_GREEN_ENCHANTED_PLANTER_BOX = registerBlockEverycomp("af/byg/green_enchanted_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_HOLLY_PLANTER_BOX = registerBlockEverycomp("af/byg/holly_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_IMPARIUS_PLANTER_BOX = registerBlockEverycomp("af/byg/imparius_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_LAMENT_PLANTER_BOX = registerBlockEverycomp("af/byg/lament_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_JACARANDA_PLANTER_BOX = registerBlockEverycomp("af/byg/jacaranda_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_MAHOGANY_PLANTER_BOX = registerBlockEverycomp("af/byg/mahogany_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_WHITE_MANGROVE_PLANTER_BOX = registerBlockEverycomp("af/byg/white_mangrove_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_MAPLE_PLANTER_BOX = registerBlockEverycomp("af/byg/maple_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_NIGHTSHADE_PLANTER_BOX = registerBlockEverycomp("af/byg/nightshade_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_PALM_PLANTER_BOX = registerBlockEverycomp("af/byg/palm_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_PINE_PLANTER_BOX = registerBlockEverycomp("af/byg/pine_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_RAINBOW_EUCALYPTUS_PLANTER_BOX = registerBlockEverycomp("af/byg/rainbow_eucalyptus_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_REDWOOD_PLANTER_BOX = registerBlockEverycomp("af/byg/redwood_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_SKYRIS_PLANTER_BOX = registerBlockEverycomp("af/byg/skyris_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_WILLOW_PLANTER_BOX = registerBlockEverycomp("af/byg/willow_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_WITCH_HAZEL_PLANTER_BOX = registerBlockEverycomp("af/byg/witch_hazel_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_ZELKOVA_PLANTER_BOX = registerBlockEverycomp("af/byg/zelkova_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> BYG_SYTHIAN_PLANTER_BOX = registerBlockEverycomp("af/byg/sythian_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> CHARM_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/charm/azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> CHARM_EBONY_PLANTER_BOX = registerBlockEverycomp("af/charm/ebony_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> COLORFULAZALEAS_TECAL_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/colorfulazaleas/tecal_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> COLORFULAZALEAS_FISS_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/colorfulazaleas/fiss_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> COLORFULAZALEAS_ROZE_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/colorfulazaleas/roze_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> COLORFULAZALEAS_AZULE_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/colorfulazaleas/azule_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> COLORFULAZALEAS_BRIGHT_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/colorfulazaleas/bright_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> COLORFULAZALEAS_WALNUT_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/colorfulazaleas/walnut_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> COLORFULAZALEAS_TITANIUM_AZALEA_PLANTER_BOX = registerBlockEverycomp("af/colorfulazaleas/titanium_azalea_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> VINERY_CHERRY_PLANTER_BOX = registerBlockEverycomp("af/vinery/cherry_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> ENDERSCAPE_CELESTIAL_PLANTER_BOX = registerBlockEverycomp("af/enderscape/celestial_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> PROMENADE_DARK_AMARANTH_PLANTER_BOX = registerBlockEverycomp("af/promenade/dark_amaranth_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> PROMENADE_CHERRY_OAK_PLANTER_BOX = registerBlockEverycomp("af/promenade/cherry_oak_planter_box", () -> new PlanterBoxBlock(Properties.wood));
    public static final Supplier<Block> PROMENADE_PALM_PLANTER_BOX = registerBlockEverycomp("af/promenade/palm_planter_box", () -> new PlanterBoxBlock(Properties.wood));

    // Curtain
    public static final Supplier<Block> WHITE_CURTAIN = registerBlock("white_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> ORANGE_CURTAIN = registerBlock("orange_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> MAGENTA_CURTAIN = registerBlock("magenta_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> LIGHT_BLUE_CURTAIN = registerBlock("light_blue_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> YELLOW_CURTAIN = registerBlock("yellow_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> LIME_CURTAIN = registerBlock("lime_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> PINK_CURTAIN = registerBlock("pink_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> GRAY_CURTAIN = registerBlock("gray_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> LIGHT_GRAY_CURTAIN = registerBlock("light_gray_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> CYAN_CURTAIN = registerBlock("cyan_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> PURPLE_CURTAIN = registerBlock("purple_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> BLUE_CURTAIN = registerBlock("blue_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> BROWN_CURTAIN = registerBlock("brown_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> GREEN_CURTAIN = registerBlock("green_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> RED_CURTAIN = registerBlock("red_curtain", () -> new CurtainBlock(Properties.curtain));
    public static final Supplier<Block> BLACK_CURTAIN = registerBlock("black_curtain", () -> new CurtainBlock(Properties.curtain));

    // Bell
    public static final Supplier<Block> SERVICE_BELL = registerBlock("service_bell", () -> new ServiceBellBlock(Properties.service_bell));

    // Version 3
    //Bench
    public static final Supplier<Block> OAK_BENCH = registerBlock("oak_bench", () -> new BenchBlock(Properties.wood));
    public static final Supplier<Block> SPRUCE_BENCH = registerBlock("spruce_bench", () -> new BenchBlock(Properties.wood));
    public static final Supplier<Block> BIRCH_BENCH = registerBlock("birch_bench", () -> new BenchBlock(Properties.wood));
    public static final Supplier<Block> JUNGLE_BENCH = registerBlock("jungle_bench", () -> new BenchBlock(Properties.wood));
    public static final Supplier<Block> ACACIA_BENCH = registerBlock("acacia_bench", () -> new BenchBlock(Properties.wood));
    public static final Supplier<Block> DARK_OAK_BENCH = registerBlock("dark_oak_bench", () -> new BenchBlock(Properties.wood));
    public static final Supplier<Block> MANGROVE_BENCH = registerBlock("mangrove_bench", () -> new BenchBlock(Properties.wood));
    public static final Supplier<Block> CRIMSON_BENCH = registerBlock("crimson_bench", () -> new BenchBlock(Properties.nether_wood));
    public static final Supplier<Block> WARPED_BENCH = registerBlock("warped_bench", () -> new BenchBlock(Properties.nether_wood));

    public static final Supplier<Block> OAK_DRAWER = registerBlock("oak_drawer", () -> new DrawerBlock(Properties.wood));
    public static final Supplier<Block> SPRUCE_DRAWER = registerBlock("spruce_drawer", () -> new DrawerBlock(Properties.wood));
    public static final Supplier<Block> BIRCH_DRAWER = registerBlock("birch_drawer", () -> new DrawerBlock(Properties.wood));
    public static final Supplier<Block> JUNGLE_DRAWER = registerBlock("jungle_drawer", () -> new DrawerBlock(Properties.wood));
    public static final Supplier<Block> ACACIA_DRAWER = registerBlock("acacia_drawer", () -> new DrawerBlock(Properties.wood));
    public static final Supplier<Block> DARK_OAK_DRAWER = registerBlock("dark_oak_drawer", () -> new DrawerBlock(Properties.wood));
    public static final Supplier<Block> MANGROVE_DRAWER = registerBlock("mangrove_drawer", () -> new DrawerBlock(Properties.wood));
    public static final Supplier<Block> CRIMSON_DRAWER = registerBlock("crimson_drawer", () -> new DrawerBlock(Properties.nether_wood));
    public static final Supplier<Block> WARPED_DRAWER = registerBlock("warped_drawer", () -> new DrawerBlock(Properties.nether_wood));

    // Lamp
    public static final Supplier<Block> WHITE_LAMP = registerBlock("white_lamp", () -> new LampBlock(DyeColor.WHITE, Properties.lamp));
    public static final Supplier<Block> ORANGE_LAMP = registerBlock("orange_lamp", () -> new LampBlock(DyeColor.ORANGE, Properties.lamp));
    public static final Supplier<Block> MAGENTA_LAMP = registerBlock("magenta_lamp", () -> new LampBlock(DyeColor.MAGENTA, Properties.lamp));
    public static final Supplier<Block> LIGHT_BLUE_LAMP = registerBlock("light_blue_lamp", () -> new LampBlock(DyeColor.LIGHT_BLUE, Properties.lamp));
    public static final Supplier<Block> YELLOW_LAMP = registerBlock("yellow_lamp", () -> new LampBlock(DyeColor.YELLOW, Properties.lamp));
    public static final Supplier<Block> LIME_LAMP = registerBlock("lime_lamp", () -> new LampBlock(DyeColor.LIME, Properties.lamp));
    public static final Supplier<Block> PINK_LAMP = registerBlock("pink_lamp", () -> new LampBlock(DyeColor.PINK, Properties.lamp));
    public static final Supplier<Block> GRAY_LAMP = registerBlock("gray_lamp", () -> new LampBlock(DyeColor.GRAY, Properties.lamp));
    public static final Supplier<Block> LIGHT_GRAY_LAMP = registerBlock("light_gray_lamp", () -> new LampBlock(DyeColor.LIGHT_GRAY, Properties.lamp));
    public static final Supplier<Block> CYAN_LAMP = registerBlock("cyan_lamp", () -> new LampBlock(DyeColor.CYAN, Properties.lamp));
    public static final Supplier<Block> PURPLE_LAMP = registerBlock("purple_lamp", () -> new LampBlock(DyeColor.PURPLE, Properties.lamp));
    public static final Supplier<Block> BLUE_LAMP = registerBlock("blue_lamp", () -> new LampBlock(DyeColor.BLUE, Properties.lamp));
    public static final Supplier<Block> BROWN_LAMP = registerBlock("brown_lamp", () -> new LampBlock(DyeColor.BROWN, Properties.lamp));
    public static final Supplier<Block> GREEN_LAMP = registerBlock("green_lamp", () -> new LampBlock(DyeColor.GREEN, Properties.lamp));
    public static final Supplier<Block> RED_LAMP = registerBlock("red_lamp", () -> new LampBlock(DyeColor.RED, Properties.lamp));
    public static final Supplier<Block> BLACK_LAMP = registerBlock("black_lamp", () -> new LampBlock(DyeColor.BLACK, Properties.lamp));
    public static final Supplier<Block> LAMP_CONNECTOR = registerBlockOnly("lamp_connector", () -> new LampConnectorBlock(Properties.wood));

    // Sofa
    public static final Supplier<Block> WHITE_SOFA = registerBlock("white_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> ORANGE_SOFA = registerBlock("orange_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> MAGENTA_SOFA = registerBlock("magenta_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> LIGHT_BLUE_SOFA = registerBlock("light_blue_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> YELLOW_SOFA = registerBlock("yellow_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> LIME_SOFA = registerBlock("lime_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> PINK_SOFA = registerBlock("pink_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> GRAY_SOFA = registerBlock("gray_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> LIGHT_GRAY_SOFA = registerBlock("light_gray_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> CYAN_SOFA = registerBlock("cyan_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> PURPLE_SOFA = registerBlock("purple_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> BLUE_SOFA = registerBlock("blue_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> BROWN_SOFA = registerBlock("brown_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> GREEN_SOFA = registerBlock("green_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> RED_SOFA = registerBlock("red_sofa", () -> new SofaBlock(Properties.weak_wood));
    public static final Supplier<Block> BLACK_SOFA = registerBlock("black_sofa", () -> new SofaBlock(Properties.weak_wood));

    // Tall Stool
    public static final Supplier<Block> WHITE_TALL_STOOL = registerBlock("white_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> ORANGE_TALL_STOOL = registerBlock("orange_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> MAGENTA_TALL_STOOL = registerBlock("magenta_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> LIGHT_BLUE_TALL_STOOL = registerBlock("light_blue_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> YELLOW_TALL_STOOL = registerBlock("yellow_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> LIME_TALL_STOOL = registerBlock("lime_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> PINK_TALL_STOOL = registerBlock("pink_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> GRAY_TALL_STOOL = registerBlock("gray_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> LIGHT_GRAY_TALL_STOOL = registerBlock("light_gray_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> CYAN_TALL_STOOL = registerBlock("cyan_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> PURPLE_TALL_STOOL = registerBlock("purple_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> BLUE_TALL_STOOL = registerBlock("blue_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> BROWN_TALL_STOOL = registerBlock("brown_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> GREEN_TALL_STOOL = registerBlock("green_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> RED_TALL_STOOL = registerBlock("red_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));
    public static final Supplier<Block> BLACK_TALL_STOOL = registerBlock("black_tall_stool", () -> new TallStoolBlock(Properties.weak_wood));

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> supplier = AFRegistry.registerBlock(name, block);
        AFRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties().tab(AnotherFurniture.TAB)));
        return supplier;
    }
    public static <T extends Block> Supplier<T> registerBlockEverycomp(String name, Supplier<T> block) {
        Supplier<T> supplier = AFRegistry.registerBlockEverycomp(name, block);
        AFRegistry.registerItemEverycomp(name, () -> new BlockItem(supplier.get(), new Item.Properties().tab(AnotherFurniture.TAB)));
        return supplier;
    }

    public static <T extends Block> Supplier<T> registerBlockHidden(String name, Supplier<T> block) {
        Supplier<T> supplier = AFRegistry.registerBlock(name, block);
        AFRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties()));
        return supplier;
    }

    public static <T extends Block> Supplier<T> registerBlockOnly(String name, Supplier<T> block) {
        return AFRegistry.registerBlock(name, block);
    }

    public static void registerFlammables() {
        AFRegistry.setFlammable(OAK_CHAIR, 5, 20);
        AFRegistry.setFlammable(SPRUCE_CHAIR, 5, 20);
        AFRegistry.setFlammable(BIRCH_CHAIR, 5, 20);
        AFRegistry.setFlammable(JUNGLE_CHAIR, 5, 20);
        AFRegistry.setFlammable(ACACIA_CHAIR, 5, 20);
        AFRegistry.setFlammable(DARK_OAK_CHAIR, 5, 20);
        AFRegistry.setFlammable(MANGROVE_CHAIR, 5, 20);

        AFRegistry.setFlammable(OAK_SHELF, 5, 20);
        AFRegistry.setFlammable(SPRUCE_SHELF, 5, 20);
        AFRegistry.setFlammable(BIRCH_SHELF, 5, 20);
        AFRegistry.setFlammable(JUNGLE_SHELF, 5, 20);
        AFRegistry.setFlammable(ACACIA_SHELF, 5, 20);
        AFRegistry.setFlammable(DARK_OAK_SHELF, 5, 20);
        AFRegistry.setFlammable(MANGROVE_SHELF, 5, 20);

        AFRegistry.setFlammable(OAK_TABLE, 5, 20);
        AFRegistry.setFlammable(SPRUCE_TABLE, 5, 20);
        AFRegistry.setFlammable(BIRCH_TABLE, 5, 20);
        AFRegistry.setFlammable(JUNGLE_TABLE, 5, 20);
        AFRegistry.setFlammable(ACACIA_TABLE, 5, 20);
        AFRegistry.setFlammable(DARK_OAK_TABLE, 5, 20);
        AFRegistry.setFlammable(MANGROVE_TABLE, 5, 20);

        AFRegistry.setFlammable(OAK_SHUTTER, 5, 20);
        AFRegistry.setFlammable(SPRUCE_SHUTTER, 5, 20);
        AFRegistry.setFlammable(BIRCH_SHUTTER, 5, 20);
        AFRegistry.setFlammable(JUNGLE_SHUTTER, 5, 20);
        AFRegistry.setFlammable(ACACIA_SHUTTER, 5, 20);
        AFRegistry.setFlammable(DARK_OAK_SHUTTER, 5, 20);
        AFRegistry.setFlammable(MANGROVE_SHUTTER, 5, 20);

        AFRegistry.setFlammable(OAK_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(SPRUCE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BIRCH_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(JUNGLE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(ACACIA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(DARK_OAK_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(MANGROVE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(ECOLOGICS_FLOWERING_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(ECOLOGICS_AZALEA_PLANTER_BOX,5,20);
        AFRegistry.setFlammable(ECOLOGICS_WALNUT_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(ECOLOGICS_COCONUT_PLANTER_BOX,5,20);
        AFRegistry.setFlammable(BETTERNETHER_NETHER_REED_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_STALAGNATE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_WILLOW_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_WART_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_RUBEUS_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_MUSHROOM_FIR_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_NETHER_MUSHROOM_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_ANCHOR_TREE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTERNETHER_NETHER_SAKURA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(ARCHITECTS_PALETTE_TWISTED_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_MOSSY_GLOWSHROOM_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_PYTHADENDRON_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_END_LOTUS_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_LACUGROVE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_DRAGON_TREE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_TENANEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_HELIX_TREE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_UMBRELLA_TREE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_JELLYSHROOM_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BETTEREND_LUCERNIA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BLOCKUS_WHITE_OAK_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BLOCKUS_LEGACY_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_ASPEN_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_BAOBAB_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_BLUE_ENCHANTED_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_BULBIS_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_CHERRY_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_CIKA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_CYPRESS_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_EBONY_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_ETHER_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_FIR_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_GREEN_ENCHANTED_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_HOLLY_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_IMPARIUS_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_LAMENT_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_JACARANDA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_MAHOGANY_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_WHITE_MANGROVE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_MAPLE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_NIGHTSHADE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_PALM_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_PINE_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_RAINBOW_EUCALYPTUS_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_REDWOOD_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_SKYRIS_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_WILLOW_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_WITCH_HAZEL_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_ZELKOVA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(BYG_SYTHIAN_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(CHARM_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(CHARM_EBONY_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(COLORFULAZALEAS_TECAL_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(COLORFULAZALEAS_FISS_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(COLORFULAZALEAS_ROZE_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(COLORFULAZALEAS_AZULE_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(COLORFULAZALEAS_BRIGHT_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(COLORFULAZALEAS_WALNUT_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(COLORFULAZALEAS_TITANIUM_AZALEA_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(VINERY_CHERRY_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(ENDERSCAPE_CELESTIAL_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(PROMENADE_DARK_AMARANTH_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(PROMENADE_CHERRY_OAK_PLANTER_BOX, 5, 20);
        AFRegistry.setFlammable(PROMENADE_PALM_PLANTER_BOX, 5, 20);

        AFRegistry.setFlammable(WHITE_STOOL, 5, 20);
        AFRegistry.setFlammable(ORANGE_STOOL, 5, 20);
        AFRegistry.setFlammable(MAGENTA_STOOL, 5, 20);
        AFRegistry.setFlammable(LIGHT_BLUE_STOOL, 5, 20);
        AFRegistry.setFlammable(YELLOW_STOOL, 5, 20);
        AFRegistry.setFlammable(LIME_STOOL, 5, 20);
        AFRegistry.setFlammable(PINK_STOOL, 5, 20);
        AFRegistry.setFlammable(GRAY_STOOL, 5, 20);
        AFRegistry.setFlammable(LIGHT_GRAY_STOOL, 5, 20);
        AFRegistry.setFlammable(CYAN_STOOL, 5, 20);
        AFRegistry.setFlammable(PURPLE_STOOL, 5, 20);
        AFRegistry.setFlammable(BLUE_STOOL, 5, 20);
        AFRegistry.setFlammable(BROWN_STOOL, 5, 20);
        AFRegistry.setFlammable(GREEN_STOOL, 5, 20);
        AFRegistry.setFlammable(RED_STOOL, 5, 20);
        AFRegistry.setFlammable(BLACK_STOOL, 5, 20);

        AFRegistry.setFlammable(WHITE_CURTAIN, 5, 20);
        AFRegistry.setFlammable(ORANGE_CURTAIN, 5, 20);
        AFRegistry.setFlammable(MAGENTA_CURTAIN, 5, 20);
        AFRegistry.setFlammable(LIGHT_BLUE_CURTAIN, 5, 20);
        AFRegistry.setFlammable(YELLOW_CURTAIN, 5, 20);
        AFRegistry.setFlammable(LIME_CURTAIN, 5, 20);
        AFRegistry.setFlammable(PINK_CURTAIN, 5, 20);
        AFRegistry.setFlammable(GRAY_CURTAIN, 5, 20);
        AFRegistry.setFlammable(LIGHT_GRAY_CURTAIN, 5, 20);
        AFRegistry.setFlammable(CYAN_CURTAIN, 5, 20);
        AFRegistry.setFlammable(PURPLE_CURTAIN, 5, 20);
        AFRegistry.setFlammable(BLUE_CURTAIN, 5, 20);
        AFRegistry.setFlammable(BROWN_CURTAIN, 5, 20);
        AFRegistry.setFlammable(GREEN_CURTAIN, 5, 20);
        AFRegistry.setFlammable(RED_CURTAIN, 5, 20);
        AFRegistry.setFlammable(BLACK_CURTAIN, 5, 20);

        AFRegistry.setFlammable(OAK_BENCH, 5, 20);
        AFRegistry.setFlammable(SPRUCE_BENCH, 5, 20);
        AFRegistry.setFlammable(BIRCH_BENCH, 5, 20);
        AFRegistry.setFlammable(JUNGLE_BENCH, 5, 20);
        AFRegistry.setFlammable(ACACIA_BENCH, 5, 20);
        AFRegistry.setFlammable(DARK_OAK_BENCH, 5, 20);
        AFRegistry.setFlammable(MANGROVE_BENCH, 5, 20);

        AFRegistry.setFlammable(OAK_DRAWER, 5, 20);
        AFRegistry.setFlammable(SPRUCE_DRAWER, 5, 20);
        AFRegistry.setFlammable(BIRCH_DRAWER, 5, 20);
        AFRegistry.setFlammable(JUNGLE_DRAWER, 5, 20);
        AFRegistry.setFlammable(ACACIA_DRAWER, 5, 20);
        AFRegistry.setFlammable(DARK_OAK_DRAWER, 5, 20);
        AFRegistry.setFlammable(MANGROVE_DRAWER, 5, 20);

        AFRegistry.setFlammable(WHITE_LAMP, 5, 20);
        AFRegistry.setFlammable(ORANGE_LAMP, 5, 20);
        AFRegistry.setFlammable(MAGENTA_LAMP, 5, 20);
        AFRegistry.setFlammable(LIGHT_BLUE_LAMP, 5, 20);
        AFRegistry.setFlammable(YELLOW_LAMP, 5, 20);
        AFRegistry.setFlammable(LIME_LAMP, 5, 20);
        AFRegistry.setFlammable(PINK_LAMP, 5, 20);
        AFRegistry.setFlammable(GRAY_LAMP, 5, 20);
        AFRegistry.setFlammable(LIGHT_GRAY_LAMP, 5, 20);
        AFRegistry.setFlammable(CYAN_LAMP, 5, 20);
        AFRegistry.setFlammable(PURPLE_LAMP, 5, 20);
        AFRegistry.setFlammable(BLUE_LAMP, 5, 20);
        AFRegistry.setFlammable(BROWN_LAMP, 5, 20);
        AFRegistry.setFlammable(GREEN_LAMP, 5, 20);
        AFRegistry.setFlammable(RED_LAMP, 5, 20);
        AFRegistry.setFlammable(BLACK_LAMP, 5, 20);
        AFRegistry.setFlammable(LAMP_CONNECTOR, 5, 20);

        AFRegistry.setFlammable(WHITE_SOFA, 5, 20);
        AFRegistry.setFlammable(ORANGE_SOFA, 5, 20);
        AFRegistry.setFlammable(MAGENTA_SOFA, 5, 20);
        AFRegistry.setFlammable(LIGHT_BLUE_SOFA, 5, 20);
        AFRegistry.setFlammable(YELLOW_SOFA, 5, 20);
        AFRegistry.setFlammable(LIME_SOFA, 5, 20);
        AFRegistry.setFlammable(PINK_SOFA, 5, 20);
        AFRegistry.setFlammable(GRAY_SOFA, 5, 20);
        AFRegistry.setFlammable(LIGHT_GRAY_SOFA, 5, 20);
        AFRegistry.setFlammable(CYAN_SOFA, 5, 20);
        AFRegistry.setFlammable(PURPLE_SOFA, 5, 20);
        AFRegistry.setFlammable(BLUE_SOFA, 5, 20);
        AFRegistry.setFlammable(BROWN_SOFA, 5, 20);
        AFRegistry.setFlammable(GREEN_SOFA, 5, 20);
        AFRegistry.setFlammable(RED_SOFA, 5, 20);
        AFRegistry.setFlammable(BLACK_SOFA, 5, 20);

        AFRegistry.setFlammable(WHITE_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(ORANGE_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(MAGENTA_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(LIGHT_BLUE_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(YELLOW_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(LIME_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(PINK_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(GRAY_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(LIGHT_GRAY_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(CYAN_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(PURPLE_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(BLUE_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(BROWN_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(GREEN_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(RED_TALL_STOOL, 5, 20);
        AFRegistry.setFlammable(BLACK_TALL_STOOL, 5, 20);
    }

    public static void init() {}
}
