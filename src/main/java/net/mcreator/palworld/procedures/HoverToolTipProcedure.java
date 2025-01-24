package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class HoverToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String tooltip = "";
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).DoubleJumpSkillPoint == 0) {
			tooltip = "\uB545\uC5D0 \uC788\uC9C0\uC54A\uC744 \uB54C \uD558\uB298\uC5D0 \uC88C\uD074\uB9AD \uC2DC 1\uCD08\uAC04 \uBB34\uC911\uB825\uC0C1\uD0DC \uB3CC\uC9C4 \uBC0F \uC740\uC2E0(\uB354\uBE14\uC810\uD504 \uC120\uD0DD \uC2DC \uC120\uD0DD\uBD88\uAC00)";
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).DoubleJumpSkillPoint == 1) {
			tooltip = "\uBC30\uC6B8 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4";
		}
		return tooltip;
	}
}
