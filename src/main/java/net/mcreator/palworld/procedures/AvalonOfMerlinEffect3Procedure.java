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

public class AvalonOfMerlinEffect3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof Player)) {
					if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 0) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 10, false, false));
					} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 1) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 2, false, false));
					} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 2) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 3, false, false));
					} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 3) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 80, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number / 10), false, false));
					} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 4) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level * 1.5));
					}
				}
				if (entityiterator instanceof Player) {
					if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 == 1) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10), false, false));
					} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 == 2) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 1, false, false));
					} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 == 3) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, false));
					} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 == 4) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1, false, false));
					} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 == 5) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10 + 1), false, false));
					} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 == 6) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10 + 1), false, false));
					} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 == 7) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10 + 1), false, false));
					}
				}
			}
		}
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 >= 4) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Avalon_number = (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) - 1;
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number - entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10) / 10 >= 7) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Avalon_number = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
