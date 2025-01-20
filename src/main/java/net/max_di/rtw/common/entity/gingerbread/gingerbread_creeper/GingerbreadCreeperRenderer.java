package net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.max_di.rtw.RTW;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class GingerbreadCreeperRenderer extends MobRenderer<GingerbreadCreeperEntity, GingerbreadCreeperModel<GingerbreadCreeperEntity>> {

    private static final Map<GingerbreadCreeperVariant, ResourceLocation> LOCATION_MAP =
            Util.make(Maps.newEnumMap(GingerbreadCreeperVariant.class), map
                    -> {
                map.put(GingerbreadCreeperVariant.ANGRY, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_creeper/angry.png"));
                map.put(GingerbreadCreeperVariant.BOBIK, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_creeper/bobik.png"));
                map.put(GingerbreadCreeperVariant.SAD, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_creeper/sad.png"));
                map.put(GingerbreadCreeperVariant.SILLY, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_creeper/silly.png"));
            });

    public GingerbreadCreeperRenderer(EntityRendererProvider.Context context) {
        super(context, new GingerbreadCreeperModel<>(context.bakeLayer(GingerbreadCreeperModel.LAYER_LOCATION)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(GingerbreadCreeperEntity pEntity) {
        return LOCATION_MAP.get(pEntity.getVariant());
    }

    @Override
    public void render(GingerbreadCreeperEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}