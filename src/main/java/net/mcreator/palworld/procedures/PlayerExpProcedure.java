package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class PlayerExpProcedure {
	public static String execute() {
		return new java.text.DecimalFormat("##/").format();
	}
}
