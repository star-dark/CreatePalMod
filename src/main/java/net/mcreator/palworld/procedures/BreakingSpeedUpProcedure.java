package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class BreakingSpeedUpProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points>0&&entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level>=15&&<5) {{
PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
_vars.Skill_Points = entity.getData(PalworldModVariables.PLAYER_VARIABLES).Skill_Points-1;
_vars.syncPlayerVariables(entity);
}
if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.BLOCK_BREAK_SPEED))
_livingEntity1.getAttribute(Attributes.BLOCK_BREAK_SPEED).setBaseValue(((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.BLOCK_BREAK_SPEED)
? _livingEntity0.getAttribute(Attributes.BLOCK_BREAK_SPEED).getBaseValue() : 0)+0.5));if (==5) {if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.LUCK))
_livingEntity3.getAttribute(Attributes.LUCK).setBaseValue(((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.LUCK)
? _livingEntity2.getAttribute(Attributes.LUCK).getBaseValue() : 0)+1));if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uB2F9\uC2E0\uC5D0\uAC8C \uD589\uC6B4\uC774 \uAE43\uB4ED\uB2C8\uB2E4"), false);}}
}
}
