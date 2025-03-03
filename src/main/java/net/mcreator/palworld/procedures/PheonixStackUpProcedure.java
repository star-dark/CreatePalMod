package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PheonixStackUpProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).PhoenixSkillPoint > 0 && entity instanceof Monster) {
			{
				PalworldModVariables.PlayerVariables _vars = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.PheonixStack = sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).PheonixStack + sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).PhoenixSkillPoint * 0.5;
				_vars.syncPlayerVariables(sourceentity);
			}
		}
	}
}
