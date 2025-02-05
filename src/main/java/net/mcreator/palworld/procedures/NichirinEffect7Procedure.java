package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModMobEffects;

import java.util.List;
import java.util.Comparator;

public class NichirinEffect7Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double r = 0;
		double a = 0;
		double b = 0;
		if (world.dayTime() >= entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_cool) {
			r = 2;
			a = entity.getYRot();
			b = entity.getXRot();
			entity.getPersistentData().putDouble("timer", 20);
			for (int index0 = 0; index0 < 120; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DOLPHIN, (x - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))), ((y + 1.5) - r * Math.sin(Math.toRadians(b))), (z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))),
							30, 0.2, 0.2, 0.2, 0.2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, (x - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))), ((y + 1) - r * Math.sin(Math.toRadians(b))), (z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))), 2,
							0.2, 0.2, 0.2, 0.02);
				{
					final Vec3 _center = new Vec3((x - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))), ((y + 1) - r * Math.sin(Math.toRadians(b))), (z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player)) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 5);
						}
					}
				}
				b = b + 3;
			}
			entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 1), (entity.getLookAngle().y * 1.5), (entity.getLookAngle().z * 1)));
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Nichirin_cool = world.dayTime() + 150;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PalworldModMobEffects.WATER_POTION_EFFECT, 150, 1, false, false));
		}
	}
}
