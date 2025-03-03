package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.PalworldMod;

import javax.annotation.Nullable;

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

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && entity.getData(PalworldModVariables.PLAYER_VARIABLES).KamuiActivate) {
			{
				Entity _ent = entity;
				_ent.teleportTo(entity.getData(PalworldModVariables.PLAYER_VARIABLES).KusanagiLocateX, entity.getData(PalworldModVariables.PLAYER_VARIABLES).KusanagiLocateY, entity.getData(PalworldModVariables.PLAYER_VARIABLES).KusanagiLocateZ);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(entity.getData(PalworldModVariables.PLAYER_VARIABLES).KusanagiLocateX, entity.getData(PalworldModVariables.PLAYER_VARIABLES).KusanagiLocateY,
							entity.getData(PalworldModVariables.PLAYER_VARIABLES).KusanagiLocateZ, _ent.getYRot(), _ent.getXRot());
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.KusanagiLocateX = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.KusanagiLocateY = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.KusanagiLocateZ = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.ThrowKusanagiActivate = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.KamuiActivate = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
