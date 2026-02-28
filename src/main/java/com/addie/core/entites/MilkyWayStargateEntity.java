package com.addie.core.entites;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

import java.util.Collections;

public class MilkyWayStargateEntity extends LivingEntity {

    private String[] standardAddress = new String[7];

    public MilkyWayStargateEntity(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
        for (int i = 0; i < 7; i++) {
            standardAddress[i] = "";
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        // You could also use DataTracker here for syncing to clients
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

        if (nbt.contains("StandardAddress", NbtElement.LIST_TYPE)) {
            NbtList addressList = nbt.getList("StandardAddress", NbtElement.STRING_TYPE);
            for (int i = 0; i < Math.min(7, addressList.size()); i++) {
                standardAddress[i] = addressList.getString(i);
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);

        nbt.putFloat("Yaw", this.getYaw());
        nbt.putFloat("Pitch", this.getPitch());

        // Write the address to NBT
        NbtList addressList = new NbtList();
        for (int i = 0; i < 7; i++) {
            if (standardAddress[i] != null) {
                addressList.add(NbtString.of(standardAddress[i]));
            } else {
                addressList.add(NbtString.of(""));
            }
        }
        nbt.put("StandardAddress", addressList);
    }

    public String[] getStandardAddress() {
        return standardAddress;
    }

    public void setStandardAddress(String[] address) {
        if (address.length == 7) {
            this.standardAddress = address;
        }
    }

    public void setStandardAddressChar(int index, String character) {
        if (index >= 0 && index < 7) {
            this.standardAddress[index] = character;
        }
    }

    public String getStandardAddressString() {
        StringBuilder sb = new StringBuilder();
        for (String s : standardAddress) {
            sb.append(s);
        }
        return sb.toString();
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