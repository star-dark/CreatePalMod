
package net.mcreator.palworld.item;

public class FishBlueGillItem extends Item {
	public FishBlueGillItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}