package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.palworld.network.PalworldModVariables;

import java.util.List;
import java.util.Comparator;

public class AstraBookEffect2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double time1 = 0;
		double time2 = 0;
		double time3 = 0;
		double time4 = 0;
		double time5 = 0;
		time1 = entity.getData(PalworldModVariables.PLAYER_VARIABLES).AstraBook_tick + 10;
		time2 = entity.getData(PalworldModVariables.PLAYER_VARIABLES).AstraBook_tick + 20;
		time3 = entity.getData(PalworldModVariables.PLAYER_VARIABLES).AstraBook_tick + 30;
		time4 = entity.getData(PalworldModVariables.PLAYER_VARIABLES).AstraBook_tick + 40;
		time5 = entity.getData(PalworldModVariables.PLAYER_VARIABLES).AstraBook_tick + 50;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (time1 == world.dayTime() || time2 == world.dayTime() || time3 == world.dayTime() || time4 == world.dayTime() || time5 == world.dayTime()) {
					if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 0.1, 0.1, 0.1), e -> true).isEmpty() && !(entityiterator instanceof Player)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * 0.4));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 3, false, false));
					}
				}
			}
		}
	}
}
