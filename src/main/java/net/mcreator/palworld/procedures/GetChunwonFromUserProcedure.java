package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModItems;

public class GetChunwonFromUserProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).my_money > 1000) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalworldModItems.CHUNWON.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.my_money = entity.getData(PalworldModVariables.PLAYER_VARIABLES).my_money - 1000;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB3C8\uC774 \uBD80\uC871\uD569\uB2C8\uB2E4"), false);
		}
	}
}
