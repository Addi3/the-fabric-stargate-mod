package com.addie.client.renderers;

import com.addie.client.TheFabricStargateModClient;
import com.addie.client.models.MilyWayStargateModel;
import com.addie.core.entites.MilkyWayStargateEntity;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class MilkyWayStargateRenderer extends EntityRenderer<MilkyWayStargateEntity> {

    private static final Identifier TEXTURE =
            new Identifier("the-fabric-stargate-mod", "textures/entity/gates/milky_way.png");

    private static final Identifier GLYPH_FONT =
            new Identifier("the-fabric-stargate-mod", "stargate_glyphs");

    private static final int GLYPH_COLOR = 0xFF2C2E3B;

    private static final String[] GLYPHS = {
            "7", "8", "9", "@", "(", ")", "*", ".", "/", ":", ";", "<", ">", "?",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V"
    };

    private static final float RADIUS = 2.9f;
    private static final float GLYPH_SIZE = 0.03f;
    private static final float YAW_OFFSET = 180f;
    private static final float PITCH_OFFSET = 90f;

    private static final float BASE_X_ROTATION = 90f;
    private static final float BASE_Z_ROTATION = 180f;

    private final MilyWayStargateModel model;
    private final TextRenderer textRenderer;

    public MilkyWayStargateRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new MilyWayStargateModel(
                ctx.getPart(TheFabricStargateModClient.MILKY_WAY_STARGATE_LAYER)
        );
        this.textRenderer = ctx.getTextRenderer();
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

        float entityYaw = entity.getYaw();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entityYaw));

        VertexConsumer vertexConsumer =
                vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE));

        model.render(
                matrices,
                vertexConsumer,
                light,
                OverlayTexture.DEFAULT_UV,
                1f, 1f, 1f, 1f
        );

        renderGlyphs(matrices, vertexConsumers, light);

        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    private void renderGlyphs(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light
    ) {
        matrices.push();

        matrices.translate(0, -2, -0.25);

        if (YAW_OFFSET != 0) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(YAW_OFFSET));
        }

        if (PITCH_OFFSET != 0) {
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(PITCH_OFFSET));
        }

        for (int i = 0; i < GLYPHS.length; i++) {
            matrices.push();

            float angle = i * 10f;
            double rad = Math.toRadians(angle);

            float x = (float)(Math.sin(rad) * RADIUS);
            float z = (float)(Math.cos(rad) * RADIUS);

            matrices.translate(x, 0, z);

            float outwardAngle = (float) Math.toDegrees(Math.atan2(x, z));

            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(outwardAngle));

            if (BASE_X_ROTATION != 0) {
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(BASE_X_ROTATION));
            }
            if (BASE_Z_ROTATION != 0) {
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(BASE_Z_ROTATION));
            }


            matrices.scale(GLYPH_SIZE, GLYPH_SIZE, GLYPH_SIZE);

            Text glyphText = Text.literal(GLYPHS[i]).styled(style ->
                    style.withFont(GLYPH_FONT)
            );

            float textWidth = textRenderer.getWidth(glyphText);
            float textHeight = textRenderer.fontHeight;

            textRenderer.draw(
                    glyphText,
                    -textWidth / 2f,
                    -textHeight / 2f,
                    GLYPH_COLOR,
                    false,
                    matrices.peek().getPositionMatrix(),
                    vertexConsumers,
                    TextRenderer.TextLayerType.NORMAL,
                    0,
                    light
            );

            matrices.pop();
        }

        matrices.pop();
    }
}