package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.palworld.network.PalworldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AttackerModeProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity().level(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		if (sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).TransformState == 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)),
					(float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / (10 - sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).transformSkillPoint)));
			item = (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(new Object() {
				public static EquipmentSlot armorSlotByIndex(int _slotindex) {
					for (EquipmentSlot _slot : EquipmentSlot.values()) {
						if (_slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && _slot.getIndex() == _slotindex) {
							return _slot;
						}
					}
					throw new IllegalArgumentException("Invalid slot index: " + _slotindex);
				}
			}.armorSlotByIndex(Mth.nextInt(RandomSource.create(), 0, 3))) : ItemStack.EMPTY);
			item.setDamageValue((int) (item.getDamageValue() + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0)));
		}
	}
}
