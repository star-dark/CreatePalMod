package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber(value = {Dist.CLIENT})
public class KamuiProcedure {
	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickEmpty event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		PacketDistributor.sendToServer(new KamuiMessage());
		execute(event.getEntity());
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public record KamuiMessage() implements CustomPacketPayload {
		public static final Type<KamuiMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "procedure_kamui"));
		public static final StreamCodec<RegistryFriendlyByteBuf, KamuiMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KamuiMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new KamuiMessage());

		@Override
		public Type<KamuiMessage> type() {
			return TYPE;
		}

		public static void handleData(final KamuiMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			PalworldMod.addNetworkMessage(KamuiMessage.TYPE, KamuiMessage.STREAM_CODEC, KamuiMessage::handleData);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity ) {
if (
entity == null ) return ;
if (entity.isShiftKeyDown()&&) {{
Entity _ent = entity;
_ent.teleportTo(,,);
if (_ent instanceof ServerPlayer _serverPlayer)
_serverPlayer.connection.teleport(, , , _ent.getYRot(), _ent.getXRot());
}}
}
}
