package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class ArcherProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
DamageSource damagesource,
Entity entity,
Entity sourceentity ) {
if (
damagesource == null ||
entity == null ||
sourceentity == null ) return ;
if (sourceentity instanceof Player) {if (!(entity instanceof Player)==(damagesource.is(DamageTypes.ARROW)&&!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)))) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));}else if (!(entity instanceof Player)==((damagesource.is(DamageTypes.ARROW)&&entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))==(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ?
_livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0)<3)) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, (int)((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ?
_livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0)+1)));}else if (!(entity instanceof Player)==(damagesource.is(DamageTypes.ARROW)&&(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ?
_livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0)==3)) {if (world instanceof Level _level && !_level.isClientSide())
_level.explode(null, x, y, z, (float)(/ 2), Level.ExplosionInteraction.NONE);}}
}
}
