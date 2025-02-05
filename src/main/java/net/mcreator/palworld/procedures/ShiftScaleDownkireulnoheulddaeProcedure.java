package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class ShiftScaleDownkireulnoheulddaeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SCALE))
			_livingEntity0.getAttribute(Attributes.SCALE).setBaseValue(1);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.NIGHT_VISION);
	}
}
