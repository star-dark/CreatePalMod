package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class FishmanUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=15&&<5) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED))
_livingEntity1.getAttribute(NeoForgeMod.SWIM_SPEED).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(NeoForgeMod.SWIM_SPEED)
? _livingEntity0.getAttribute(NeoForgeMod.SWIM_SPEED).getBaseValue() : 0)+1));if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.OXYGEN_BONUS))
_livingEntity3.getAttribute(Attributes.OXYGEN_BONUS).setBaseValue(((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.OXYGEN_BONUS)
? _livingEntity2.getAttribute(Attributes.OXYGEN_BONUS).getBaseValue() : 0)+1));if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.SUBMERGED_MINING_SPEED))
_livingEntity5.getAttribute(Attributes.SUBMERGED_MINING_SPEED).setBaseValue(((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.SUBMERGED_MINING_SPEED)
? _livingEntity4.getAttribute(Attributes.SUBMERGED_MINING_SPEED).getBaseValue() : 0)+0.2));if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY))
_livingEntity7.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).setBaseValue(((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY)
? _livingEntity6.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).getBaseValue() : 0)+1));}
}
}
