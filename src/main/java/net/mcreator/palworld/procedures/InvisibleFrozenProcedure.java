package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class InvisibleFrozenProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity ) {
if (
entity == null ) return ;
if (entity.isInvisible()) {entity.setTicksFrozen((int)(entity.getTicksFrozen()+5-/ 2));}
}
}
