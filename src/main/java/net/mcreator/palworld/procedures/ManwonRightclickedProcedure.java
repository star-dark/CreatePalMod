package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class ManwonRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
			_vars.my_money = entity.getData(PalworldModVariables.PLAYER_VARIABLES).my_money + 10000;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
	}
}
