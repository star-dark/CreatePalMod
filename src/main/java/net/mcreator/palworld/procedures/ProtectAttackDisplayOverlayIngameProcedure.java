package net.mcreator.palworld.procedures;

import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

public class ProtectAttackDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean isShield = false;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).shieldBoomberSkillpoint > 0 && ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
			isShield = true;
		} else {
			isShield = false;
		}
		return isShield;
	}
}
