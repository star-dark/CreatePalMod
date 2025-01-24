package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ReflectionProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getSource().getDirectEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, Entity immediatesourceentity) {
		execute(null, damagesource, entity, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, Entity immediatesourceentity) {
		if (damagesource == null || entity == null || immediatesourceentity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBlocking() && entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp > 0) {
			immediatesourceentity.hurt(damagesource, (float) entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp);
			immediatesourceentity.push((entity.getLookAngle().x * Math.sqrt(entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp)), Math.log10(entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp),
					(entity.getLookAngle().z * Math.sqrt(entity.getData(PalworldModVariables.PLAYER_VARIABLES).ReflectionSkillPointUp)));
		}
	}
}
