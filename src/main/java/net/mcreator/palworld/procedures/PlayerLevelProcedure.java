package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class PlayerLevelProcedure {
	public static String execute() {
		return new java.text.DecimalFormat("##LV").format();
	}
}
