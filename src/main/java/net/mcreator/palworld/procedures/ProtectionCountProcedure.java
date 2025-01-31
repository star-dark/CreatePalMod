package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ProtectionCountProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBlocking() && entity.getData(PalworldModVariables.PLAYER_VARIABLES).ProtectionAmount < 9) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.ProtectionAmount = entity.getData(PalworldModVariables.PLAYER_VARIABLES).ProtectionAmount + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
