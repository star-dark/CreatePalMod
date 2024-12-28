
package net.mcreator.palworld.item;

public class FishRedBelliedPiranhaItem extends Item {
	public FishRedBelliedPiranhaItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}