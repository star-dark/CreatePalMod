package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class PheonixProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity ) {
if (
entity == null ) return ;
double time = 0;
if (entity instanceof Player&&0==(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1)&&Mth.nextInt(RandomSource.create(), 1, 100)<=) {if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING)||!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING)) {if (entity instanceof Player _player) {
ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).copy();
_setstack.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).getCount());
ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
}if (entity instanceof LivingEntity _entity) {
ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING).copy();
_setstack.setCount(1);
_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
if (_entity instanceof Player _player) _player.getInventory().setChanged();
}}}
}
}
