package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class AttackerModeProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity().level(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
Entity entity,
Entity sourceentity ) {
if (
entity == null ||
sourceentity == null ) return ;
ItemStack item = ItemStack.EMPTY;
if (==0) {entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float)((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue():0)/ (10-))); item = (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(new Object(){
public static EquipmentSlot armorSlotByIndex(int _slotindex) {
for (EquipmentSlot _slot : EquipmentSlot.values()) {
if (_slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && _slot.getIndex() == _slotindex) {
return _slot;
}
}
throw new IllegalArgumentException("Invalid slot index: " + _slotindex);
}
}.armorSlotByIndex(Mth.nextInt(RandomSource.create(), 0, 3))):ItemStack.EMPTY);item.setDamageValue((int)(item.getDamageValue()+(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue():0)));}
}
}
