package club.someoneice.pineapple.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class Wolf extends Block {
    public Wolf() {
        super(Properties.of(Material.SNOW).sound(SoundType.WOOD));
    }

    public InteractionResult use(BlockState block, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide)
            world.playSound(player, pos, SoundEvents.WOLF_HOWL, SoundSource.BLOCKS, 5f, 5f);
        return super.use(block, world, pos, player, hand, hit);
    }
}
