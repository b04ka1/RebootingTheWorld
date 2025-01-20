package net.max_di.rtw.common.entity.dynamite_stick;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.dynamite_stick.model.QuadrupleStickModel;
import net.max_di.rtw.common.entity.dynamite_stick.model.SingleStickModel;
import net.max_di.rtw.common.entity.dynamite_stick.model.StickModel9x9;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


public class ThrownDynamiteStickRender extends EntityRenderer<ThrownDynamiteStickEntity> {
    private final Map<ThrownDynamiteStickVariant, EntityModel<ThrownDynamiteStickEntity>> MODEL_MAP;
    private static final Map<ThrownDynamiteStickVariant, ResourceLocation> TEXTURE_MAP =
            Util.make(Maps.newEnumMap(ThrownDynamiteStickVariant.class), map -> {
                map.put(ThrownDynamiteStickVariant.SINGLE, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/dynamite_stick/1x1.png"));
                map.put(ThrownDynamiteStickVariant.SINGLE_SPIKY, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/dynamite_stick/1x1_spiky.png"));
                map.put(ThrownDynamiteStickVariant.QUADRUPLE, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/dynamite_stick/4x4.png"));
                map.put(ThrownDynamiteStickVariant.QUADRUPLE_SPIKY, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/dynamite_stick/4x4_spiky.png"));
                map.put(ThrownDynamiteStickVariant.NINE_BY_NINE, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/dynamite_stick/9x9.png"));
                map.put(ThrownDynamiteStickVariant.NINE_BY_NINE_SPIKY, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/dynamite_stick/9x9_spiky.png"));
            });

    public ThrownDynamiteStickRender(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.MODEL_MAP =
                Util.make(Maps.newEnumMap(ThrownDynamiteStickVariant.class), map -> {
                    map.put(ThrownDynamiteStickVariant.SINGLE, new SingleStickModel<>(pContext.bakeLayer(SingleStickModel.LAYER_LOCATION)));
                    map.put(ThrownDynamiteStickVariant.SINGLE_SPIKY, new SingleStickModel<>(pContext.bakeLayer(SingleStickModel.LAYER_LOCATION)));
                    map.put(ThrownDynamiteStickVariant.QUADRUPLE, new QuadrupleStickModel<>(pContext.bakeLayer(QuadrupleStickModel.LAYER_LOCATION)));
                    map.put(ThrownDynamiteStickVariant.QUADRUPLE_SPIKY, new QuadrupleStickModel<>(pContext.bakeLayer(QuadrupleStickModel.LAYER_LOCATION)));
                    map.put(ThrownDynamiteStickVariant.NINE_BY_NINE, new StickModel9x9<>(pContext.bakeLayer(StickModel9x9.LAYER_LOCATION)));
                    map.put(ThrownDynamiteStickVariant.NINE_BY_NINE_SPIKY, new StickModel9x9<>(pContext.bakeLayer(StickModel9x9.LAYER_LOCATION)));
                });
    }

    @Override
    public void render(ThrownDynamiteStickEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight) {
        EntityModel<ThrownDynamiteStickEntity> model = getModel(pEntity);
        pPoseStack.pushPose();
        model.setupAnim(pEntity, 0.0F, 0.0F, (float) pEntity.tickCount + pPartialTick, 0.0F, 0.0F);
        pPoseStack.translate(0, -0.5, 0);
        model.renderToBuffer(pPoseStack, pBufferSource.getBuffer(model.renderType(getTextureLocation(pEntity))), pPackedLight, OverlayTexture.NO_OVERLAY);
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBufferSource, pPackedLight);
        pPoseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownDynamiteStickEntity pEntity) {
        return TEXTURE_MAP.get(pEntity.getStickVariant());
    }

    private EntityModel<ThrownDynamiteStickEntity> getModel(ThrownDynamiteStickEntity pEntity) {
        return MODEL_MAP.get(pEntity.getStickVariant());
    }
}
