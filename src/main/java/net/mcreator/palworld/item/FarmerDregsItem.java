
package net.mcreator.palworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FarmerDregsItem extends Item {
	public FarmerDregsItem() {
		super(new Item.Properties().stacksTo(32).rarity(Rarity.COMMON));
	}
}
