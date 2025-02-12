
package net.mcreator.palworld.network;

import net.mcreator.palworld.PalworldMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record TransformMessage(int eventType, int pressedms) implements CustomPacketPayload {

	public static final Type<TransformMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "key_transform"));

	public static final StreamCodec<RegistryFriendlyByteBuf, TransformMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TransformMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new TransformMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TransformMessage> type() {
		return TYPE;
	}

	public static void handleData(final TransformMessage message, final IPayloadContext context) {
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

		if (type == 1) {

			TransformkireulnoheulddaeProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(TransformMessage.TYPE, TransformMessage.STREAM_CODEC, TransformMessage::handleData);
	}

}
