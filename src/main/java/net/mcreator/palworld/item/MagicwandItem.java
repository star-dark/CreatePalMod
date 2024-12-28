
package net.mcreator.hello.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.hello.procedures.EarnMoneyProcedure;
import net.mcreator.hello.procedures.ClearaitemeulsonedeulgoissneungyeonguProcedure;

public class MagicwandItem extends Item {
	public MagicwandItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		EarnMoneyProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ClearaitemeulsonedeulgoissneungyeonguProcedure.execute(entity);
	}
}
