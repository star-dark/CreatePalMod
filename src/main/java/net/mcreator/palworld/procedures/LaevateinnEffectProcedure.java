package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class LaevateinnEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double r = 0;
		double deg = 0;
		double Y = 0;
		deg = 0;
		r = 1;
		Y = y + 1;
		for (int index0 = 0; index0 < 2; index0++) {
			for (int index1 = 0; index1 < 3; index1++) {
				for (int index2 = 0; index2 < 10; index2++) {
					world.addParticle(ParticleTypes.LAVA, (x + r * Math.cos(deg)), Y, (z + r * Math.sin(deg)), 0, 1, 0);
					{
						final Vec3 _center = new Vec3((x + r * Math.cos(deg)), Y, (z + r * Math.sin(deg)));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.IN_FIRE)), 1);
						}
					}
					deg = deg + 36;
				}
				deg = 0;
				r = r + 1;
			}
			r = 0;
			Y = Y + 1;
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 50);
	}
}
