
package net.mcreator.palworld.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.entity.player.Player;

import net.mcreator.palworld.procedures.FishRodEffectProcedure;

public class FishRodLv30Item extends FishingRodItem {
	public FishRodLv30Item() {
		super(new Item.Properties().durability(10000));
	}

	@Override
	public int getEnchantmentValue() {
		return 2;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		FishRodEffectProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
