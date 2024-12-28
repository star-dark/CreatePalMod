
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreEmeraldItem extends Item {
	public OreEmeraldItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
