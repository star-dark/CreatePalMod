package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class NichirinEffect5Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.dayTime() >= entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_cool) {
			if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number == 0) {
				NichirinEffectProcedure.execute(world, x, y, z, entity);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number == 2) {
				if (entity.onGround()) {
					NichirinEffect2Procedure.execute(world, x, y, z, entity);
				} else if (!entity.onGround()) {
					entity.setDeltaMovement(new Vec3(0, (-3), 0));
					{
						PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
						_vars.Nichirin_tick = world.dayTime() + 5;
						_vars.syncPlayerVariables(entity);
					}
					NichirinEffect6Procedure.execute(world, x, y, z, entity);
				}
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number == 1) {
				NichirinEffect7Procedure.execute(world, x, y, z, entity);
			}
		}
	}
}
