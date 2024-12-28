
package net.mcreator.hello.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.entity.player.Player;

import net.mcreator.hello.procedures.FishRodEffectProcedure;

public class FishRodLv15Item extends FishingRodItem {
	public FishRodLv15Item() {
		super(new Item.Properties().durability(10000));
	}

	@Override
	public int getEnchantmentValue() {
		return 5;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		FishRodEffectProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
