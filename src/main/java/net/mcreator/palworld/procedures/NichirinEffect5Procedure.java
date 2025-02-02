package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.PalworldMod;

public class NichirinEffect5Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number == 0) {
				NichirinEffectProcedure.execute(world, x, y, z, entity);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Nichirin_number == 1) {
				if (entity.onGround()) {
					NichirinEffect2Procedure.execute(world, x, y, z, entity);
				} else if (!entity.onGround()) {
					entity.setDeltaMovement(new Vec3(0, (-3), 0));
					PalworldMod.queueServerWork(20, () -> {
						NichirinEffect3Procedure.execute(world, x, y, z, entity);
					});
				}
			}
		}
	}
}
