
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.palworld.item.FarmerSporeItem;
import net.mcreator.palworld.item.FarmerRootItem;
import net.mcreator.palworld.item.FarmerDregsItem;
import net.mcreator.palworld.PalworldMod;

public class PalworldModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PalworldMod.MODID);
	public static final DeferredItem<Item> FARMER_JOB_NPC_SPAWN_EGG = REGISTRY.register("farmer_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.FARMER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> FISHER_JOB_NPC_SPAWN_EGG = REGISTRY.register("fisher_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.FISHER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> MINER_JOB_NPC_SPAWN_EGG = REGISTRY.register("miner_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.MINER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> FARMER_DREGS = REGISTRY.register("farmer_dregs", FarmerDregsItem::new);
	public static final DeferredItem<Item> FARMER_ROOT = REGISTRY.register("farmer_root", FarmerRootItem::new);
	public static final DeferredItem<Item> FARMER_SPORE = REGISTRY.register("farmer_spore", FarmerSporeItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
