package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

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
		double expGoal = 0;
		expGoal = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * Math.pow(1.1, entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level) * 100;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_EXP >= expGoal) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Player_Level = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Player_EXP = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_EXP - expGoal;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB808\uBCA8\uC5C5!"), false);
		}
	}
}
