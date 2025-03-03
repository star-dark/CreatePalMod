package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TridentPickUpProcedure {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Pre event) {
		execute(event, event.getPlayer().level(), event.getPlayer(), event.getItemEntity().getItem());
	}

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		execute(null, world, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == Items.TRIDENT && entity.getData(PalworldModVariables.PLAYER_VARIABLES).TridentSkillPoint > 0 && !(itemstack.getDisplayName().getString()).equals("\uD3EC\uC138\uC774\uB3C8\uC758 \uCC3D")) {
			itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY), 3);
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\uD3EC\uC138\uC774\uB3C8\uC758 \uCC3D"));
		} else if (itemstack.getItem() == Items.TRIDENT && entity.getData(PalworldModVariables.PLAYER_VARIABLES).TridentSkillPoint == 0 && (itemstack.getDisplayName().getString()).equals("\uD3EC\uC138\uC774\uB3C8\uC758 \uCC3D")) {
			EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY))));
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\uC0BC\uC9C0\uCC3D"));
		}
	}
}
