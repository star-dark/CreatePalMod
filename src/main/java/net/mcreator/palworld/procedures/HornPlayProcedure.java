package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class HornPlayProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getItem());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HornPlayerSkillPoint > 0 && itemstack.getItem() == Items.GOAT_HORN) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HornPlayerSkillPoint < 3) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, (int) (entity.getData(PalworldModVariables.PLAYER_VARIABLES).HornPlayerSkillPoint - 1), true, true));
						} else {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).HornPlayerSkillPoint - 2) * 60), 2, true, true));
						}
					}
				}
			}
		}
	}
}
