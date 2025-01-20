package net.max_di.rtw.common.events;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper.GingerbreadCreeperEntity;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_man.GingerbreadManEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;


@EventBusSubscriber(modid = RTW.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GINGERBREAD_MAN_ENTITY.get(), GingerbreadManEntity.createAttributes().build());
        event.put(ModEntities.GINGERBREAD_CREEPER_ENTITY.get(), GingerbreadCreeperEntity.createAttributes().build());
    }
}