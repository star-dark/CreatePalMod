package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.palworld.network.PalworldModVariables;

import java.util.List;
import java.util.Comparator;

public class AstraBookEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xx = 0;
		double zz = 0;
		double r = 0;
		double dx = 0;
		double dz = 0;
		double z1 = 0;
		double z2 = 0;
		double angle = 0;
		double i = 0;
		double x1 = 0;
		double x2 = 0;
		double k = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 200, false, false));
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.AstraBook_tick = world.dayTime();
					_vars.syncPlayerVariables(entity);
				}
				AstraBookEffect2Procedure.execute(world, x, y, z, entity);
				r = 1;
				k = 50;
				angle = 0;
				i = 0;
				if (!(entityiterator instanceof Player)) {
					for (int index0 = 0; index0 < (int) k; index0++) {
						world.addParticle(ParticleTypes.END_ROD, (entityiterator.getX() + r * Math.cos(Math.toRadians(angle))), (entityiterator.getY()), (entityiterator.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0.2, 0);
						angle = angle + 360 / k;
					}
					for (int index1 = 0; index1 < 5; index1++) {
						x1 = entityiterator.getX() + r * Math.cos(Math.toRadians(i));
						z1 = entityiterator.getZ() + r * Math.sin(Math.toRadians(i));
						x2 = entityiterator.getX() + r * Math.cos(Math.toRadians(i + 144));
						z2 = entityiterator.getZ() + r * Math.sin(Math.toRadians(i + 144));
						dx = (x2 - x1) / k;
						dz = (z2 - z1) / k;
						xx = x1;
						zz = z1;
						for (int index2 = 0; index2 < (int) k; index2++) {
							world.addParticle(ParticleTypes.END_ROD, xx, (entityiterator.getY()), zz, 0, 0.2, 0);
							xx = xx + dx;
							zz = zz + dz;
						}
						i = i + 72;
					}
				}
			}
		}
	}
}
