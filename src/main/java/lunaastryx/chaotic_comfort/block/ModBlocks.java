package lunaastryx.chaotic_comfort.block;

import lunaastryx.chaotic_comfort.ChaoticComfort;
import lunaastryx.chaotic_comfort.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PALE_OAK_LEAVES = registerBlock("pale_oak_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)));

    public static final Block PALE_OAK_PLANKS = registerBlock("pale_oak_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));

    public static final Block PALE_OAK_STAIRS = registerBlock("pale_oak_stairs",
            new StairsBlock(ModBlocks.PALE_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.CHERRY_STAIRS)));
    public static final Block PALE_OAK_SLAB = registerBlock("pale_oak_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_STAIRS)));

    public static final Block PALE_OAK_BUTTON = registerBlock("pale_oak_button",
            new ButtonBlock(BlockSetType.CHERRY, 10, AbstractBlock.Settings.copy(Blocks.CHERRY_BUTTON).noCollision()));
    public static final Block PALE_OAK_PRESSURE_PLATE = registerBlock("pale_oak_pressure_plate",
            new PressurePlateBlock(BlockSetType.CHERRY, AbstractBlock.Settings.copy(Blocks.CHERRY_PRESSURE_PLATE)));

    public static final Block PALE_OAK_FENCE = registerBlock("pale_oak_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE)));
    public static final Block PALE_OAK_FENCE_GATE = registerBlock("pale_oak_fence_gate",
            new FenceGateBlock(WoodType.CHERRY, AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE_GATE)));

    public static final Block PALE_OAK_DOOR = registerBlock("pale_oak_door",
            new DoorBlock(BlockSetType.CHERRY, AbstractBlock.Settings.copy(Blocks.CHERRY_DOOR).nonOpaque()));
    public static final Block PALE_OAK_TRAPDOOR = registerBlock("pale_oak_trapdoor",
            new TrapdoorBlock(BlockSetType.CHERRY, AbstractBlock.Settings.copy(Blocks.CHERRY_TRAPDOOR).nonOpaque()));

    public static final Block PALE_OAK_LOG = registerBlock("pale_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LOG)));
    public static final Block STRIPPED_PALE_OAK_LOG = registerBlock("stripped_pale_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final Block PALE_OAK_WOOD = registerBlock("pale_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)));
    public static final Block STRIPPED_PALE_OAK_WOOD = registerBlock("stripped_pale_oak_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final Block PALE_MOSS_BLOCK = registerBlock("pale_moss_block",
            new Block(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)));
    public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.MOSS_CARPET)));

    public static final Block PURPLE_TULIP = registerBlock(
            "purple_tulip", new FlowerBlock(StatusEffects.RESISTANCE, 6.7F, AbstractBlock.Settings.copy(Blocks.WHITE_TULIP).nonOpaque()));
    public static final Block POTTED_PURPLE_TULIP = registerBlock("potted_purple_tulip",
            new FlowerPotBlock(PURPLE_TULIP, AbstractBlock.Settings.copy(Blocks.POTTED_WHITE_TULIP).nonOpaque()));

    public static final Block YELLOW_TULIP = registerBlock(
            "yellow_tulip", new FlowerBlock(StatusEffects.HASTE, 6.7F, AbstractBlock.Settings.copy(Blocks.WHITE_TULIP).nonOpaque()));
    public static final Block POTTED_YELLOW_TULIP = registerBlock("potted_yellow_tulip",
            new FlowerPotBlock(YELLOW_TULIP, AbstractBlock.Settings.copy(Blocks.POTTED_WHITE_TULIP).nonOpaque()));

    private static void addBlocksToNaturalTabGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.PURPLE_TULIP);
        entries.add(ModBlocks.YELLOW_TULIP);
        entries.add(ModBlocks.PALE_MOSS_BLOCK);
        entries.add(ModBlocks.PALE_MOSS_CARPET);
        entries.add(ModBlocks.PALE_OAK_LEAVES);
    }
    private static void addBlocksToBuildingBlocksTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.PALE_OAK_LOG);
        entries.add(ModBlocks.PALE_OAK_WOOD);
        entries.add(ModBlocks.STRIPPED_PALE_OAK_LOG);
        entries.add(ModBlocks.STRIPPED_PALE_OAK_WOOD);
        entries.add(ModBlocks.PALE_OAK_STAIRS);
        entries.add(ModBlocks.PALE_OAK_SLAB);
        entries.add(ModBlocks.PALE_OAK_FENCE);
        entries.add(ModBlocks.PALE_OAK_FENCE_GATE);
        entries.add(ModBlocks.PALE_OAK_DOOR);
        entries.add(ModBlocks.PALE_OAK_TRAPDOOR);
        entries.add(ModBlocks.PALE_OAK_PRESSURE_PLATE);
        entries.add(ModBlocks.PALE_OAK_BUTTON);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ChaoticComfort.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ChaoticComfort.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ChaoticComfort.LOGGER.info("Registering Mod Blocks for " + ChaoticComfort.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addBlocksToNaturalTabGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlocksTabItemGroup);
    }
}
