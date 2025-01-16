package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class HealthUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (>0&&<10) {if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
_livingEntity1.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_HEALTH)
? _livingEntity0.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0)+2));}
}
}
