package com.addie.client.renderers;

import com.addie.client.TheFabricStargateModClient;
import com.addie.client.models.MilyWayStargateModel;
import com.addie.core.entites.MilkyWayStargateEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class MilkyWayStargateRenderer extends EntityRenderer<MilkyWayStargateEntity> {

    private static final Identifier TEXTURE =
            new Identifier("the-fabric-stargate-mod", "textures/entity/gates/milky_way.png");

    private static final Identifier GLYPH_FONT =
            new Identifier("the-fabric-stargate-mod", "stargate_glyphs");

    private static final int MILKY_WAY_GLYPH_COLOR = 0xFF1d1d26;
    private static final int MAX_GLYPHS = 36;

    private static final float RADIUS = 3f;
    private static final float GLYPH_SIZE = 0.03f;
    private static final float Y_OFFSET = -2f;
    private static final float Z_OFFSET = -0.24f;

    private static final String[] GLYPHS = {
            "7", "8", "9", "@", "(", ")", "*", ".", "/", ":", ";", "<", ">", "?",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V"
    };

    private final MilyWayStargateModel model;
    private final TextRenderer textRenderer;

    public MilkyWayStargateRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new MilyWayStargateModel(
                ctx.getPart(TheFabricStargateModClient.MILKY_WAY_STARGATE_LAYER)
        );
        this.textRenderer = MinecraftClient.getInstance().textRenderer;
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

        matrices.push();
        renderGlyphs(matrices, vertexConsumers, light, entity);
        matrices.pop();

        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    private void renderGlyphs(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            MilkyWayStargateEntity entity
    ) {
        matrices.translate(0, Y_OFFSET, Z_OFFSET);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90f));

        int skyLight = (light >> 20) & 0xF;

        int glyphLight;
        if (skyLight >= 15) {
            glyphLight = LightmapTextureManager.MAX_LIGHT_COORDINATE;
        } else {
            glyphLight = 0;
        }



        for (int i = 0; i < MAX_GLYPHS; i++) {
            matrices.push();

            float angle = (float) (2 * Math.PI * i) / MAX_GLYPHS;

            float x = (float) (Math.sin(angle) * RADIUS);
            float z = (float) (Math.cos(angle) * RADIUS);

            matrices.translate(x, 0, z);

            float centerAngle = (float) Math.toDegrees(Math.atan2(x, z));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(centerAngle));

            matrices.scale(GLYPH_SIZE, GLYPH_SIZE, GLYPH_SIZE);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90f));

            Text glyphText = Text.literal(GLYPHS[i])
                    .setStyle(Style.EMPTY.withFont(GLYPH_FONT));

            float textWidth = textRenderer.getWidth(glyphText);
            float textHeight = textRenderer.fontHeight;

            textRenderer.draw(
                    glyphText,
                    -textWidth / 2f,
                    -textHeight / 2f,
                    MILKY_WAY_GLYPH_COLOR,
                    false,
                    matrices.peek().getPositionMatrix(),
                    vertexConsumers,
                    TextRenderer.TextLayerType.NORMAL,
                    0,
                    glyphLight
            );

            matrices.pop();
        }
    }
}