package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class IgnitoActivateProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity sourceentity ) {
if (
sourceentity == null ) return ;
if (!(sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PalworldModMobEffects.IGNITO))&&>0) {if(sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(PalworldModMobEffects.IGNITO, 60, 1));{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((10+*2) / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator instanceof Player)) {entityiterator.igniteForSeconds(5);}
}
}}
}
}
