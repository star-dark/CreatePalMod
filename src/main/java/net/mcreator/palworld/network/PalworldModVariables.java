package net.mcreator.palworld.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.palworld.PalworldMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PalworldModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PalworldMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PalworldMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.job_production = original.job_production;
			clone.MainQuestContents = original.MainQuestContents;
			clone.SubQuestContents = original.SubQuestContents;
			clone.MainQuestGoal = original.MainQuestGoal;
			clone.SubQuestGoal = original.SubQuestGoal;
			clone.MainQuestProgress = original.MainQuestProgress;
			clone.SubQuestProgress = original.SubQuestProgress;
			clone.IsMainQuestExist = original.IsMainQuestExist;
			clone.IsSubQuestExist = original.IsSubQuestExist;
			clone.my_money = original.my_money;
			clone.MainQuestRewardMoney = original.MainQuestRewardMoney;
			clone.SubQuestRewardMoney = original.SubQuestRewardMoney;
			if (!event.isWasDeath()) {
				clone.talk_with = original.talk_with;
				clone.quest_buffer = original.quest_buffer;
				clone.MainQuestRequest = original.MainQuestRequest;
				clone.SubQuestRequest = original.SubQuestRequest;
				clone.MainRewardRequest = original.MainRewardRequest;
				clone.SubRewardRequest = original.SubRewardRequest;
				clone.RewardMoneyBuffer = original.RewardMoneyBuffer;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public String job_production = "\"\"";
		public String talk_with = "\"\"";
		public String quest_buffer = "\"\"";
		public String MainQuestContents = "\"\"";
		public String SubQuestContents = "\"\"";
		public double MainQuestGoal = 0;
		public double SubQuestGoal = 0;
		public double MainQuestProgress = 0;
		public double SubQuestProgress = 0;
		public boolean IsMainQuestExist = false;
		public boolean IsSubQuestExist = false;
		public boolean MainQuestRequest = false;
		public boolean SubQuestRequest = false;
		public boolean MainRewardRequest = false;
		public boolean SubRewardRequest = false;
		public double my_money = 0;
		public double RewardMoneyBuffer = 0;
		public double MainQuestRewardMoney = 0;
		public double SubQuestRewardMoney = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("job_production", job_production);
			nbt.putString("talk_with", talk_with);
			nbt.putString("quest_buffer", quest_buffer);
			nbt.putString("MainQuestContents", MainQuestContents);
			nbt.putString("SubQuestContents", SubQuestContents);
			nbt.putDouble("MainQuestGoal", MainQuestGoal);
			nbt.putDouble("SubQuestGoal", SubQuestGoal);
			nbt.putDouble("MainQuestProgress", MainQuestProgress);
			nbt.putDouble("SubQuestProgress", SubQuestProgress);
			nbt.putBoolean("IsMainQuestExist", IsMainQuestExist);
			nbt.putBoolean("IsSubQuestExist", IsSubQuestExist);
			nbt.putBoolean("MainQuestRequest", MainQuestRequest);
			nbt.putBoolean("SubQuestRequest", SubQuestRequest);
			nbt.putBoolean("MainRewardRequest", MainRewardRequest);
			nbt.putBoolean("SubRewardRequest", SubRewardRequest);
			nbt.putDouble("my_money", my_money);
			nbt.putDouble("RewardMoneyBuffer", RewardMoneyBuffer);
			nbt.putDouble("MainQuestRewardMoney", MainQuestRewardMoney);
			nbt.putDouble("SubQuestRewardMoney", SubQuestRewardMoney);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			job_production = nbt.getString("job_production");
			talk_with = nbt.getString("talk_with");
			quest_buffer = nbt.getString("quest_buffer");
			MainQuestContents = nbt.getString("MainQuestContents");
			SubQuestContents = nbt.getString("SubQuestContents");
			MainQuestGoal = nbt.getDouble("MainQuestGoal");
			SubQuestGoal = nbt.getDouble("SubQuestGoal");
			MainQuestProgress = nbt.getDouble("MainQuestProgress");
			SubQuestProgress = nbt.getDouble("SubQuestProgress");
			IsMainQuestExist = nbt.getBoolean("IsMainQuestExist");
			IsSubQuestExist = nbt.getBoolean("IsSubQuestExist");
			MainQuestRequest = nbt.getBoolean("MainQuestRequest");
			SubQuestRequest = nbt.getBoolean("SubQuestRequest");
			MainRewardRequest = nbt.getBoolean("MainRewardRequest");
			SubRewardRequest = nbt.getBoolean("SubRewardRequest");
			my_money = nbt.getDouble("my_money");
			RewardMoneyBuffer = nbt.getDouble("RewardMoneyBuffer");
			MainQuestRewardMoney = nbt.getDouble("MainQuestRewardMoney");
			SubQuestRewardMoney = nbt.getDouble("SubQuestRewardMoney");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
