
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.palworld.world.inventory.UserGUIMenu;
import net.mcreator.palworld.world.inventory.QuestTapMenu;
import net.mcreator.palworld.world.inventory.MoneyTapMenu;
import net.mcreator.palworld.world.inventory.JobNpcGuiMenu;
import net.mcreator.palworld.PalworldMod;

public class PalworldModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PalworldMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<UserGUIMenu>> USER_GUI = REGISTRY.register("user_gui", () -> IMenuTypeExtension.create(UserGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobNpcGuiMenu>> JOB_NPC_GUI = REGISTRY.register("job_npc_gui", () -> IMenuTypeExtension.create(JobNpcGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MoneyTapMenu>> MONEY_TAP = REGISTRY.register("money_tap", () -> IMenuTypeExtension.create(MoneyTapMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestTapMenu>> QUEST_TAP = REGISTRY.register("quest_tap", () -> IMenuTypeExtension.create(QuestTapMenu::new));
}
