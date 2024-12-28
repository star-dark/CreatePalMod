
package net.mcreator.palworld.item;

public class ChunwonItem extends Item {
	public ChunwonItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ChunwonRightclickedProcedure.execute(entity);
		return ar;
	}
}