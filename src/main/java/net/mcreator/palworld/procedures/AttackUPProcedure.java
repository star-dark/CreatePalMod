package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class AttackUPProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (>0&&<10) {if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
_livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
? _livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0)+1));}
}
}
