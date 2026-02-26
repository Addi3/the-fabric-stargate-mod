package com.addie.core;

import com.addie.core.entites.MilkyWayStargateEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TheFabricStargateModEntites {

    public static final EntityType<MilkyWayStargateEntity> MILKYWAYSTARGATE =
            Registry.register(
                    Registries.ENTITY_TYPE,
                    new Identifier("the-fabric-stargate-mod", "milkyway_stargate"),
                    FabricEntityTypeBuilder
                            .create(SpawnGroup.MISC, MilkyWayStargateEntity::new)
                            .dimensions(EntityDimensions.fixed(1f, 1f))
                            .trackRangeBlocks(64)
                            .trackedUpdateRate(1)
                            .build()
            );
}