package lunaastryx.chaotic_comfort;

import lunaastryx.chaotic_comfort.block.ModBlocks;
import lunaastryx.chaotic_comfort.item.ModItemGroups;
import lunaastryx.chaotic_comfort.item.ModItems;
import lunaastryx.chaotic_comfort.sound.ModSounds;
import lunaastryx.chaotic_comfort.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChaoticComfort implements ModInitializer {
	public static final String MOD_ID = "chaotic_comfort";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		ModSounds.registerSounds();

		ModVillagers.registerVillagers();


		StrippableBlockRegistry.register(ModBlocks.PALE_OAK_LOG, ModBlocks.STRIPPED_PALE_OAK_LOG);
		StrippableBlockRegistry.register(ModBlocks.PALE_OAK_WOOD, ModBlocks.STRIPPED_PALE_OAK_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_LOG, 5, 5 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PALE_OAK_LOG, 5, 5 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_WOOD, 5, 5 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PALE_OAK_WOOD, 5, 5 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_LEAVES, 30, 60 );

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_PLANKS, 5, 20 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_SLAB, 5, 20 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_STAIRS, 5, 20 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_FENCE, 5, 20 );
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PALE_OAK_FENCE_GATE, 5, 20 );

		TradeOfferHelper.registerVillagerOffers(ModVillagers.GUY, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(Items.TERRACOTTA, 24),
					5, 3, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(Items.RED_TERRACOTTA, 24),
					5, 3, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(Items.GREEN_TERRACOTTA, 24),
					5, 3, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(Items.YELLOW_TERRACOTTA, 24),
					5, 3, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(Items.BLUE_TERRACOTTA, 24),
					5, 3, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(Items.LIGHT_BLUE_TERRACOTTA, 24),
					5, 3, 0.075f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.GUY, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 4),
					new ItemStack(Items.BRICKS, 24),
					6, 7, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(Items.TUFF, 24),
					4, 7, 0.075f));
		});
		TradeOfferHelper.registerVillagerOffers(ModVillagers.GUY, 3, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(Items.STONE_BRICKS, 24),
					7, 7, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 4),
					new ItemStack(Items.COBBLED_DEEPSLATE, 24),
					5, 7, 0.075f));
		});
		TradeOfferHelper.registerVillagerOffers(ModVillagers.GUY, 4, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.NETHERITE_INGOT, 2),
					new ItemStack(ModItems.ELECTRIC_GUITAR, 1),
					7, 7, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.NETHERITE_SWORD, 1),
					new ItemStack(ModItems.BAGUETTE, 1),
					7, 7, 0.075f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.FLORIST, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModBlocks.PURPLE_TULIP, 8),
					7, 4, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModBlocks.YELLOW_TULIP, 8),
					7, 4, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(Blocks.ORANGE_TULIP, 8),
					7, 4, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(Blocks.RED_TULIP, 8),
					7, 4, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(Blocks.PINK_TULIP, 8),
					7, 4, 0.075f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(Blocks.WHITE_TULIP, 8),
					7, 4, 0.075f));
		});
	}
}