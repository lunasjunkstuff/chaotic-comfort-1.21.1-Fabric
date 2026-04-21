package lunaastryx.chaotic_comfort.item;

import lunaastryx.chaotic_comfort.ChaoticComfort;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item GOLDEN_NETHER_STAR = registerItem("golden_nether_star", new Item(new Item.Settings().fireproof()));

    public static final Item PUFFER_SMITHING_TEMPLATE = registerItem("puffer_smithing_template",
            SmithingTemplateItem.of(Identifier.of(ChaoticComfort.MOD_ID, "puffer"), FeatureFlags.VANILLA));

    public static final Item ELECTRIC_GUITAR = registerItem("electric_guitar",
            new AxeItem(ModToolMaterials.ELECTRIC_GUITAR, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ELECTRIC_GUITAR, 0, -2.67f)).fireproof().maxCount(1)));
    public static final Item GLITCHY_ELECTRIC_GUITAR = registerItem("glitchy_electric_guitar",
            new AxeItem(ModToolMaterials.ELECTRIC_GUITAR, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ELECTRIC_GUITAR, 0, -2.67f)).fireproof().maxCount(1)){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.chaotic_chaos.glitchy_electric_guitar.tooltip"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item BAGUETTE = registerItem("baguette",
            new SwordItem(ModToolMaterials.BAGUETTE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BAGUETTE, 0, -2.4f)).maxCount(1)));

    private static void addItemsToCombatTabGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.ELECTRIC_GUITAR);
    }

    private static void addItemsToIngredientsTabGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.GOLDEN_NETHER_STAR);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ChaoticComfort.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ChaoticComfort.LOGGER.info("Registering Mod Items for " + ChaoticComfort.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabGroup);
    }
}
