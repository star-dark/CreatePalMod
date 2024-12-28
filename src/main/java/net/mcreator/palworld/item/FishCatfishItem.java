
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class FishCatfishItem extends Item {
	public FishCatfishItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}
