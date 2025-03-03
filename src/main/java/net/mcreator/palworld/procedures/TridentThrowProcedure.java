package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TridentThrowProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		if (damagesource.is(DamageTypes.TRIDENT) && sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).TridentSkillPoint > 0
				&& Math.sqrt(Math.pow(sourceentity.getX() - entity.getX(), 2) + Math.pow(sourceentity.getZ() - entity.getZ(), 2)) >= 6) {
			entity.push(((sourceentity.getX() - entity.getX()) / 2.5), ((sourceentity.getY() - entity.getY()) / 2), ((sourceentity.getZ() - entity.getZ()) / 2.5));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, (int) (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).TridentSkillPoint - 1)));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, (int) (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).TridentSkillPoint - 1)));
		}
	}
}
