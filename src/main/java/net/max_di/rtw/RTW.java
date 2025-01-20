package net.max_di.rtw;

import com.mojang.logging.LogUtils;
import net.max_di.rtw.client.ModCreativeTabRW;
import net.max_di.rtw.client.gui.screens.SawmillScreen;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.effect.ModEffects;
import net.max_di.rtw.common.entity.ModEntities;
import net.max_di.rtw.common.gui.ModMenus;
import net.max_di.rtw.common.items.ModItemsRW;
import net.max_di.rtw.common.recipes.ModRecipes;
import net.max_di.rtw.common.utils.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(RTW.MOD_ID)
public class RTW {
    public static final String MOD_ID = "rtw";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RTW(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::clientSetup);
        ModEntities.register(modEventBus);
        ModRecipes.RECIPE_SERIALIZER.register(modEventBus);
        ModRecipes.RECIPE_TYPE.register(modEventBus);
        ModMenus.MENU_TYPE.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);
        ModEffects.EFFECT.register(modEventBus);
        ModCreativeTabRW.register(modEventBus);
        ModBlocksRW.register(modEventBus);
        ModItemsRW.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::menuScreens);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    private void menuScreens(final RegisterMenuScreensEvent event) {
        event.register(ModMenus.SAWMILL_MENU.get(), SawmillScreen::new);
    }
}
