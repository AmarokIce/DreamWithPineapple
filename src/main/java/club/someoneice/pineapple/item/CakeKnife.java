package club.someoneice.pineapple.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.pasterdream.init.PasterdreamModTabs;

public class CakeKnife extends SwordItem {
    public CakeKnife() {
        super(Tiers.IRON, 1, 0.3f, new Item.Properties().tab(PasterdreamModTabs.TAB_PASTER_TAB_2));
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return new ItemStack(this);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
