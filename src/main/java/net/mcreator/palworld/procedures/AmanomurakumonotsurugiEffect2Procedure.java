package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModParticleTypes;

public class AmanomurakumonotsurugiEffect2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.dayTime() <= entity.getData(PalworldModVariables.PLAYER_VARIABLES).Amanomuraku_tick) {
			world.addParticle((SimpleParticleType) (PalworldModParticleTypes.THUNDER_PARTICLE.get()), x, (y + 1), z, 0, 0, 0);
		}
	}
}
