package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class HoverUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&<1&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=20&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).DoubleJumpSkillPoint==0) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
}
}
}
