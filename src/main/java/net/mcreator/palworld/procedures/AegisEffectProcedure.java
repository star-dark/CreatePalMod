package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModParticleTypes;
import net.mcreator.palworld.init.PalworldModMobEffects;
import net.mcreator.palworld.init.PalworldModItems;
import net.mcreator.palworld.PalworldMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class AegisEffectProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double r = 0;
		double a = 0;
		double b = 0;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick <= 0) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.aegis_bool = false;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PalworldModMobEffects.AEGIS_COOL, 10, 1));
			PalworldMod.queueServerWork(777, () -> {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_tick = 500;
					_vars.syncPlayerVariables(entity);
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_bool = true;
					_vars.syncPlayerVariables(entity);
				}
			});
		} else {
			if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalworldModItems.AEGIS.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalworldModItems.AEGIS.get()) && entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_bool == true) {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_tick = entity.getData(PalworldModVariables.PLAYER_VARIABLES).aegis_tick - 1;
					_vars.syncPlayerVariables(entity);
				}
				{
					final Vec3 _center = new Vec3(x, (y + 1), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player)) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FLY_INTO_WALL)), 1);
							entityiterator.setDeltaMovement(new Vec3(((-1.5) * entityiterator.getX()), ((-1.5) * entityiterator.getY()), ((-1.5) * entityiterator.getZ())));
						}
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 2));
				r = 1.5;
				a = Math.random() * 12;
				b = 90;
				for (int index0 = 0; index0 < 30; index0++) {
					for (int index1 = 0; index1 < 16; index1++) {
						world.addParticle((SimpleParticleType) (PalworldModParticleTypes.AEGIS_PARTICLE.get()), (x - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))), ((y + 1) - r * Math.sin(Math.toRadians(b))),
								(z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))), 0, 0, 0);
						b = b + 12;
					}
					a = a + 12;
					b = 90;
				}
			}
		}
	}
}
