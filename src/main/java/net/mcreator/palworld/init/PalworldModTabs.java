
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
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(PalworldModItems.BURF_SWORD.get());
			tabData.accept(PalworldModItems.SKYSHATTER.get());
			tabData.accept(PalworldModItems.MJOLNIR.get());
			tabData.accept(PalworldModItems.DAINSLEIF.get());
			tabData.accept(PalworldModItems.BALMUNG.get());
			tabData.accept(PalworldModItems.BANGOBU.get());
			tabData.accept(PalworldModItems.AMANOMURAKUMONOTSURUGI.get());
			tabData.accept(PalworldModItems.AEGIS.get());
			tabData.accept(PalworldModItems.GLORY_GOLD_GHOST.get());
			tabData.accept(PalworldModItems.ASTRA_BOOK.get());
			tabData.accept(PalworldModItems.AVALON_OF_MERLIN.get());
			tabData.accept(PalworldModItems.HEAVEN.get());

		}
	}
}
