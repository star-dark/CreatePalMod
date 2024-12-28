
package net.mcreator.palworld.item;

public class MagicWandItem extends Item {
	public MagicWandItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ClearVariableProcedure.execute(entity);
	}
}