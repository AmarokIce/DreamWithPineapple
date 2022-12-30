package club.someoneice.pineapple.block;

import club.someoneice.pineapple.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PizzaBlock extends Block {
    private final Item slice;
    public PizzaBlock(Item slice) {
        super(Properties.of(Material.CAKE));
        this.slice = slice;
    }

    @Override
    public VoxelShape getShape(BlockState p_51222_, BlockGetter p_51223_, BlockPos p_51224_, CollisionContext p_51225_) {
        return Block.box(15.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D);
    }

    @Override
    public InteractionResult use(BlockState block, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getItemInHand(hand).getItem() == ItemInit.CAKE_KNIFE.get()) {
            player.addItem(new ItemStack(slice, 6));

            world.removeBlock(pos, false);
            world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            return InteractionResult.SUCCESS;
        }

        return super.use(block, world, pos, player, hand, hit);
    }
}
