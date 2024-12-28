
package net.mcreator.palworld.item;

public class FishHailbutItem extends Item {
	public FishHailbutItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}