
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreDiamondItem extends Item {
	public OreDiamondItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
