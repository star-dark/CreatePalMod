package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LevelUpProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_EXP >= entity.getData(PalworldModVariables.PLAYER_VARIABLES).ExpGoal) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Player_Level = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Player_EXP = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_EXP - entity.getData(PalworldModVariables.PLAYER_VARIABLES).ExpGoal;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level <= 15) {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.ExpGoal = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level + 6);
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level <= 30) {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.ExpGoal = Math.pow(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level, 2) * 2.5 - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * 40.5 + 360;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.ExpGoal = Math.pow(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level, 2) * 4.5 - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * 162.5 + 2220;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB808\uBCA8\uC5C5!"), true);
		}
	}
}
