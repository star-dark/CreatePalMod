
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
import net.mcreator.palworld.procedures.ToughnessUpProcedure;
import net.mcreator.palworld.procedures.SweapDamageUpProcedure;
import net.mcreator.palworld.procedures.ShieldBoomberUpProcedure;
import net.mcreator.palworld.procedures.ScaleUpProcedure;
import net.mcreator.palworld.procedures.ReflectionUpProcedure;
import net.mcreator.palworld.procedures.RecoverUpProcedure;
import net.mcreator.palworld.procedures.RangeUpProcedure;
import net.mcreator.palworld.procedures.KnockBackResistanceProcedure;
import net.mcreator.palworld.procedures.HealthUpProcedure;
import net.mcreator.palworld.procedures.FoodFighterUpProcedure;
import net.mcreator.palworld.procedures.DoubleJumpUpProcedure;
import net.mcreator.palworld.procedures.DefenseUpProcedure;
import net.mcreator.palworld.procedures.BerserkerUpProcedure;
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

			RangeUpProcedure.execute(entity);
		}
		if (buttonID == 2) {

			AttackUPProcedure.execute(entity);
		}
		if (buttonID == 3) {

			DefenseUpProcedure.execute(entity);
		}
		if (buttonID == 4) {

			RecoverUpProcedure.execute(entity);
		}
		if (buttonID == 5) {

			FoodFighterUpProcedure.execute(entity);
		}
		if (buttonID == 6) {

			ReflectionUpProcedure.execute(entity);
		}
		if (buttonID == 7) {

			DoubleJumpUpProcedure.execute(entity);
		}
		if (buttonID == 8) {

			ShieldBoomberUpProcedure.execute(entity);
		}
		if (buttonID == 9) {

			ScaleUpProcedure.execute(entity);
		}
		if (buttonID == 10) {

			ToughnessUpProcedure.execute(entity);
		}
		if (buttonID == 11) {

			KnockBackResistanceProcedure.execute(entity);
		}
		if (buttonID == 12) {

			SweapDamageUpProcedure.execute(entity);
		}
		if (buttonID == 13) {

			BerserkerUpProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(MinerSkillTreeButtonMessage.TYPE, MinerSkillTreeButtonMessage.STREAM_CODEC, MinerSkillTreeButtonMessage::handleData);
	}
}
