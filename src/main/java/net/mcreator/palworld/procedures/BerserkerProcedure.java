package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class BerserkerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		execute(null, world, x, y, z, damagesource, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
DamageSource damagesource,
Entity entity ) {
if (
damagesource == null ||
entity == null ) return ;
if (>0&&entity instanceof Player&&(damagesource.getEntity()) instanceof Monster) {if (>=8-) {{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float));if (!(entityiterator instanceof Player)) {entityiterator.push((entityiterator.getLookAngle().x*(-2)), 1, (entityiterator.getLookAngle().z*(-2)));}
}
}if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int)(Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10)*50), (int)Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10), true, true));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int)(Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10)*50), (int)Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10), true, true));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, (int)(Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10)*50), (int)Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10), true, true));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int)(Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10)*50), (int)Math.round(((entity instanceof LivingEntity _livEnt? _livEnt.getMaxHealth():-1)-(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1))/ 10), true, true));}}
}
}
