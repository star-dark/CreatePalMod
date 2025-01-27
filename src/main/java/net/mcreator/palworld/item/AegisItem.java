
package net.mcreator.palworld.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class AegisItem extends Item {
	public AegisItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal(
				"\uC544\uC774\uAE30\uC2A4 : \uC801\uB4E4\uACFC \uD22C\uC0AC\uCCB4\uB97C \uBC00\uCCD0\uB0B8\uB2E4. \uC6B0\uD074\uB9AD\uC73C\uB85C on/off\uB97C \uD560 \uC218 \uC788\uC73C\uBA70, off\uC2DC \uC0AC\uC6A9\uC2DC\uAC04\uC774 \uCDA9\uC804\uB41C\uB2E4."));
	}
}
