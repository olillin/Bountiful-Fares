package net.hecco.bountifulcuisine.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;

public class ChamomileFlowersBlock extends FlowerbedBlock implements Fertilizable {
    public ChamomileFlowersBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.down()).isOf(Blocks.FARMLAND.getDefaultState().with(FarmlandBlock.MOISTURE, 7).getBlock());
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = state.get(FLOWER_AMOUNT);
        if (i < 4 || world.getBlockState(pos.down()).isOf(Blocks.FARMLAND)) {
            world.setBlockState(pos, state.with(FLOWER_AMOUNT, i + 1), Block.NOTIFY_LISTENERS);
        }
    }
}
