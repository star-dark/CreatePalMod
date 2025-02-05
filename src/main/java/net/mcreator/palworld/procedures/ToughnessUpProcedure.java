package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class ToughnessUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&<5) {if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
_livingEntity1.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)
? _livingEntity0.getAttribute(Attributes.ARMOR_TOUGHNESS).getBaseValue() : 0)+0.5));{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
}
}
}
