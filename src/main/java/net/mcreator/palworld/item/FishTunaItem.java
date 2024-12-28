
package net.mcreator.hello.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class FishTunaItem extends Item {
	public FishTunaItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}
