
package net.mcreator.palworld.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FarmerSkillTreeButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FarmerSkillTreeButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "farmer_skill_tree_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, FarmerSkillTreeButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FarmerSkillTreeButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FarmerSkillTreeButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FarmerSkillTreeButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FarmerSkillTreeButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = FarmerSkillTreeMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			HealthUpProcedure.execute(entity);
		}
		if (buttonID == 2) {

			AttackUPProcedure.execute(entity);
		}
		if (buttonID == 3) {

			DefenseUpProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(FarmerSkillTreeButtonMessage.TYPE, FarmerSkillTreeButtonMessage.STREAM_CODEC, FarmerSkillTreeButtonMessage::handleData);
	}

}
