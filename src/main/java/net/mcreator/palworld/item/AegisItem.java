
package net.mcreator.palworld.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.palworld.procedures.AegisEffect2Procedure;
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
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		AegisEffect2Procedure.execute(entity);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		AegisEffect2Procedure.execute(context.getPlayer());
		return InteractionResult.SUCCESS;
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\uD5E4\uD30C\uC774\uD1A0\uC2A4\uAC00 \uC81C\uC791\uD55C \uC2E0\uB4E4\uC758 \uBC29\uD328."));
		list.add(Component.literal(""));
		list.add(Component.literal("\uC801\uB4E4\uACFC \uD22C\uC0AC\uCCB4\uB97C \uBC00\uCCD0\uB0B8\uB2E4."));
		list.add(Component.literal("\uC6B0\uD074\uB9AD\uC73C\uB85C on/off\uB97C \uD560 \uC218 \uC788\uC73C\uBA70, off\uC2DC \uC0AC\uC6A9\uC2DC\uAC04\uC774 \uCDA9\uC804\uB41C\uB2E4."));
	}
}
