
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

import net.mcreator.palworld.world.inventory.SubQuestCompleteMenu;
import net.mcreator.palworld.procedures.RewardButtonPressedProcedure;
import net.mcreator.palworld.procedures.RejectButtonPressedProcedure;
import net.mcreator.palworld.procedures.ClosedButtonPressedProcedure;
import net.mcreator.palworld.procedures.AcceptButtonPressedProcedure;
import net.mcreator.palworld.PalworldMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SubQuestCompleteButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SubQuestCompleteButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "sub_quest_complete_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SubQuestCompleteButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SubQuestCompleteButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SubQuestCompleteButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SubQuestCompleteButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SubQuestCompleteButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = SubQuestCompleteMenu.guistate;
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
		PalworldMod.addNetworkMessage(SubQuestCompleteButtonMessage.TYPE, SubQuestCompleteButtonMessage.STREAM_CODEC, SubQuestCompleteButtonMessage::handleData);
	}
}
