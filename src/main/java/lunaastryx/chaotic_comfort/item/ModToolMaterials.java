package lunaastryx.chaotic_comfort.item;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
        ELECTRIC_GUITAR(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2467, 9.0F, 8.0F, 17,
                () -> Ingredient.ofItems(Blocks.OAK_PLANKS, Blocks.CHERRY_PLANKS, Blocks.ACACIA_PLANKS, Blocks.BIRCH_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.BAMBOO_PLANKS, Blocks.JUNGLE_PLANKS)),

        BAGUETTE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 6720, 6.7f, 7f, 19, () -> Ingredient.ofItems(Items.BREAD));

        private final TagKey<Block> inverseTag;
        private final int itemDurability;
        private final float miningSpeed;
        private final float attackDamage;
        private final int enchantability;
        private final Supplier<Ingredient> repairIngredient;

        private ModToolMaterials(
                final TagKey<Block> inverseTag,
                final int itemDurability,
                final float miningSpeed,
                final float attackDamage,
                final int enchantability,
                final Supplier<Ingredient> repairIngredient
        ) {
            this.inverseTag = inverseTag;
            this.itemDurability = itemDurability;
            this.miningSpeed = miningSpeed;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairIngredient = Suppliers.memoize(repairIngredient::get);
        }

        @Override
        public int getDurability() {
            return this.itemDurability;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return this.miningSpeed;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return this.inverseTag;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return (Ingredient)this.repairIngredient.get();
        }
    }