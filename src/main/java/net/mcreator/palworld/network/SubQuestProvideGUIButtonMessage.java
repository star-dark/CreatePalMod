
package net.mcreator.palworld.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SubQuestProvideGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SubQuestProvideGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "sub_quest_provide_gui_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, SubQuestProvideGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SubQuestProvideGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SubQuestProvideGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<SubQuestProvideGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SubQuestProvideGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SubQuestProvideGUIMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			AcceptButtonPressedProcedure.execute(entity);
		}
		if (buttonID == 1) {

			RejectButtonPressedProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ClosedButtonPressedProcedure.execute(entity);
		}
		if (buttonID == 3) {

			RewardButtonPressedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(SubQuestProvideGUIButtonMessage.TYPE, SubQuestProvideGUIButtonMessage.STREAM_CODEC, SubQuestProvideGUIButtonMessage::handleData);
	}

}
