
package net.mcreator.palworld.item;

public class FishRodLv15Item extends FishingRodItem {
	public FishRodLv15Item() {
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
