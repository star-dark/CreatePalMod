
package net.mcreator.palworld.item;

public class FishPerchItem extends Item {
	public FishPerchItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}