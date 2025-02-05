
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

			tabData.accept(PalworldModItems.AMANOMURAKUMONOTSURUGI.get());
			tabData.accept(PalworldModItems.BALMUNG.get());
			tabData.accept(PalworldModItems.MJOLNIR.get());
			tabData.accept(PalworldModItems.DAINSLEIF.get());
			tabData.accept(PalworldModItems.AEGIS.get());
			tabData.accept(PalworldModItems.SKYSHATTER.get());
			tabData.accept(PalworldModItems.BANGOBU.get());
			tabData.accept(PalworldModItems.BURF_SWORD.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

			tabData.accept(PalworldModItems.FARMER_JOB_NPC_SPAWN_EGG.get());
			tabData.accept(PalworldModItems.MINER_JOB_NPC_SPAWN_EGG.get());
			tabData.accept(PalworldModItems.FISHER_JOB_NPC_SPAWN_EGG.get());
			tabData.accept(PalworldModItems.KING_SPAWN_EGG.get());
			tabData.accept(PalworldModItems.QUEEN_SPAWN_EGG.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(PalworldModItems.FARMER_DREGS.get());
			tabData.accept(PalworldModItems.ORE_GOLD.get());
			tabData.accept(PalworldModItems.ORE_EMERALD.get());
			tabData.accept(PalworldModItems.FARMER_ROOT.get());
			tabData.accept(PalworldModItems.ORE_LAPIS_LAZULI.get());
			tabData.accept(PalworldModItems.ORE_COPPER.get());
			tabData.accept(PalworldModItems.ORE_DIAMOND.get());
			tabData.accept(PalworldModItems.ORE_IRON.get());
			tabData.accept(PalworldModItems.FARMER_SPORE.get());
			tabData.accept(PalworldModItems.ORE_COAL.get());
			tabData.accept(PalworldModItems.CHUNWON.get());
			tabData.accept(PalworldModItems.OCHUNWON.get());
			tabData.accept(PalworldModItems.MANWON.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(PalworldModItems.MINER_PICK_LV_30.get());
			tabData.accept(PalworldModItems.MINER_PICK_LV_15.get());
			tabData.accept(PalworldModItems.MINER_PICK_LV_1.get());
			tabData.accept(PalworldModItems.FISH_ROD_LV_15.get());
			tabData.accept(PalworldModItems.FISH_ROD_LV_1.get());
			tabData.accept(PalworldModItems.FISH_ROD_LV_30.get());
			tabData.accept(PalworldModItems.MAGIC_WAND.get());
			tabData.accept(PalworldModItems.LEVEL_WAND.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {

			tabData.accept(PalworldModItems.FISH_BASS.get());
			tabData.accept(PalworldModItems.FISH_POLLOCK.get());
			tabData.accept(PalworldModItems.FISH_CARP.get());
			tabData.accept(PalworldModItems.FISH_TAMBAQUI.get());
			tabData.accept(PalworldModItems.FISH_BLUE_GILL.get());
			tabData.accept(PalworldModItems.FISH_PERCH.get());
			tabData.accept(PalworldModItems.FISH_ANGLER.get());
			tabData.accept(PalworldModItems.FISH_ARAPAIMA.get());
			tabData.accept(PalworldModItems.FISH_CATFISH.get());
			tabData.accept(PalworldModItems.FISH_HAILBUT.get());
			tabData.accept(PalworldModItems.FISH_SYNODONTIS.get());
			tabData.accept(PalworldModItems.FISH_RED_BELLIED_PIRANHA.get());
			tabData.accept(PalworldModItems.FISH_RAINBOW_TROUT.get());
			tabData.accept(PalworldModItems.FISH_TUNA.get());
			tabData.accept(PalworldModItems.FISH_ELECTRIC_EEL.get());
			tabData.accept(PalworldModItems.FISH_MUSKELLUNGE.get());
			tabData.accept(PalworldModItems.FISH_RED_GROUPER.get());
			tabData.accept(PalworldModItems.FISH_HERRING.get());

		}
	}
}
