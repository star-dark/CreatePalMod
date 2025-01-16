
package net.mcreator.palworld.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record JobNpcActionButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<JobNpcActionButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "job_npc_action_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, JobNpcActionButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, JobNpcActionButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new JobNpcActionButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<JobNpcActionButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final JobNpcActionButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = JobNpcActionMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 1) {

			SellActionProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GuiCloseProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(JobNpcActionButtonMessage.TYPE, JobNpcActionButtonMessage.STREAM_CODEC, JobNpcActionButtonMessage::handleData);
	}

}
