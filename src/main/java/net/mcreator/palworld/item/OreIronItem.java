
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreIronItem extends Item {
	public OreIronItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
