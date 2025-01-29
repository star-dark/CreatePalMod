package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.Comparator;

public class NichirinEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double deg = 0;
		double r = 0;
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		deg = entity.getYRot() - 90;
		r = 1;
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
		for (int index0 = 0; index0 < 5; index0++) {
			for (int index1 = 0; index1 < 11; index1++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SPLASH, (x - r * Math.sin(Math.toRadians(deg))), (y + 1), (z + r * Math.cos(Math.toRadians(deg))), 10, ((-0.1) * Math.sin(Math.toRadians(deg))), 0.1, (0.1 * Math.cos(Math.toRadians(deg))), 3);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FISHING, (x - r * Math.sin(Math.toRadians(deg))), (y + 1), (z + r * Math.cos(Math.toRadians(deg))), 10, ((-0.1) * Math.sin(Math.toRadians(deg))), 0.1, (0.1 * Math.cos(Math.toRadians(deg))), 3);
				world.addParticle(ParticleTypes.WARPED_SPORE, (x - r * Math.sin(Math.toRadians(deg))), (y + 1), (z + r * Math.cos(Math.toRadians(deg))), ((-0.1) * Math.sin(Math.toRadians(deg))), 0, (0.1 * Math.cos(Math.toRadians(deg))));
				if (((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg)))), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg))))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 2, false, false));
				if (((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg)))), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((x - r * Math.sin(Math.toRadians(deg))), y, (z + r * Math.cos(Math.toRadians(deg))))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2, false, false));
			}
			deg = entity.getYRot() - 81;
			r = r + 1;
		}
	}
}
