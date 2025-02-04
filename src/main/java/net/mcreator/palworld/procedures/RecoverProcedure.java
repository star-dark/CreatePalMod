package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class RecoverProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.REGENERATION) ? _livEnt.getEffect(MobEffects.REGENERATION).getDuration() : 0) == 0 && entity.getData(PalworldModVariables.PLAYER_VARIABLES).RecoverSkillPoint > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) Double.POSITIVE_INFINITY, (int) Math.floor(entity.getData(PalworldModVariables.PLAYER_VARIABLES).RecoverSkillPoint / 2 - 1)));
		}
	}
}
