
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

import net.mcreator.palworld.world.inventory.FarmerSellGuiMenu;
import net.mcreator.palworld.procedures.GuiCloseProcedure;
import net.mcreator.palworld.procedures.FarmerSell2Procedure;
import net.mcreator.palworld.procedures.FarmerSell1Procedure;
import net.mcreator.palworld.procedures.FarmerSell0Procedure;
import net.mcreator.palworld.PalworldMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FarmerSellGuiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FarmerSellGuiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "farmer_sell_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FarmerSellGuiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FarmerSellGuiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FarmerSellGuiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FarmerSellGuiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FarmerSellGuiButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = FarmerSellGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GuiCloseProcedure.execute(entity);
		}
		if (buttonID == 1) {

			FarmerSell0Procedure.execute(entity);
		}
		if (buttonID == 2) {

			FarmerSell1Procedure.execute(entity);
		}
		if (buttonID == 3) {

			FarmerSell2Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(FarmerSellGuiButtonMessage.TYPE, FarmerSellGuiButtonMessage.STREAM_CODEC, FarmerSellGuiButtonMessage::handleData);
	}
}
