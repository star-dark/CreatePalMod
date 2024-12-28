package net.mcreator.palworld.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModItems;

public class ChunwonRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.my_money = entity.getData(PalworldModVariables.PLAYER_VARIABLES).my_money + 1000;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(PalworldModItems.CHUNWON.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
	}
}
