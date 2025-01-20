package net.max_di.rtw.common.events;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.entity.dynamite_stick.ThrownDynamiteStickRender;
import net.max_di.rtw.common.entity.dynamite_stick.model.QuadrupleStickModel;
import net.max_di.rtw.common.entity.dynamite_stick.model.SingleStickModel;
import net.max_di.rtw.common.entity.dynamite_stick.model.StickModel9x9;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper.GingerbreadCreeperModel;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper.GingerbreadCreeperRenderer;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_man.GingerbreadManModel;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_man.GingerbreadManRenderer;
import net.max_di.rtw.common.entity.spike.SpikeModel;
import net.max_di.rtw.common.entity.spike.SpikeRender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;


@EventBusSubscriber(modid = RTW.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.GINGERBREAD_MAN_ENTITY.get(), GingerbreadManRenderer::new);
        EntityRenderers.register(ModEntities.GINGERBREAD_CREEPER_ENTITY.get(), GingerbreadCreeperRenderer::new);
        EntityRenderers.register(ModEntities.THROWN_DYNAMITE_STICK.get(), ThrownDynamiteStickRender::new);
        EntityRenderers.register(ModEntities.SPIKE.get(), SpikeRender::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GingerbreadManModel.LAYER_LOCATION, GingerbreadManModel::createBodyLayer);
        event.registerLayerDefinition(GingerbreadCreeperModel.LAYER_LOCATION, GingerbreadCreeperModel::createBodyLayer);
        event.registerLayerDefinition(SingleStickModel.LAYER_LOCATION, SingleStickModel::createBodyLayer);
        event.registerLayerDefinition(QuadrupleStickModel.LAYER_LOCATION, QuadrupleStickModel::createBodyLayer);
        event.registerLayerDefinition(StickModel9x9.LAYER_LOCATION, StickModel9x9::createBodyLayer);
        event.registerLayerDefinition(SpikeModel.LAYER_LOCATION, SpikeModel::createBodyLayer);
    }


}