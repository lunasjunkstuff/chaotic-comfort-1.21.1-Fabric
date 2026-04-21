package lunaastryx.chaotic_comfort.datagen;

import lunaastryx.chaotic_comfort.block.ModBlocks;
import lunaastryx.chaotic_comfort.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool palepool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PALE_OAK_PLANKS);

        palepool.stairs(ModBlocks.PALE_OAK_STAIRS);
        palepool.button(ModBlocks.PALE_OAK_BUTTON);
        palepool.pressurePlate(ModBlocks.PALE_OAK_PRESSURE_PLATE);
        palepool.fenceGate(ModBlocks.PALE_OAK_FENCE_GATE);
        palepool.fence(ModBlocks.PALE_OAK_FENCE);
        palepool.slab(ModBlocks.PALE_OAK_SLAB);

        blockStateModelGenerator.registerDoor(ModBlocks.PALE_OAK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PALE_OAK_TRAPDOOR);

        blockStateModelGenerator.registerSingleton(ModBlocks.PALE_OAK_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.registerLog(ModBlocks.PALE_OAK_LOG).log(ModBlocks.PALE_OAK_LOG).wood(ModBlocks.PALE_OAK_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PALE_OAK_LOG).log(ModBlocks.STRIPPED_PALE_OAK_LOG).wood(ModBlocks.STRIPPED_PALE_OAK_WOOD);

        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.PALE_MOSS_BLOCK, ModBlocks.PALE_MOSS_CARPET);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PURPLE_TULIP, ModBlocks.POTTED_PURPLE_TULIP, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.YELLOW_TULIP, ModBlocks.POTTED_YELLOW_TULIP, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GOLDEN_NETHER_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUFFER_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELECTRIC_GUITAR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLITCHY_ELECTRIC_GUITAR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BAGUETTE, Models.HANDHELD);
    }
}
