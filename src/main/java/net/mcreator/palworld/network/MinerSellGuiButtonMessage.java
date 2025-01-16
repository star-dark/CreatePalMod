
package net.mcreator.palworld.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MinerSellGuiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<MinerSellGuiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "miner_sell_gui_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, MinerSellGuiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MinerSellGuiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new MinerSellGuiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<MinerSellGuiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MinerSellGuiButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = MinerSellGuiMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			MinerSell0Procedure.execute(entity);
		}
		if (buttonID == 1) {

			MinerSell1Procedure.execute(entity);
		}
		if (buttonID == 2) {

			MinerSell2Procedure.execute(entity);
		}
		if (buttonID == 3) {

			MinerSell3Procedure.execute(entity);
		}
		if (buttonID == 4) {

			MinerSell4Procedure.execute(entity);
		}
		if (buttonID == 5) {

			MinerSell5Procedure.execute(entity);
		}
		if (buttonID == 6) {

			MinerSell6Procedure.execute(entity);
		}
		if (buttonID == 7) {

			GuiCloseProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(MinerSellGuiButtonMessage.TYPE, MinerSellGuiButtonMessage.STREAM_CODEC, MinerSellGuiButtonMessage::handleData);
	}

}
