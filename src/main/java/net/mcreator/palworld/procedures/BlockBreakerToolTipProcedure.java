package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class BlockBreakerToolTipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\uAD11\uBB3C\uC744 \uCE90\uBA74 " + new java.text.DecimalFormat("##%").format(entity.getData(PalworldModVariables.PLAYER_VARIABLES).blockBreakerSkillPoint / 100)
				+ "\uD655\uB960\uB85C \uB79C\uB364 \uB2A5\uB825\uCE58 \uC601\uAD6C\uC801\uC73C\uB85C \uD68D\uB4DD";
	}
}
