package com.addie.core.entites;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class MilkyWayStargateEntity extends Entity {

    public MilkyWayStargateEntity(EntityType<? extends MilkyWayStargateEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker() {
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Yaw")) this.setYaw(nbt.getFloat("Yaw"));
        if (nbt.contains("Pitch")) this.setPitch(nbt.getFloat("Pitch"));
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putFloat("Yaw", this.getYaw());
        nbt.putFloat("Pitch", this.getPitch());
        nbt.putUuid("UUID", this.getUuid());
    }

    @Override
    public boolean shouldRender(double distance) {
        return true;
    }
}