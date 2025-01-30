package net.mcreator.palworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.palworld.network.PalworldModVariables;

public class SetRandomItemProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		double item_index = 0;
		item_index = Mth.nextInt(RandomSource.create(), 1, 10);
		if (item_index == 1) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Blocks.AMETHYST_CLUSTER);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 2) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Blocks.WAXED_OXIDIZED_CHISELED_COPPER);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 3) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Blocks.JACK_O_LANTERN);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 4) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Items.GOAT_HORN);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 5) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Items.HONEY_BOTTLE);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 6) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Items.COOKIE);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 7) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Blocks.TURTLE_EGG);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 8) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Items.GLOW_INK_SAC);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else if (item_index == 9) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Items.GLOW_BERRIES);
				_vars.syncPlayerVariables(sourceentity);
			}
		} else {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.SubQuestItem = new ItemStack(Blocks.DRIED_KELP_BLOCK);
				_vars.syncPlayerVariables(sourceentity);
			}
		}
	}
}
