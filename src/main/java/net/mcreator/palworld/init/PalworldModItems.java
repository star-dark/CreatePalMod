
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.palworld.PalworldMod;

public class PalworldModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PalworldMod.MODID);
	public static final DeferredItem<Item> FARMER_JOB_NPC_SPAWN_EGG = REGISTRY.register("farmer_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(PalworldModEntities.FARMER_JOB_NPC, -1, -1, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
