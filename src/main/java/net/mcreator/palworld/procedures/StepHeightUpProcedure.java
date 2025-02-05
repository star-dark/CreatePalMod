package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class StepHeightUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=10&&<4&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).AttackUpSkillPoint>=5&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint>=5) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.STEP_HEIGHT))
_livingEntity1.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.STEP_HEIGHT)
? _livingEntity0.getAttribute(Attributes.STEP_HEIGHT).getBaseValue() : 0)+0.5));}
}
}
