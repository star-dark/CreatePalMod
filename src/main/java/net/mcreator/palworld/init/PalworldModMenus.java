
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
import net.mcreator.palworld.world.inventory.SubQuestProvideGUIMenu;
import net.mcreator.palworld.world.inventory.SubQuestCompleteMenu;
import net.mcreator.palworld.world.inventory.SubQuestClearMenu;
import net.mcreator.palworld.world.inventory.QuestTapMenu;
import net.mcreator.palworld.world.inventory.QuestProvideGUIMenu;
import net.mcreator.palworld.world.inventory.MoneyTapMenu;
import net.mcreator.palworld.world.inventory.MinerSkillTreeMenu;
import net.mcreator.palworld.world.inventory.MinerSellGuiMenu;
import net.mcreator.palworld.world.inventory.JobNpcGuiMenu;
import net.mcreator.palworld.world.inventory.JobNpcActionMenu;
import net.mcreator.palworld.world.inventory.FisherSkillTreeMenu;
import net.mcreator.palworld.world.inventory.FisherSellGuiMenu;
import net.mcreator.palworld.world.inventory.FarmerSkillTreeMenu;
import net.mcreator.palworld.world.inventory.FarmerSellGuiMenu;
import net.mcreator.palworld.PalworldMod;

public class PalworldModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PalworldMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<UserGUIMenu>> USER_GUI = REGISTRY.register("user_gui", () -> IMenuTypeExtension.create(UserGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobNpcGuiMenu>> JOB_NPC_GUI = REGISTRY.register("job_npc_gui", () -> IMenuTypeExtension.create(JobNpcGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MoneyTapMenu>> MONEY_TAP = REGISTRY.register("money_tap", () -> IMenuTypeExtension.create(MoneyTapMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestTapMenu>> QUEST_TAP = REGISTRY.register("quest_tap", () -> IMenuTypeExtension.create(QuestTapMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestProvideGUIMenu>> QUEST_PROVIDE_GUI = REGISTRY.register("quest_provide_gui", () -> IMenuTypeExtension.create(QuestProvideGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SubQuestProvideGUIMenu>> SUB_QUEST_PROVIDE_GUI = REGISTRY.register("sub_quest_provide_gui", () -> IMenuTypeExtension.create(SubQuestProvideGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SubQuestCompleteMenu>> SUB_QUEST_COMPLETE = REGISTRY.register("sub_quest_complete", () -> IMenuTypeExtension.create(SubQuestCompleteMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SubQuestClearMenu>> SUB_QUEST_CLEAR = REGISTRY.register("sub_quest_clear", () -> IMenuTypeExtension.create(SubQuestClearMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FarmerSkillTreeMenu>> FARMER_SKILL_TREE = REGISTRY.register("farmer_skill_tree", () -> IMenuTypeExtension.create(FarmerSkillTreeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobNpcActionMenu>> JOB_NPC_ACTION = REGISTRY.register("job_npc_action", () -> IMenuTypeExtension.create(JobNpcActionMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FarmerSellGuiMenu>> FARMER_SELL_GUI = REGISTRY.register("farmer_sell_gui", () -> IMenuTypeExtension.create(FarmerSellGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MinerSellGuiMenu>> MINER_SELL_GUI = REGISTRY.register("miner_sell_gui", () -> IMenuTypeExtension.create(MinerSellGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FisherSellGuiMenu>> FISHER_SELL_GUI = REGISTRY.register("fisher_sell_gui", () -> IMenuTypeExtension.create(FisherSellGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FisherSkillTreeMenu>> FISHER_SKILL_TREE = REGISTRY.register("fisher_skill_tree", () -> IMenuTypeExtension.create(FisherSkillTreeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MinerSkillTreeMenu>> MINER_SKILL_TREE = REGISTRY.register("miner_skill_tree", () -> IMenuTypeExtension.create(MinerSkillTreeMenu::new));
}
