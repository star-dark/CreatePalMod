
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

import net.mcreator.palworld.world.inventory.FisherSellGuiMenu;
import net.mcreator.palworld.procedures.GuiCloseProcedure;
import net.mcreator.palworld.procedures.FisherSell9Procedure;
import net.mcreator.palworld.procedures.FisherSell8Procedure;
import net.mcreator.palworld.procedures.FisherSell7Procedure;
import net.mcreator.palworld.procedures.FisherSell6Procedure;
import net.mcreator.palworld.procedures.FisherSell5Procedure;
import net.mcreator.palworld.procedures.FisherSell4Procedure;
import net.mcreator.palworld.procedures.FisherSell3Procedure;
import net.mcreator.palworld.procedures.FisherSell2Procedure;
import net.mcreator.palworld.procedures.FisherSell1Procedure;
import net.mcreator.palworld.procedures.FisherSell17Procedure;
import net.mcreator.palworld.procedures.FisherSell16Procedure;
import net.mcreator.palworld.procedures.FisherSell15Procedure;
import net.mcreator.palworld.procedures.FisherSell14Procedure;
import net.mcreator.palworld.procedures.FisherSell13Procedure;
import net.mcreator.palworld.procedures.FisherSell12Procedure;
import net.mcreator.palworld.procedures.FisherSell11Procedure;
import net.mcreator.palworld.procedures.FisherSell10Procedure;
import net.mcreator.palworld.procedures.FisherSell0Procedure;
import net.mcreator.palworld.PalworldMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FisherSellGuiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FisherSellGuiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "fisher_sell_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FisherSellGuiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FisherSellGuiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FisherSellGuiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FisherSellGuiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FisherSellGuiButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = FisherSellGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			FisherSell2Procedure.execute(entity);
		}
		if (buttonID == 1) {

			FisherSell0Procedure.execute(entity);
		}
		if (buttonID == 2) {

			FisherSell1Procedure.execute(entity);
		}
		if (buttonID == 3) {

			FisherSell3Procedure.execute(entity);
		}
		if (buttonID == 4) {

			FisherSell4Procedure.execute(entity);
		}
		if (buttonID == 5) {

			FisherSell5Procedure.execute(entity);
		}
		if (buttonID == 6) {

			FisherSell6Procedure.execute(entity);
		}
		if (buttonID == 7) {

			FisherSell7Procedure.execute(entity);
		}
		if (buttonID == 8) {

			FisherSell8Procedure.execute(entity);
		}
		if (buttonID == 9) {

			FisherSell9Procedure.execute(entity);
		}
		if (buttonID == 10) {

			FisherSell10Procedure.execute(entity);
		}
		if (buttonID == 11) {

			FisherSell11Procedure.execute(entity);
		}
		if (buttonID == 12) {

			FisherSell12Procedure.execute(entity);
		}
		if (buttonID == 13) {

			FisherSell13Procedure.execute(entity);
		}
		if (buttonID == 14) {

			FisherSell14Procedure.execute(entity);
		}
		if (buttonID == 15) {

			FisherSell15Procedure.execute(entity);
		}
		if (buttonID == 16) {

			FisherSell16Procedure.execute(entity);
		}
		if (buttonID == 17) {

			FisherSell17Procedure.execute(entity);
		}
		if (buttonID == 18) {

			GuiCloseProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(FisherSellGuiButtonMessage.TYPE, FisherSellGuiButtonMessage.STREAM_CODEC, FisherSellGuiButtonMessage::handleData);
	}
}
