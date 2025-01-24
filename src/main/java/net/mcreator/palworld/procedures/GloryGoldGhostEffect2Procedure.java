package net.mcreator.palworld.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class GloryGoldGhostEffect2Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double count = 0;
		count = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.ARROW)) : false) {
			for (int index0 = 0; index0 < 10; index0++) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.ARROW);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				count = count + 1;
			}
			return count;
		}
		return count;
	}
}
