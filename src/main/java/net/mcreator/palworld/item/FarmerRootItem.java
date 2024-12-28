
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FarmerRootItem extends Item {
	public FarmerRootItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
