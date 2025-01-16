
package net.mcreator.palworld.item;

public class FishMuskellungeItem extends Item {
	public FishMuskellungeItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}