
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreCoalItem extends Item {
	public OreCoalItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
