
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
import net.mcreator.palworld.item.MinerPickLv30Item;
import net.mcreator.palworld.item.MinerPickLv1Item;
import net.mcreator.palworld.item.MinerPickLv15Item;
import net.mcreator.palworld.item.FarmerSporeItem;
import net.mcreator.palworld.item.FarmerRootItem;
import net.mcreator.palworld.item.FarmerDregsItem;
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
	// Start of user code block custom items
	// End of user code block custom items
}
