package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

public class IsNotMainQuestCompleteProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !IsMainQuestCompleteProcedure.execute(entity);
	}
}
