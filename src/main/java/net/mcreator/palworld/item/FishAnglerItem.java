
package net.mcreator.palworld.item;

public class FishAnglerItem extends Item {
	public FishAnglerItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}