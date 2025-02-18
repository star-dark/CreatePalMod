package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class MovementSpeedUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=15&&<5) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
_livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
? _livingEntity0.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)+0.01));}
}
}
