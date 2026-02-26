package com.addie.client.renderers;

import com.addie.client.TheFabricStargateModClient;
import com.addie.client.models.MilyWayStargateModel;
import com.addie.core.entites.MilkyWayStargateEntity;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class MilkyWayStargateRenderer extends EntityRenderer<MilkyWayStargateEntity> {

    private static final Identifier TEXTURE =
            new Identifier("the-fabric-stargate-mod", "textures/entity/gates/milky_way.png");

    private final MilyWayStargateModel model;

    public MilkyWayStargateRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new MilyWayStargateModel(
                ctx.getPart(TheFabricStargateModClient.MILKY_WAY_STARGATE_LAYER)
        );
    }

    @Override
    public Identifier getTexture(MilkyWayStargateEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(
            MilkyWayStargateEntity entity,
            float yaw,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light
    ) {

        matrices.push();

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));

        VertexConsumer vertexConsumer =
                vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE));

        model.render(
                matrices,
                vertexConsumer,
                light,
                OverlayTexture.DEFAULT_UV,
                1f, 1f, 1f, 1f
        );

        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }
}