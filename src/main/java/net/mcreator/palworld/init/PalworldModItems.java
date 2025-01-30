
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.palworld.item.OreLapisLazuliItem;
import net.mcreator.palworld.item.OreIronItem;
import net.mcreator.palworld.item.OreGoldItem;
import net.mcreator.palworld.item.OreEmeraldItem;
import net.mcreator.palworld.item.OreDiamondItem;
import net.mcreator.palworld.item.OreCopperItem;
import net.mcreator.palworld.item.OreCoalItem;
import net.mcreator.palworld.item.OchunwonItem;
import net.mcreator.palworld.item.MinerPickLv30Item;
import net.mcreator.palworld.item.MinerPickLv1Item;
import net.mcreator.palworld.item.MinerPickLv15Item;
import net.mcreator.palworld.item.ManwonItem;
import net.mcreator.palworld.item.MagicWandItem;
import net.mcreator.palworld.item.LevelWandItem;
import net.mcreator.palworld.item.FishTunaItem;
import net.mcreator.palworld.item.FishTambaquiItem;
import net.mcreator.palworld.item.FishSynodontisItem;
import net.mcreator.palworld.item.FishRodLv30Item;
import net.mcreator.palworld.item.FishRodLv1Item;
import net.mcreator.palworld.item.FishRodLv15Item;
import net.mcreator.palworld.item.FishRedGrouperItem;
import net.mcreator.palworld.item.FishRedBelliedPiranhaItem;
import net.mcreator.palworld.item.FishRainbowTroutItem;
import net.mcreator.palworld.item.FishPollockItem;
import net.mcreator.palworld.item.FishPerchItem;
import net.mcreator.palworld.item.FishMuskellungeItem;
import net.mcreator.palworld.item.FishHerringItem;
import net.mcreator.palworld.item.FishHailbutItem;
import net.mcreator.palworld.item.FishElectricEelItem;
import net.mcreator.palworld.item.FishCatfishItem;
import net.mcreator.palworld.item.FishCarpItem;
import net.mcreator.palworld.item.FishBlueGillItem;
import net.mcreator.palworld.item.FishBassItem;
import net.mcreator.palworld.item.FishArapaimaItem;
import net.mcreator.palworld.item.FishAnglerItem;
import net.mcreator.palworld.item.FarmerSporeItem;
import net.mcreator.palworld.item.FarmerRootItem;
import net.mcreator.palworld.item.FarmerDregsItem;
import net.mcreator.palworld.item.ChunwonItem;
import net.mcreator.palworld.PalworldMod;

