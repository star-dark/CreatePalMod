package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class SweapDamageUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&<5) {if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SWEEPING_DAMAGE_RATIO))
_livingEntity0.getAttribute(Attributes.SWEEPING_DAMAGE_RATIO).setBaseValue((/ (+1)));{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
}
}
}
