package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.palworld.network.PalworldModVariables;

public class SkyshatterEffect2Procedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!entity.onGround() && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.CONFUSION)) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float) (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * 2));
		}
	}
}
