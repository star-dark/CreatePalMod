
package net.mcreator.palworld.item;

public class FishElectricEelItem extends Item {
	public FishElectricEelItem() {
		super(new Item.Properties().stacksTo(2).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}