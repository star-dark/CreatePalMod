
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.palworld.client.gui.UserGUIScreen;
import net.mcreator.palworld.client.gui.QuestTapScreen;
import net.mcreator.palworld.client.gui.MoneyTapScreen;
import net.mcreator.palworld.client.gui.JobNpcGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PalworldModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PalworldModMenus.USER_GUI.get(), UserGUIScreen::new);
		event.register(PalworldModMenus.JOB_NPC_GUI.get(), JobNpcGuiScreen::new);
		event.register(PalworldModMenus.QUEST_TAP.get(), QuestTapScreen::new);
		event.register(PalworldModMenus.MONEY_TAP.get(), MoneyTapScreen::new);
	}
}
