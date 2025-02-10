
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
			tabData.accept(PalworldModItems.ASTRA_BOOK.get());
			tabData.accept(PalworldModItems.AVALON_OF_MERLIN.get());
			tabData.accept(PalworldModItems.HEAVEN.get());
			tabData.accept(PalworldModItems.GLORY_GOLD_GHOST.get());
			tabData.accept(PalworldModItems.NICHIRIN.get());
			tabData.accept(PalworldModItems.LAEVATEINN.get());
			tabData.accept(PalworldModItems.ELDER_WAND.get());
			tabData.accept(PalworldModItems.ARMOR_BONE_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_BONE_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_BONE_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_BONE_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_DIVINE_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_DIVINE_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_DIVINE_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_DIVINE_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_HEAVY_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_HEAVY_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_HEAVY_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_HEAVY_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_PRISMARINE_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_PRISMARINE_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_PRISMARINE_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_PRISMARINE_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_ROBE_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_ROBE_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_ROBE_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_ROBE_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_SLIME_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_SLIME_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_SLIME_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_SLIME_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_STEAMPUNK_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_STEAMPUNK_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_STEAMPUNK_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_STEAMPUNK_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_WARRIOR_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_WARRIOR_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_WARRIOR_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_WARRIOR_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_WITHER_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_WITHER_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_WITHER_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_WITHER_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_WOOD_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_WOOD_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_WOOD_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_WOOD_BOOTS.get());
			tabData.accept(PalworldModItems.ARMOR_GOLD_HELMET.get());
			tabData.accept(PalworldModItems.ARMOR_GOLD_CHESTPLATE.get());
			tabData.accept(PalworldModItems.ARMOR_GOLD_LEGGINGS.get());
			tabData.accept(PalworldModItems.ARMOR_GOLD_BOOTS.get());

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
