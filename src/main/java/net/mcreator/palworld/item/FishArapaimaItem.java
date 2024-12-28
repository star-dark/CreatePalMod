
package net.mcreator.palworld.item;

public class FishArapaimaItem extends Item {
	public FishArapaimaItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}