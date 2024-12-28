
package net.mcreator.palworld.network;

import net.mcreator.palworld.PalworldMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record OpenQuestGUIMessage(int eventType, int pressedms) implements CustomPacketPayload {

	public static final Type<OpenQuestGUIMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "key_open_quest_gui"));

	public static final StreamCodec<RegistryFriendlyByteBuf, OpenQuestGUIMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenQuestGUIMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenQuestGUIMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenQuestGUIMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenQuestGUIMessage message, final IPayloadContext context) {
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

			OpenQuestGUIOnKeyPressedProcedure.execute(world, x, y, z, entity);
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(OpenQuestGUIMessage.TYPE, OpenQuestGUIMessage.STREAM_CODEC, OpenQuestGUIMessage::handleData);
	}

}
