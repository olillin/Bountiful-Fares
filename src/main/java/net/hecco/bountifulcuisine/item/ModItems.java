package net.hecco.bountifulcuisine.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.effect.ModEffects;
import net.hecco.bountifulcuisine.item.custom.CitrusJuiceBottleItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.ModStatus;

public class ModItems {

    public static final Item ORANGE = registerItem("orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item LEMON = registerItem("lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item PLUM = registerItem("plum", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item PASSION_FRUIT = registerItem("passion_fruit", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0).snack().build())));
    public static final Item CITRUS_JUICE_BOTTLE = registerItem("citrus_juice_bottle", new CitrusJuiceBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).alwaysEdible().build()).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE)));
    public static final Item CITRIC_ACID = registerItem("citric_acid", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(0).saturationModifier(0).snack().alwaysEdible().statusEffect(new StatusEffectInstance(ModEffects.ACIDIC, 300, 0),1).build())));
    public static final Item CANDIED_ORANGE = registerItem("candied_orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));
    public static final Item CANDIED_LEMON = registerItem("candied_lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BountifulCuisine.LOGGER.info("Registering Mod Items for ", BountifulCuisine.MOD_ID);
    }
}
