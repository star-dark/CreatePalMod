
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

import net.mcreator.palworld.world.inventory.FisherSkillTreeMenu;
import net.mcreator.palworld.procedures.ShieldBoomberUpProcedure;
import net.mcreator.palworld.procedures.ReflectionUpProcedure;
import net.mcreator.palworld.procedures.RecoverUpProcedure;
import net.mcreator.palworld.procedures.MovementSpeedUpProcedure;
import net.mcreator.palworld.procedures.JumpUpProcedure;
import net.mcreator.palworld.procedures.InvisibleUpProcedure;
import net.mcreator.palworld.procedures.HoverUpProcedure;
import net.mcreator.palworld.procedures.HealthUpProcedure;
import net.mcreator.palworld.procedures.FoodFighterUpProcedure;
import net.mcreator.palworld.procedures.FishmanUpProcedure;
import net.mcreator.palworld.procedures.DefenseUpProcedure;
import net.mcreator.palworld.procedures.BerserkerUpProcedure;
import net.mcreator.palworld.procedures.AttackUPProcedure;
import net.mcreator.palworld.procedures.ArcherUpProcedure;
import net.mcreator.palworld.PalworldMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FisherSkillTreeButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FisherSkillTreeButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "fisher_skill_tree_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FisherSkillTreeButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FisherSkillTreeButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FisherSkillTreeButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FisherSkillTreeButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FisherSkillTreeButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = FisherSkillTreeMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			HealthUpProcedure.execute(entity);
		}
		if (buttonID == 1) {

			AttackUPProcedure.execute(entity);
		}
		if (buttonID == 2) {

			DefenseUpProcedure.execute(entity);
		}
		if (buttonID == 3) {

			RecoverUpProcedure.execute(entity);
		}
		if (buttonID == 4) {

			FoodFighterUpProcedure.execute(entity);
		}
		if (buttonID == 5) {

			ReflectionUpProcedure.execute(entity);
		}
		if (buttonID == 6) {

			ShieldBoomberUpProcedure.execute(entity);
		}
		if (buttonID == 7) {

			BerserkerUpProcedure.execute(entity);
		}
		if (buttonID == 8) {

			FishmanUpProcedure.execute(entity);
		}
		if (buttonID == 9) {

			InvisibleUpProcedure.execute(entity);
		}
		if (buttonID == 10) {

			ArcherUpProcedure.execute(entity);
		}
		if (buttonID == 11) {

			HoverUpProcedure.execute(entity);
		}
		if (buttonID == 12) {

			MovementSpeedUpProcedure.execute(entity);
		}
		if (buttonID == 13) {

			JumpUpProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(FisherSkillTreeButtonMessage.TYPE, FisherSkillTreeButtonMessage.STREAM_CODEC, FisherSkillTreeButtonMessage::handleData);
	}
}
