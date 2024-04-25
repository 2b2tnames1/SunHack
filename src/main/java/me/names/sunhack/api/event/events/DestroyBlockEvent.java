package me.names.sunhack.api.event.events;


import me.names.sunhack.api.event.GameSenseEvent;
import net.minecraft.util.math.BlockPos;

public class DestroyBlockEvent extends GameSenseEvent {

    private BlockPos blockPos;

    public DestroyBlockEvent(BlockPos blockPos) {
        super();
        this.blockPos = blockPos;
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }
}