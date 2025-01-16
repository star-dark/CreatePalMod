package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModItems;

import java.util.function.Supplier;
import java.util.Map;

public class GetSubquestRewardProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
				.getItem() == entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestItem.getItem() && new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(0) >= entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestGoal) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(5);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalworldModItems.MANWON.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(0)).remove((int) entity.getData(PalworldModVariables.PLAYER_VARIABLES).SubQuestGoal);
				_player.containerMenu.broadcastChanges();
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.IsSubQuestExist = false;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
