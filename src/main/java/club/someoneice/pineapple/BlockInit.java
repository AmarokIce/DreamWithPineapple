package club.someoneice.pineapple;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.block.PizzaBlock;
import club.someoneice.pineapple.block.Wolf;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PineappleMain.modid);

    /* Blocks */
    // public static final RegistryObject<Block> BACON_PIZZA = BLOCKS.register("bacon_pizza", () -> new PizzaBlock(ItemInit.BACON_PIZZA_SLICE.get()));

    public static final RegistryObject<Block> BERRIES_CAKE = BLOCKS.register("pineapple_berries_cake", () -> new CakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> POTATO_CAKE = BLOCKS.register("pineapple_potato_cake", () -> new CakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> MELON_CAKE = BLOCKS.register("pineapple_melon_cake", () -> new CakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> GLOW_CAKE = BLOCKS.register("pineapple_glow_cake", () -> new CakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> DYEDREAM_CAKE = BLOCKS.register("pineapple_dyedream_cake", () -> new CakeBlock(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.SNOW)));

    public static final RegistryObject<Block> WOLF = BLOCKS.register("wolf_block_obj", Wolf::new);

    /* Block Items */
    // public static final RegistryObject<Item> BACON_PIZZA_ITEM = ItemInit.ITEMS.register("bacon_pizza_item", () -> itemBlockItem(BACON_PIZZA.get()));
}