public class PalworldModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PalworldMod.MODID);
	public static final DeferredItem<Item> FARMER_JOB_NPC_SPAWN_EGG = REGISTRY.register("farmer_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.FARMER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> FARMER_DREGS = REGISTRY.register("farmer_dregs", FarmerDregsItem::new);
	public static final DeferredItem<Item> ORE_GOLD = REGISTRY.register("ore_gold", OreGoldItem::new);
	public static final DeferredItem<Item> ORE_EMERALD = REGISTRY.register("ore_emerald", OreEmeraldItem::new);
	public static final DeferredItem<Item> FARMER_ROOT = REGISTRY.register("farmer_root", FarmerRootItem::new);
	public static final DeferredItem<Item> MINER_JOB_NPC_SPAWN_EGG = REGISTRY.register("miner_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.MINER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> ORE_LAPIS_LAZULI = REGISTRY.register("ore_lapis_lazuli", OreLapisLazuliItem::new);
	public static final DeferredItem<Item> ORE_COPPER = REGISTRY.register("ore_copper", OreCopperItem::new);
	public static final DeferredItem<Item> MINER_PICK_LV_30 = REGISTRY.register("miner_pick_lv_30", MinerPickLv30Item::new);
	public static final DeferredItem<Item> ORE_DIAMOND = REGISTRY.register("ore_diamond", OreDiamondItem::new);
	public static final DeferredItem<Item> ORE_IRON = REGISTRY.register("ore_iron", OreIronItem::new);
	public static final DeferredItem<Item> MINER_PICK_LV_15 = REGISTRY.register("miner_pick_lv_15", MinerPickLv15Item::new);
	public static final DeferredItem<Item> FISHER_JOB_NPC_SPAWN_EGG = REGISTRY.register("fisher_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.FISHER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> MINER_PICK_LV_1 = REGISTRY.register("miner_pick_lv_1", MinerPickLv1Item::new);
	public static final DeferredItem<Item> FARMER_SPORE = REGISTRY.register("farmer_spore", FarmerSporeItem::new);
	public static final DeferredItem<Item> ORE_COAL = REGISTRY.register("ore_coal", OreCoalItem::new);
	public static final DeferredItem<Item> FISH_BASS = REGISTRY.register("fish_bass", FishBassItem::new);
	public static final DeferredItem<Item> FISH_POLLOCK = REGISTRY.register("fish_pollock", FishPollockItem::new);
	public static final DeferredItem<Item> FISH_CARP = REGISTRY.register("fish_carp", FishCarpItem::new);
	public static final DeferredItem<Item> FISH_TAMBAQUI = REGISTRY.register("fish_tambaqui", FishTambaquiItem::new);
	public static final DeferredItem<Item> FISH_BLUE_GILL = REGISTRY.register("fish_blue_gill", FishBlueGillItem::new);
	public static final DeferredItem<Item> FISH_PERCH = REGISTRY.register("fish_perch", FishPerchItem::new);
	public static final DeferredItem<Item> FISH_ANGLER = REGISTRY.register("fish_angler", FishAnglerItem::new);
	public static final DeferredItem<Item> FISH_ARAPAIMA = REGISTRY.register("fish_arapaima", FishArapaimaItem::new);
	public static final DeferredItem<Item> FISH_CATFISH = REGISTRY.register("fish_catfish", FishCatfishItem::new);
	public static final DeferredItem<Item> FISH_HAILBUT = REGISTRY.register("fish_hailbut", FishHailbutItem::new);
	public static final DeferredItem<Item> FISH_SYNODONTIS = REGISTRY.register("fish_synodontis", FishSynodontisItem::new);
	public static final DeferredItem<Item> FISH_RED_BELLIED_PIRANHA = REGISTRY.register("fish_red_bellied_piranha", FishRedBelliedPiranhaItem::new);
	public static final DeferredItem<Item> FISH_RAINBOW_TROUT = REGISTRY.register("fish_rainbow_trout", FishRainbowTroutItem::new);
	public static final DeferredItem<Item> FISH_TUNA = REGISTRY.register("fish_tuna", FishTunaItem::new);
	public static final DeferredItem<Item> FISH_ROD_LV_15 = REGISTRY.register("fish_rod_lv_15", FishRodLv15Item::new);
	public static final DeferredItem<Item> FISH_ELECTRIC_EEL = REGISTRY.register("fish_electric_eel", FishElectricEelItem::new);
	public static final DeferredItem<Item> FISH_ROD_LV_1 = REGISTRY.register("fish_rod_lv_1", FishRodLv1Item::new);
	public static final DeferredItem<Item> FISH_ROD_LV_30 = REGISTRY.register("fish_rod_lv_30", FishRodLv30Item::new);
	public static final DeferredItem<Item> FISH_MUSKELLUNGE = REGISTRY.register("fish_muskellunge", FishMuskellungeItem::new);
	public static final DeferredItem<Item> FISH_RED_GROUPER = REGISTRY.register("fish_red_grouper", FishRedGrouperItem::new);
	public static final DeferredItem<Item> FISH_HERRING = REGISTRY.register("fish_herring", FishHerringItem::new);
	public static final DeferredItem<Item> CHUNWON = REGISTRY.register("chunwon", ChunwonItem::new);
	public static final DeferredItem<Item> OCHUNWON = REGISTRY.register("ochunwon", OchunwonItem::new);
	public static final DeferredItem<Item> MANWON = REGISTRY.register("manwon", ManwonItem::new);
	public static final DeferredItem<Item> MAGIC_WAND = REGISTRY.register("magic_wand", MagicWandItem::new);
	public static final DeferredItem<Item> KING_SPAWN_EGG = REGISTRY.register("king_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.KING, -65536, -256, new Item.Properties()));
	public static final DeferredItem<Item> PIG_SPAWN_EGG = REGISTRY.register("pig_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.PIG, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> QUEEN_SPAWN_EGG = REGISTRY.register("queen_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.QUEEN, -3407668, -256, new Item.Properties()));
	public static final DeferredItem<Item> LEVEL_WAND = REGISTRY.register("level_wand", LevelWandItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
