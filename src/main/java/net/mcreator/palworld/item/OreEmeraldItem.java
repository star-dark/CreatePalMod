
package net.mcreator.palworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreEmeraldItem extends Item {
	public OreEmeraldItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
