
package net.mcreator.palworld.network;

import net.mcreator.palworld.PalworldMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record DoubleJumpKeyMessage(int eventType, int pressedms) implements CustomPacketPayload {

	public static final Type<DoubleJumpKeyMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "key_double_jump_key"));

	public static final StreamCodec<RegistryFriendlyByteBuf, DoubleJumpKeyMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DoubleJumpKeyMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new DoubleJumpKeyMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<DoubleJumpKeyMessage> type() {
		return TYPE;
	}

	public static void handleData(final DoubleJumpKeyMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			DoubleJumpOnKeyPressedProcedure.execute(entity);
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(DoubleJumpKeyMessage.TYPE, DoubleJumpKeyMessage.STREAM_CODEC, DoubleJumpKeyMessage::handleData);
	}

}