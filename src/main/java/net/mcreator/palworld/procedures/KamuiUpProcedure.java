package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class KamuiUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=20&&<1) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
}
}
}
