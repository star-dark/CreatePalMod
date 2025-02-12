package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class BlockbreakerProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
BlockState blockstate,
Entity entity ) {
if (
entity == null ) return ;
double rn = 0;
if (entity instanceof Player&&world.getBlockState(BlockPos.containing(x,y,z)).getDestroySpeed(world, BlockPos.containing(x,y,z))>=3&&(BuiltInRegistries.BLOCK.getKey(blockstate.getBlock()).toString()).contains("ore")) {rn = Mth.nextInt(RandomSource.create(), 1, 1000);if (rn<*10) {if (rn%3==0) {if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
_livingEntity6.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
? _livingEntity5.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0)+0.5));if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uACF5\uACA9\uB825\uC774 0.1 \uC99D\uAC00\uD588\uC2B5\uB2C8\uB2E4!"), true);}else if (rn%3==1) {if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
_livingEntity9.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MAX_HEALTH)
? _livingEntity8.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0)+1));if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uCD5C\uB300\uCCB4\uB825\uC774 1 \uC99D\uAC00\uD588\uC2B5\uB2C8\uB2E4!"), true);}else{if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
_livingEntity12.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
? _livingEntity11.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0)+0.001));if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uC774\uB3D9\uC18D\uB3C4\uAC00 1% \uC99D\uAC00\uD588\uC2B5\uB2C8\uB2E4!"), true);}}}
}
}
