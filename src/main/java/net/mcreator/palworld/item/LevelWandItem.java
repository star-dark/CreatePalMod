
package net.mcreator.palworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;

import net.mcreator.palworld.procedures.MagicWandentitigaaitemeulhwidureulddaeProcedure;

public class LevelWandItem extends Item {
	public LevelWandItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		MagicWandentitigaaitemeulhwidureulddaeProcedure.execute(entity);
		return retval;
	}
}
