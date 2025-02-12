package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class FireManProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity) {
		execute(null, damagesource, entity);
	}

private static void execute(
@Nullable Event event,
DamageSource damagesource,
Entity entity ) {
if (
damagesource == null ||
entity == null ) return ;
if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("minecraft:is_fire")))&&>0) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, (int)(20*), 1, false, false));}
}
}
