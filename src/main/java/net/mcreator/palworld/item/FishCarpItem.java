
package net.mcreator.palworld.item;

public class FishCarpItem extends Item {
	public FishCarpItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}