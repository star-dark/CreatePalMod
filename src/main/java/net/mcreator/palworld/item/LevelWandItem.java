
package net.mcreator.palworld.item;

public class LevelWandItem extends Item {
	public LevelWandItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		MagicWandentitigaaitemeulhwidureulddaeProcedure.execute();
		return retval;
	}
}