
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

import net.mcreator.palworld.world.inventory.MinerSkillTreeMenu;
import net.mcreator.palworld.procedures.TransformUpProcedure;
import net.mcreator.palworld.procedures.StepHeightUpProcedure;
import net.mcreator.palworld.procedures.SneakingSpeedUpProcedure;
import net.mcreator.palworld.procedures.PheonixUpProcedure;
import net.mcreator.palworld.procedures.KnockBackUpProcedure;
import net.mcreator.palworld.procedures.KamuiUpProcedure;
import net.mcreator.palworld.procedures.IgnitoUpProcedure;
import net.mcreator.palworld.procedures.HealthUpProcedure;
import net.mcreator.palworld.procedures.FiremanUpProcedure;
import net.mcreator.palworld.procedures.FallingDamageReduceProcedure;
import net.mcreator.palworld.procedures.DefenseUpProcedure;
import net.mcreator.palworld.procedures.BreakingSpeedUpProcedure;
import net.mcreator.palworld.procedures.BlockBreakerUpProcedure;
import net.mcreator.palworld.procedures.AttackUPProcedure;
import net.mcreator.palworld.PalworldMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MinerSkillTreeButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<MinerSkillTreeButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "miner_skill_tree_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MinerSkillTreeButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MinerSkillTreeButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new MinerSkillTreeButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<MinerSkillTreeButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MinerSkillTreeButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = MinerSkillTreeMenu.guistate;
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

			StepHeightUpProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SneakingSpeedUpProcedure.execute(entity);
		}
		if (buttonID == 5) {

			BreakingSpeedUpProcedure.execute(entity);
		}
		if (buttonID == 6) {

			FallingDamageReduceProcedure.execute(entity);
		}
		if (buttonID == 7) {

			KnockBackUpProcedure.execute(entity);
		}
		if (buttonID == 8) {

			KamuiUpProcedure.execute(entity);
		}
		if (buttonID == 9) {

			FiremanUpProcedure.execute(entity);
		}
		if (buttonID == 10) {

			BlockBreakerUpProcedure.execute(entity);
		}
		if (buttonID == 11) {

			IgnitoUpProcedure.execute(entity);
		}
		if (buttonID == 12) {

			TransformUpProcedure.execute(entity);
		}
		if (buttonID == 13) {

			PheonixUpProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(MinerSkillTreeButtonMessage.TYPE, MinerSkillTreeButtonMessage.STREAM_CODEC, MinerSkillTreeButtonMessage::handleData);
	}
}
