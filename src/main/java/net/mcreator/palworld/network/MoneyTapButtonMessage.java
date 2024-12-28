
package net.mcreator.palworld.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.palworld.world.inventory.MoneyTapMenu;
import net.mcreator.palworld.procedures.GetOchunwonFromUserProcedure;
import net.mcreator.palworld.procedures.GetManwonFromUserProcedure;
import net.mcreator.palworld.procedures.GetChunwonFromUserProcedure;
import net.mcreator.palworld.PalworldMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MoneyTapButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<MoneyTapButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "money_tap_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MoneyTapButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MoneyTapButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new MoneyTapButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<MoneyTapButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MoneyTapButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = MoneyTapMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GetManwonFromUserProcedure.execute(entity);
		}
		if (buttonID == 1) {

			GetOchunwonFromUserProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GetChunwonFromUserProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(MoneyTapButtonMessage.TYPE, MoneyTapButtonMessage.STREAM_CODEC, MoneyTapButtonMessage::handleData);
	}
}
