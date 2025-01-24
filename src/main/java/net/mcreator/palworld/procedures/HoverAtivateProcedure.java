package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
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
public class HoverAtivateProcedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		PacketDistributor.sendToServer(new HoverAtivateMessage());
		execute(event.getLevel(), event.getEntity());
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public record HoverAtivateMessage() implements CustomPacketPayload {
		public static final Type<HoverAtivateMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "procedure_hover_ativate"));
		public static final StreamCodec<RegistryFriendlyByteBuf, HoverAtivateMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HoverAtivateMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new HoverAtivateMessage());

		@Override
		public Type<HoverAtivateMessage> type() {
			return TYPE;
		}

		public static void handleData(final HoverAtivateMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player().level(), context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			PalworldMod.addNetworkMessage(HoverAtivateMessage.TYPE, HoverAtivateMessage.STREAM_CODEC, HoverAtivateMessage::handleData);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!entity.onGround() && entity.getData(PalworldModVariables.PLAYER_VARIABLES).HoverSkillPoint > 0) {
			if (!entity.getData(PalworldModVariables.PLAYER_VARIABLES).BlinkVar && (world.dayTime() >= entity.getData(PalworldModVariables.PLAYER_VARIABLES).timeBuffer || entity.getData(PalworldModVariables.PLAYER_VARIABLES).timeBuffer == 0)) {
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.BlinkVar = true;
					_vars.syncPlayerVariables(entity);
				}
				{
					PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
					_vars.timeBuffer = world.dayTime();
					_vars.syncPlayerVariables(entity);
				}
				entity.setInvisible(true);
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 2), (entity.getLookAngle().y * 2), (entity.getLookAngle().z * 2)));
				entity.setNoGravity(true);
			} else if (world.dayTime() < entity.getData(PalworldModVariables.PLAYER_VARIABLES).timeBuffer) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##").format((entity.getData(PalworldModVariables.PLAYER_VARIABLES).timeBuffer - world.dayTime()) / 20) + "\uCD08 \uB4A4 \uC0AC\uC6A9 \uAC00\uB2A5")),
							true);
			}
		}
	}
}
