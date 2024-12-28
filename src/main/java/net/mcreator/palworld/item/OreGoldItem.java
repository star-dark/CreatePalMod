
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreGoldItem extends Item {
	public OreGoldItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
