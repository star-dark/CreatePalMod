package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber(value = {Dist.CLIENT})
public class ThrowKusanagiProcedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		PacketDistributor.sendToServer(new ThrowKusanagiMessage());
		execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public record ThrowKusanagiMessage() implements CustomPacketPayload {
		public static final Type<ThrowKusanagiMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "procedure_throw_kusanagi"));
		public static final StreamCodec<RegistryFriendlyByteBuf, ThrowKusanagiMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ThrowKusanagiMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new ThrowKusanagiMessage());

		@Override
		public Type<ThrowKusanagiMessage> type() {
			return TYPE;
		}

		public static void handleData(final ThrowKusanagiMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player().level(), context.player().getX(), context.player().getY(), context.player().getZ(), context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			PalworldMod.addNetworkMessage(ThrowKusanagiMessage.TYPE, ThrowKusanagiMessage.STREAM_CODEC, ThrowKusanagiMessage::handleData);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
if (entity.isShiftKeyDown()&&&&==1) {if (world instanceof ServerLevel projectileLevel) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
AbstractArrow entityToSpawn = new KusanagiEntity(PalworldModEntities.DELETED_MOD_ELEMENT.get(), level) {
@Override public byte getPierceLevel() {
return piercing;
}
@Override protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
if (knockback > 0) {
double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
if (vec3.lengthSqr() > 0.0) {
livingEntity.push(vec3.x, 0.1, vec3.z);
}
}
}
};
entityToSpawn.setOwner(shooter);
entityToSpawn.setBaseDamage(damage);
entityToSpawn.setSilent(true);
entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
return entityToSpawn;
}
}.getArrow(projectileLevel, entity, 0, 1, (byte) 0);
_entityToSpawn.setPos(x, (y+1), z);
_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 3, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}}
}
}
