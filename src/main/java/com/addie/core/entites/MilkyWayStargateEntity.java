package com.addie.core.entites;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

import java.util.Collections;

public class MilkyWayStargateEntity extends LivingEntity {

    public MilkyWayStargateEntity(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return Collections.emptyList();
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {}

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);

        if (nbt.contains("Yaw")) this.setYaw(nbt.getFloat("Yaw"));
        if (nbt.contains("Pitch")) this.setPitch(nbt.getFloat("Pitch"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);

        nbt.putFloat("Yaw", this.getYaw());
        nbt.putFloat("Pitch", this.getPitch());
    }

    @Override
    public boolean shouldRender(double distance) {
        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void pushAwayFrom(Entity entity) {
    }

    @Override
    public void takeKnockback(double strength, double x, double z) {
    }

    @Override
    public void addVelocity(double x, double y, double z) {
    }
}