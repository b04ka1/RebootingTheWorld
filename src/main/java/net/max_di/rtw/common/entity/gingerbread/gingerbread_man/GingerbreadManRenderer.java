package net.max_di.rtw.common.entity.gingerbread.gingerbread_man;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.max_di.rtw.RTW;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class GingerbreadManRenderer extends MobRenderer<GingerbreadManEntity, GingerbreadManModel<GingerbreadManEntity>> {

    private static final Map<GingerbreadManVariant, ResourceLocation> LOCATION_MAP =
            Util.make(Maps.newEnumMap(GingerbreadManVariant.class), map
                    -> {
                map.put(GingerbreadManVariant.DUMB, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/dumb.png"));
                map.put(GingerbreadManVariant.HAPPY, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/happy.png"));
                map.put(GingerbreadManVariant.LEMON, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/lemon.png"));
                map.put(GingerbreadManVariant.LYBA, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/lyba.png"));
                map.put(GingerbreadManVariant.MOSKA, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/moska.png"));
                map.put(GingerbreadManVariant.SAD, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/sad.png"));
                map.put(GingerbreadManVariant.SIGMA, ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/sigma.png"));
            });

    public GingerbreadManRenderer(EntityRendererProvider.Context context) {
        super(context, new GingerbreadManModel<>(context.bakeLayer(GingerbreadManModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GingerbreadManEntity pEntity) {
        if (!pEntity.hasStick()) {
            return LOCATION_MAP.get(pEntity.getVariant());
        } else {
            return ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "textures/entity/gingerbread_man/" + pEntity.getStick() + ".png");
        }
    }

    @Override
    public void render(GingerbreadManEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}