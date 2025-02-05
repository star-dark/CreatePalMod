package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class ShiftScaleDownOnKeyPressedProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (>0) {if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SCALE))
_livingEntity0.getAttribute(Attributes.SCALE).setBaseValue((1-0.1*));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (int)Double.POSITIVE_INFINITY, 1));}
}
}
