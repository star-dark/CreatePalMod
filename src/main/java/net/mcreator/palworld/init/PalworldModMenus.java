
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.palworld.world.inventory.JobNpcGuiMenu;
import net.mcreator.palworld.PalworldMod;

public class PalworldModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PalworldMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<JobNpcGuiMenu>> JOB_NPC_GUI = REGISTRY.register("job_npc_gui", () -> IMenuTypeExtension.create(JobNpcGuiMenu::new));
}
