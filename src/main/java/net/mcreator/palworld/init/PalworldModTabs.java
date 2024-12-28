
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.palworld.PalworldMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PalworldModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PalworldMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

			tabData.accept(PalworldModItems.FARMER_JOB_NPC_SPAWN_EGG.get());
			tabData.accept(PalworldModItems.MINER_JOB_NPC_SPAWN_EGG.get());
			tabData.accept(PalworldModItems.FISHER_JOB_NPC_SPAWN_EGG.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(PalworldModItems.MINER_PICK_LV_30.get());
			tabData.accept(PalworldModItems.MINER_PICK_LV_15.get());
			tabData.accept(PalworldModItems.MINER_PICK_LV_1.get());

		}
	}
}
