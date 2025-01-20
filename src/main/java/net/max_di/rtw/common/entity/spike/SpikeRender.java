package net.max_di.rtw.common.entity.spike;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.max_di.rtw.RTW;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SpikeRender extends EntityRenderer<SpikeEntity> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/spike/spike.png");
    private SpikeModel<SpikeEntity> model;

    public SpikeRender(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SpikeModel<>(pContext.bakeLayer(SpikeModel.LAYER_LOCATION));
    }

    @Override
    public void render(SpikeEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight) {
        pPoseStack.pushPose();
        this.model.setupAnim(pEntity, 0F, 0F, pEntity.tickCount + pPartialTick, 0F, 0F);
         pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.yRotO, pEntity.getYRot()) - 180));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.xRotO, pEntity.getXRot())));
        pPoseStack.translate(0, -1.4, 0);
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBufferSource, pPackedLight);
        this.model.renderToBuffer(pPoseStack, pBufferSource.getBuffer(this.model.renderType(TEXTURE)), pPackedLight, OverlayTexture.NO_OVERLAY);
        pPoseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(SpikeEntity pEntity) {
        return TEXTURE;
    }
}
