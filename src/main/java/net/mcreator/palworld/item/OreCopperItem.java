
package net.mcreator.palworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreCopperItem extends Item {
	public OreCopperItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
