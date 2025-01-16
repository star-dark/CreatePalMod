package net.mcreator.palworld.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModItems;

public class FisherSell12Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double count = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalworldModItems.FISH_MUSKELLUNGE.get())) : false) {
			while (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalworldModItems.FISH_MUSKELLUNGE.get())) : false) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PalworldModItems.FISH_MUSKELLUNGE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.my_money = 70 + entity.getData(PalworldModVariables.PLAYER_VARIABLES).my_money;
					_vars.syncPlayerVariables(entity);
				}
				count = count + 1;
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new ItemStack(PalworldModItems.FISH_MUSKELLUNGE.get()).getDisplayName().getString() + "" + new java.text.DecimalFormat(" ##\uAC1C").format(count) + "\uB97C \uD310\uB9E4\uD558\uC5EC "
						+ new java.text.DecimalFormat("##\uC6D0").format(count * 70) + "\uC744 \uD68D\uB4DD\uD558\uC168\uC2B5\uB2C8\uB2E4")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uC544\uC774\uD15C\uC744 \uAC16\uACE0 \uC788\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4"), false);
		}
	}
}
