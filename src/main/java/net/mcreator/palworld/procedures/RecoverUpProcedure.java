package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class RecoverUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&<5&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=10) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int)Double.POSITIVE_INFINITY, (int)));}
}
}
