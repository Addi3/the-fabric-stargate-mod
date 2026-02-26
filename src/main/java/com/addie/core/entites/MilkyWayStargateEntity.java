package com.addie.core.entites;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;

public class MilkyWayStargateEntity extends Entity {
    public MilkyWayStargateEntity(EntityType<? extends MilkyWayStargateEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker() {}

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}
}
