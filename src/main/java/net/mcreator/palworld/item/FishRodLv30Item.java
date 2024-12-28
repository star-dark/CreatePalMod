
package net.mcreator.palworld.item;

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
