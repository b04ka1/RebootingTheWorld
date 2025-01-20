package net.max_di.rtw.common.entity;

import net.max_di.rtw.RTW;
import net.max_di.rtw.common.entity.dynamite_stick.ThrownDynamiteStickEntity;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_creeper.GingerbreadCreeperEntity;
import net.max_di.rtw.common.entity.gingerbread.gingerbread_man.GingerbreadManEntity;
import net.max_di.rtw.common.entity.spike.SpikeEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, RTW.MOD_ID);

    public static final Supplier<EntityType<GingerbreadManEntity>> GINGERBREAD_MAN_ENTITY =
            ENTITY_TYPES.register("gingerbread_man",
                    () -> EntityType.Builder.of(GingerbreadManEntity::new, MobCategory.AMBIENT)
                            .sized(0.5f, 1.2f)
                            .build(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "gingerbread_man").toString()));

    public static final Supplier<EntityType<GingerbreadCreeperEntity>> GINGERBREAD_CREEPER_ENTITY =
            ENTITY_TYPES.register("gingerbread_creeper",
                    () -> EntityType.Builder.of(GingerbreadCreeperEntity::new, MobCategory.AMBIENT)
                            .sized(0.5f, 1f)
                            .build(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "gingerbread_creeper").toString()));

    public static final Supplier<EntityType<ThrownDynamiteStickEntity>> THROWN_DYNAMITE_STICK =
            ENTITY_TYPES.register("thrown_dynamite_stick",
                    () -> EntityType.Builder.<ThrownDynamiteStickEntity>of(ThrownDynamiteStickEntity::new, MobCategory.MISC)
                            .build(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "dynamite_stick").toString()));

    public static final Supplier<EntityType<SpikeEntity>> SPIKE =
            ENTITY_TYPES.register("spike",
                    () -> EntityType.Builder.<SpikeEntity>of(SpikeEntity::new, MobCategory.MISC)
                            .sized(0.2f, 0.2f)
                            .build(ResourceLocation.fromNamespaceAndPath(RTW.MOD_ID, "spike").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}