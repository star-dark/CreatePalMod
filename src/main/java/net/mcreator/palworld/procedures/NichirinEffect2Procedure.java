package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.palworld.init.PalworldModParticleTypes;

import java.util.Comparator;

public class NichirinEffect2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double r = 0;
		double deg = 0;
		double i = 0;
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y + 3), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y + 3), z, _ent.getYRot(), _ent.getXRot());
		}
		deg = 0;
		r = 1;
		i = 1;
		if (world instanceof ServerLevel _level) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
		for (int index0 = 0; index0 < 1; index0++) {
			for (int index1 = 0; index1 < 2; index1++) {
				for (int index2 = 0; index2 < 11; index2++) {
					world.addParticle((SimpleParticleType) (PalworldModParticleTypes.WATER_PARTICLE.get()), (x - r * Math.sin(Math.toRadians(deg))), (y + i), (z + r * Math.cos(Math.toRadians(deg))), ((-0.1) * Math.sin(Math.toRadians(deg))), 0,
							(0.1 * Math.cos(Math.toRadians(deg))));
					if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg)))), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg))))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1, false, false));
					if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg)))), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg))))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1, false, false));
					deg = deg + 36;
				}
				if (i == 2 || i == 4) {
					deg = 18;
				} else {
					deg = 0;
				}
				r = r + 1;
			}
		}
	}
}
