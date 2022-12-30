package club.someoneice.pineapple;

import club.someoneice.pineapple.item.CakeKnife;
import club.someoneice.pineapple.item.ItemFoodHelper;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pasterdream.init.PasterdreamModTabs;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PineappleMain.modid);

    /* Item Register */
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", ItemInit::itemBase);
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> itemFood(1, 0.1f));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter", () -> itemFood(1, 0.1f));

    public static final RegistryObject<Item> CAKE_KNIFE = ITEMS.register("cake_knife",  CakeKnife::new);

    public static final RegistryObject<Item> Jelly = ITEMS.register("dream_jelly", () -> itemFood(3, 0.2f));
    public static final RegistryObject<Item> FRUIT_SANDWICHES = ITEMS.register("fruit_sandwiches", () -> itemFood(6, 0.3f));
    public static final RegistryObject<Item> BACON_SANDWICHES = ITEMS.register("bacon_sandwiches", () -> itemFood(8, 0.5f));
    public static final RegistryObject<Item> EGG_SANDWICHES = ITEMS.register("egg_sandwiches", () -> itemFood(6, 0.3f));
    public static final RegistryObject<Item> Jelly_SANDWICHES = ITEMS.register("jelly_sandwiches", () -> itemFood(6, 0.3f));
    public static final RegistryObject<Item> PANCAKE = ITEMS.register("pancake", () -> itemFood(3, 0.2f));

    // public static final RegistryObject<Item> BACON_PIZZA_SLICE = ITEMS.register("bacon_pizza_slice", () -> itemFood(4, 0.2f));

    public static final RegistryObject<Item> CHEESE_SOUP = ITEMS.register("cheese_soup", () -> itemFood(9, 0.5f, false, false, false, ItemStack(Items.BOWL), UseAnim.DRINK, 1));
    public static final RegistryObject<Item> BEEF_SOUP = ITEMS.register("beef_soup", () -> itemFood(14, 0.5f, false, false, false, ItemStack(Items.BOWL), UseAnim.DRINK, 1));

    // public static final RegistryObject<Item> RAW_BACON_PIZZA_ITEM = ItemInit.ITEMS.register("raw_bacon_pizza_item", ItemInit::itemBase);
    // public static final RegistryObject<Item> BACON_PIZZA_ITEM = ItemInit.ITEMS.register("bacon_pizza_item", () -> itemBlockItem(BlockInit.BACON_PIZZA.get()));

    public static final RegistryObject<Item> BERRIES_CAKE_ITEM = ItemInit.ITEMS.register("berries_cake_item", () -> itemBlockItem(BlockInit.BERRIES_CAKE.get()));
    public static final RegistryObject<Item> POTATO_CAKE_ITEM = ItemInit.ITEMS.register("potato_cake_item", () -> itemBlockItem(BlockInit.POTATO_CAKE.get()));
    public static final RegistryObject<Item> MELON_CAKE_ITEM = ItemInit.ITEMS.register("melon_cake_item", () -> itemBlockItem(BlockInit.MELON_CAKE.get()));
    public static final RegistryObject<Item> GLOW_CAKE_ITEM = ItemInit.ITEMS.register("glow_cake_item", () -> itemBlockItem(BlockInit.GLOW_CAKE.get()));
    public static final RegistryObject<Item> DYEDREAM_CAKE_ITEM = ItemInit.ITEMS.register("dyedream_cake_item", () -> itemBlockItem(BlockInit.DYEDREAM_CAKE.get()));

    public static final RegistryObject<Item> WOLF = ItemInit.ITEMS.register("wolf_item", () -> itemBlockItem(BlockInit.WOLF.get()));

    /* Item Tools */
    private static Item itemBase() {
        return new Item(new Item.Properties().tab(PasterdreamModTabs.TAB_PASTER_TAB_2));
    }

    /* Block Tools */
    private static Item itemBlockItem(Block block) {
        return new BlockItem(block, new Item.Properties().tab(PasterdreamModTabs.TAB_PASTER_TAB_2).stacksTo(1));
    }

    private static Item itemFood(int hunger, float saturation, boolean wolf, boolean fast, boolean alwaysEat, ItemStack returnitem, UseAnim use, int maxStack) {
        Item.Properties properties = new Item.Properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();
        properties.tab(PasterdreamModTabs.TAB_PASTER_TAB_2);
        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        if (wolf) builder.meat();
        if (fast) builder.fast();
        if (alwaysEat) builder.alwaysEat();

        properties.food(builder.build());
        properties.stacksTo(maxStack);
        return new ItemFoodHelper(properties, returnitem, use);
    }

    private static Item itemFood(int hunger, float saturation, boolean wolf, boolean fast, boolean alwaysEat) {
        return itemFood(hunger, saturation, wolf, fast, alwaysEat, ItemStack(Items.AIR), UseAnim.EAT, 64);
    }

    private static Item itemFood(int hunger, float saturation) {
        return itemFood(hunger, saturation, false, false, false, ItemStack(Items.AIR), UseAnim.EAT, 64);
    }

    private static ItemStack ItemStack(Item item) {
        return new ItemStack(item);
    }
}
