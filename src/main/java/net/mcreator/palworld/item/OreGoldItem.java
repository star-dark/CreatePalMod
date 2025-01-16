
package net.mcreator.palworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OreGoldItem extends Item {
	public OreGoldItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
