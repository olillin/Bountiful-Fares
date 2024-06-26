package net.hecco.bountifulfares.util;

import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.item.ModItems;
import net.hecco.bountifulfares.potion.ModPotions;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

import static net.fabricmc.fabric.api.registry.StrippableBlockRegistry.register;
import static net.hecco.bountifulfares.mixin.BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe;
import static net.minecraft.block.ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE;

public class ModRegistries {
    public static void RegisterModStuffs() {
        registerStrippables();
        registerModCompostables();
        registerPotionRecipes();
        registerFermentationRecipes();
        DispenserBlock.registerBehavior(ModItems.FLOUR, new FlourDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return new FlourProjectileEntity(world, position.getX(), position.getY(), position.getZ());
            }
        });
        DispenserBlock.registerBehavior(ModItems.GRASS_SEEDS, new GrassSeedsDispenserBehavior() {
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                return super.dispenseSilently(pointer, stack);
            }
        });
    }

    public static void registerFermentationRecipes() {
        FermentationRecipes.addRecipe(ModItems.ELDERBERRIES, null, ModItems.ELDERBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(ModItems.LAPISBERRIES, null, ModItems.LAPISBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(Items.HONEY_BOTTLE, Items.GLASS_BOTTLE, ModItems.MEAD_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(Items.APPLE, null, ModItems.APPLE_CIDER_JAR, ModItems.JAR, null);
        FermentationRecipes.addRecipe(ModItems.PLUM, null, ModItems.PLUM_CIDER_JAR, ModItems.JAR, null);
        FermentationRecipes.addRecipe(ModItems.HOARY_APPLE, null, ModItems.HOARY_CIDER_JAR, ModItems.JAR, null);
        FermentationRecipes.addRecipe(ModItems.ORANGE, null, ModItems.CITRUS_ESSENCE, null, 4);
        FermentationRecipes.addRecipe(ModItems.LEMON, null, ModItems.CITRUS_ESSENCE, null, 4);
        FermentationRecipes.addRecipe(Items.SPIDER_EYE, null, Items.FERMENTED_SPIDER_EYE, null, null);
    }

    public static void registerStrippables() {
        register(ModBlocks.APPLE_LOG, ModBlocks.STRIPPED_APPLE_LOG);
        register(ModBlocks.APPLE_WOOD, ModBlocks.STRIPPED_APPLE_WOOD);
        register(ModBlocks.ORANGE_LOG, ModBlocks.STRIPPED_ORANGE_LOG);
        register(ModBlocks.ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_WOOD);
        register(ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG);
        register(ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD);
        register(ModBlocks.PLUM_LOG, ModBlocks.STRIPPED_PLUM_LOG);
        register(ModBlocks.PLUM_WOOD, ModBlocks.STRIPPED_PLUM_WOOD);
        register(ModBlocks.HOARY_LOG, ModBlocks.STRIPPED_HOARY_LOG);
        register(ModBlocks.HOARY_WOOD, ModBlocks.STRIPPED_HOARY_WOOD);
        register(ModBlocks.WALNUT_LOG, ModBlocks.STRIPPED_WALNUT_LOG);
        register(ModBlocks.WALNUT_WOOD, ModBlocks.STRIPPED_WALNUT_WOOD);
    }

    private static void registerModCompostables() {
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.APPLE_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_APPLE_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.APPLE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.APPLE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_ORANGE_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.ORANGE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LEMON_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_LEMON_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LEMON_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LEMON_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEMON, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.PLUM_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_PLUM_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.PLUM_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.PLUM_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.PLUM, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HOARY_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HOARY_LEAVES.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HOARY_APPLE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HOARY_APPLE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HOARY_APPLE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_LEAVES.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WALNUT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_MULCH.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_MULCH_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.PASSION_FRUIT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.ELDERBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LAPISBERRY_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LAPISBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_WHEAT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_POTATOES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_CARROTS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_BEETROOTS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_MAIZE, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_LEEKS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRASS_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MAIZE_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MAIZE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEEK_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEEK, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.FLOUR, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SPONGEKIN_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.SPONGEKIN.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SPONGEKIN_SLICE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TEA_BERRIES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TEA_LEAVES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.DRIED_TEA_LEAVES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CHAMOMILE_FLOWERS.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HONEYSUCKLE.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.VIOLET_BELLFLOWER.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GREEN_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BLACK_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CHAMOMILE_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HONEYSUCKLE_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BELLFLOWER_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TORCHFLOWER_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MAIZE_BREAD, 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WALNUT_COOKIE, 0.85f);
    }


    private static void registerPotionRecipes() {
        invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.CITRUS_ESSENCE, ModPotions.ACIDIC);
        invokeRegisterPotionRecipe(ModPotions.ACIDIC, Items.REDSTONE, ModPotions.LONG_ACIDIC);
        invokeRegisterPotionRecipe(Potions.AWKWARD, Items.GLOWSTONE_DUST, ModPotions.STRONG_ACIDIC);
        invokeRegisterPotionRecipe(ModPotions.ACIDIC, Items.FERMENTED_SPIDER_EYE, ModPotions.STUPOR);
        invokeRegisterPotionRecipe(ModPotions.LONG_ACIDIC, Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_STUPOR);
        invokeRegisterPotionRecipe(ModPotions.STUPOR, Items.REDSTONE, ModPotions.LONG_STUPOR);
    }
}
