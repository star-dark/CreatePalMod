package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ArcherProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).ArcherySkillPoint > 0) {
			if (!(entity instanceof Player) == (!(sourceentity == immediatesourceentity) && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
			} else if (!(entity instanceof Player) == ((!(sourceentity == immediatesourceentity) && entity instanceof LivingEntity _livEnt6
					&& _livEnt6.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) < 3)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) + 1)));
			} else if (!(entity instanceof Player) == (!(sourceentity == immediatesourceentity)
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) == 3)) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, (float) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).ArcherySkillPoint / 2), Level.ExplosionInteraction.NONE);
			}
		}
	}
}
