package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModParticleTypes;
import net.mcreator.palworld.init.PalworldModMobEffects;

import java.util.List;
import java.util.Comparator;

public class NichirinEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double r = 0;
		double deg = 0;
		double i = 0;
		if (world.dayTime() >= entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_cool) {
			deg = entity.getYRot() - 90;
			r = 1;
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			for (int index0 = 0; index0 < 2; index0++) {
				for (int index1 = 0; index1 < 11; index1++) {
					world.addParticle((SimpleParticleType) (PalworldModParticleTypes.WATER_PARTICLE.get()), (x - r * Math.sin(Math.toRadians(deg))), (y + 1), (z + r * Math.cos(Math.toRadians(deg))), ((-0.1) * Math.sin(Math.toRadians(deg))), 0,
							(0.1 * Math.cos(Math.toRadians(deg))));
					{
						final Vec3 _center = new Vec3((x - r * Math.sin(Math.toRadians(deg))), (y + 1), (z + r * Math.cos(Math.toRadians(deg))));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof Player)) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 1);
							}
						}
					}
					deg = deg + 18;
				}
				deg = entity.getYRot() - 81;
				r = r + 1;
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Nichirin_cool = world.dayTime() + 15;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PalworldModMobEffects.WATER_POTION_EFFECT, 15, 1, true, false));
		}
	}
}
