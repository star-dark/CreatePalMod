
package net.mcreator.palworld.item;

public class ManwonItem extends Item {
	public ManwonItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ManwonRightclickedProcedure.execute(entity);
		return ar;
	}
}