
package net.mcreator.palworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class FishRedBelliedPiranhaItem extends Item {
	public FishRedBelliedPiranhaItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}
