package com.addie.client;

import com.addie.client.models.MilyWayStargateModel;
import com.addie.client.renderers.MilkyWayStargateRenderer;
import com.addie.core.TheFabricStargateModEntites;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class TheFabricStargateModClient implements ClientModInitializer {

    public static final EntityModelLayer MILKY_WAY_STARGATE_LAYER =
            new EntityModelLayer(
                    new Identifier("the-fabric-stargate-mod", "stargate"),
                    "main"
            );

    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(
                MILKY_WAY_STARGATE_LAYER,
                MilyWayStargateModel::getTexturedModelData
        );

        EntityRendererRegistry.register(
                TheFabricStargateModEntites.MILKYWAYSTARGATE,
                (context) -> new MilkyWayStargateRenderer(context)
        );
    }
}
