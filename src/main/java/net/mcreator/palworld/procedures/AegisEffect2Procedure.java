package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AegisEffect2Procedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalworldModItems.AEGIS.get()) {
			if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == true && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick >= 300) {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_bool = false;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Aegis OFF"), true);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == false && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick > 300) {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_bool = true;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Aegis ON"), true);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == true && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick <= 300) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Aegis Cool"), true);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == false && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick <= 300) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Aegis Cool"), true);
			}
		}
	}
}
