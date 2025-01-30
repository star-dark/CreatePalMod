
package net.mcreator.palworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreCoalItem extends Item {
	public OreCoalItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
