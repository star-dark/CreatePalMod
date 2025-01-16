
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.palworld.client.gui.UserGUIScreen;
import net.mcreator.palworld.client.gui.SubQuestProvideGUIScreen;
import net.mcreator.palworld.client.gui.SubQuestCompleteScreen;
import net.mcreator.palworld.client.gui.SubQuestClearScreen;
import net.mcreator.palworld.client.gui.QuestTapScreen;
import net.mcreator.palworld.client.gui.QuestProvideGUIScreen;
import net.mcreator.palworld.client.gui.MoneyTapScreen;
import net.mcreator.palworld.client.gui.MinerSellGuiScreen;
import net.mcreator.palworld.client.gui.JobNpcGuiScreen;
import net.mcreator.palworld.client.gui.JobNpcActionScreen;
import net.mcreator.palworld.client.gui.FisherSellGuiScreen;
import net.mcreator.palworld.client.gui.FarmerSkillTreeScreen;
import net.mcreator.palworld.client.gui.FarmerSellGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PalworldModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PalworldModMenus.USER_GUI.get(), UserGUIScreen::new);
		event.register(PalworldModMenus.JOB_NPC_GUI.get(), JobNpcGuiScreen::new);
		event.register(PalworldModMenus.MONEY_TAP.get(), MoneyTapScreen::new);
		event.register(PalworldModMenus.QUEST_TAP.get(), QuestTapScreen::new);
		event.register(PalworldModMenus.QUEST_PROVIDE_GUI.get(), QuestProvideGUIScreen::new);
		event.register(PalworldModMenus.SUB_QUEST_PROVIDE_GUI.get(), SubQuestProvideGUIScreen::new);
		event.register(PalworldModMenus.SUB_QUEST_COMPLETE.get(), SubQuestCompleteScreen::new);
		event.register(PalworldModMenus.SUB_QUEST_CLEAR.get(), SubQuestClearScreen::new);
		event.register(PalworldModMenus.FARMER_SKILL_TREE.get(), FarmerSkillTreeScreen::new);
		event.register(PalworldModMenus.JOB_NPC_ACTION.get(), JobNpcActionScreen::new);
		event.register(PalworldModMenus.FISHER_SELL_GUI.get(), FisherSellGuiScreen::new);
		event.register(PalworldModMenus.MINER_SELL_GUI.get(), MinerSellGuiScreen::new);
		event.register(PalworldModMenus.FARMER_SELL_GUI.get(), FarmerSellGuiScreen::new);
	}
}
