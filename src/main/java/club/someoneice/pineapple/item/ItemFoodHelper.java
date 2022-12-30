package club.someoneice.pineapple.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ItemFoodHelper extends Item {
    private UseAnim use;
    private ItemStack item;
    public ItemFoodHelper(Properties properties, ItemStack item, UseAnim useAnim) {
        super(properties);
        this.use = useAnim;
        this.item = item;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return use;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack item, Level world, LivingEntity player) {
        ((Player) player).addItem(this.item);
        return super.finishUsingItem(item, world, player);
    }
}
