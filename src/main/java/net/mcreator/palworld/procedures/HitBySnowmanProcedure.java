package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.palworld.init.PalworldModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HitBySnowmanProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof SnowGolem
				&& (sourceentity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(PalworldModAttributes.IS_SUMMON) ? _livingEntity1.getAttribute(PalworldModAttributes.IS_SUMMON).getBaseValue() : 0) > 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FREEZE)),
					(float) (sourceentity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(PalworldModAttributes.IS_SUMMON) ? _livingEntity2.getAttribute(PalworldModAttributes.IS_SUMMON).getBaseValue() : 0));
			entity.push(((sourceentity.getX() - entity.getX()) / 2.5), ((sourceentity.getY() - entity.getY()) / 2), ((sourceentity.getZ() - entity.getZ()) / 2.5));
			if (sourceentity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(PalworldModAttributes.DESPAWN_COUNT))
				_livingEntity13.getAttribute(PalworldModAttributes.DESPAWN_COUNT)
						.setBaseValue(((sourceentity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(PalworldModAttributes.DESPAWN_COUNT)
								? _livingEntity12.getAttribute(PalworldModAttributes.DESPAWN_COUNT).getBaseValue()
								: 0) + 1));
		}
		if ((sourceentity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(PalworldModAttributes.DESPAWN_COUNT) ? _livingEntity14.getAttribute(PalworldModAttributes.DESPAWN_COUNT).getBaseValue() : 0) == 3) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()),
						(float) (sourceentity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(PalworldModAttributes.IS_SUMMON)
								? _livingEntity18.getAttribute(PalworldModAttributes.IS_SUMMON).getBaseValue()
								: 0),
						Level.ExplosionInteraction.NONE);
		}
	}
}
