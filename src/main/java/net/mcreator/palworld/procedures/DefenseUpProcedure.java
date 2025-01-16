package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class DefenseUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (>0&&<10) {if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ARMOR))
_livingEntity1.getAttribute(Attributes.ARMOR).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ARMOR)
? _livingEntity0.getAttribute(Attributes.ARMOR).getBaseValue() : 0)+2));}
}
}
