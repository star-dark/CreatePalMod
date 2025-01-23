package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class ReflectionProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getSource().getDirectEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, Entity immediatesourceentity) {
		execute(null, damagesource, entity, immediatesourceentity);
	}

private static void execute(
@Nullable Event event,
DamageSource damagesource,
Entity entity,
Entity immediatesourceentity ) {
if (
damagesource == null ||
entity == null ||
immediatesourceentity == null ) return ;
if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBlocking()&&>0) {immediatesourceentity.hurt(damagesource, (float));immediatesourceentity.push((entity.getLookAngle().x*Math.sqrt()), Math.log(), (entity.getLookAngle().z*Math.sqrt()));}
}
}
