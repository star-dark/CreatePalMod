package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.palworld.network.PalworldModVariables;

import java.util.List;
import java.util.Comparator;

public class AvalonOfMerlinEffect2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double r = 0;
		double d = 0;
		double num = 0;
		double angle = 0;
		double k = 0;
		double n = 0;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					num = Mth.nextInt(RandomSource.create(), 1, 7);
					k = 2160;
					angle = 0;
					if (entityiterator instanceof Player) {
						if (num == 1) {
							n = 4;
							d = 5;
							for (int index0 = 0; index0 < (int) k; index0++) {
								r = 3 * Math.cos(Math.toRadians((n / d) * angle));
								world.addParticle(ParticleTypes.HAPPY_VILLAGER, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
								angle = angle + 360 / (k * 0.1415);
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10), false, false));
						} else if (num == 2) {
							n = 3;
							d = 5;
							for (int index1 = 0; index1 < (int) k; index1++) {
								r = 10 * Math.cos(Math.toRadians((n / d) * angle));
								world.addParticle(ParticleTypes.INSTANT_EFFECT, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
								angle = angle + 360 / (k * 0.1415);
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 1, false, false));
						} else if (num == 3) {
							n = 3;
							d = 4;
							for (int index2 = 0; index2 < (int) k; index2++) {
								r = 10 * Math.cos(Math.toRadians((n / d) * angle));
								world.addParticle(ParticleTypes.WITCH, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
								angle = angle + 360 / (k * 0.1415);
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, false));
						} else if (num == 4) {
							n = 2;
							d = 3;
							for (int index3 = 0; index3 < (int) k; index3++) {
								r = 10 * Math.cos(Math.toRadians((n / d) * angle));
								world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
								angle = angle + 360 / (k * 0.1415);
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 10, 1, false, false));
						} else if (num == 5) {
							n = 1;
							d = 4;
							for (int index4 = 0; index4 < (int) k; index4++) {
								r = 10 * Math.cos(Math.toRadians((n / d) * angle));
								world.addParticle(ParticleTypes.NAUTILUS, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
								angle = angle + 360 / (k * 0.1415);
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10 + 1), false, false));
						} else if (num == 6) {
							n = 4;
							d = 3;
							for (int index5 = 0; index5 < (int) k; index5++) {
								r = 10 * Math.cos(Math.toRadians((n / d) * angle));
								world.addParticle(ParticleTypes.END_ROD, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
								angle = angle + 360 / (k * 0.1415);
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10 + 1), false, false));
						} else if (num == 7) {
							n = 2;
							d = 5;
							for (int index6 = 0; index6 < (int) k; index6++) {
								r = 10 * Math.cos(Math.toRadians((n / d) * angle));
								world.addParticle(ParticleTypes.FIREWORK, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
								angle = angle + 360 / (k * 0.1415);
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level / 10 + 1), false, false));
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\uB9C8\uBC95 \uC0AC\uC6A9 \uC2E4\uD328"), true);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 1000);
				}
			}
		}
	}
}
