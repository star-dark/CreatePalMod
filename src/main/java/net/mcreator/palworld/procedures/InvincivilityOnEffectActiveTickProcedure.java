package net.mcreator.palworld.procedures;

import net.minecraft.world.entity.Entity;

public class InvincivilityOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setInvisible(true);
	}
}
