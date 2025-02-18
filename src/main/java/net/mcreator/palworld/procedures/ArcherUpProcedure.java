package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class ArcherUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=10&&<4&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).AttackUpSkillPoint>=5&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).HealthUpSkillPoint>=5) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
}
}
}
