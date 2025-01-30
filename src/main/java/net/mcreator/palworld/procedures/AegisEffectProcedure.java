package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

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
			PalworldMod.queueServerWork(500, () -> {
				PalworldModVariables.WorldVariables.get(world).TestValue = 0;
				PalworldModVariables.WorldVariables.get(world).syncData(world);
			});
			PalworldMod.queueServerWork(5, () -> {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_bool = true;
					_vars.syncPlayerVariables(entity);
				}
			});
			PalworldMod.queueServerWork(300, () -> {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.aegis_tick = 10;
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
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float) 0.5);
							entityiterator.setDeltaMovement(new Vec3(((-0.05) * entityiterator.getX()), ((-0.05) * entityiterator.getY()), ((-0.05) * entityiterator.getZ())));
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
