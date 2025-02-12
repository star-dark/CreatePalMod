package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class KnockBackUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=15&&<5) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
_livingEntity1.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)
? _livingEntity0.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0)+0.5));if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
_livingEntity3.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)
? _livingEntity2.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0)+0.5));}
}
}
