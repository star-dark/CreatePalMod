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

import net.minecraft.world.item.ItemStack;
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
import java.util.ArrayList;

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
			clone.MainQuestGoal = original.MainQuestGoal;
			clone.MainQuestProgress = original.MainQuestProgress;
			clone.IsSubQuestExist = original.IsSubQuestExist;
			clone.SubQuestProgress = original.SubQuestProgress;
			clone.my_money = original.my_money;
			clone.MainQuestContents = original.MainQuestContents;
			clone.SubQuestGoal = original.SubQuestGoal;
			clone.MainQuestRewardMoney = original.MainQuestRewardMoney;
			clone.IsMainQuestExist = original.IsMainQuestExist;
			clone.SubQuestRewardMoney = original.SubQuestRewardMoney;
			clone.SubQuestContents = original.SubQuestContents;
			clone.QuestCooltimeBuffer = original.QuestCooltimeBuffer;
			clone.SubQuestProvider = original.SubQuestProvider;
			clone.SubQuestItem = original.SubQuestItem;
			clone.Player_Level = original.Player_Level;
			clone.HealthUpSkillPoint = original.HealthUpSkillPoint;
			clone.DefenseUpSkillPoint = original.DefenseUpSkillPoint;
			clone.Skill_Points = original.Skill_Points;
			clone.AttackUpSkillPoint = original.AttackUpSkillPoint;
			clone.Player_EXP = original.Player_EXP;
			clone.RecoverSkillPoint = original.RecoverSkillPoint;
			clone.RangeUpSkillPoint = original.RangeUpSkillPoint;
			clone.FoodFighterSkillPoint = original.FoodFighterSkillPoint;
			clone.JumpVar = original.JumpVar;
			clone.HornPlayerSkillPoint = original.HornPlayerSkillPoint;
			clone.ReflectionSkillPointUp = original.ReflectionSkillPointUp;
			clone.DoubleJumpSkillPoint = original.DoubleJumpSkillPoint;
			clone.BlinkVar = original.BlinkVar;
			clone.timeBuffer = original.timeBuffer;
			clone.Amanomuraku_tick = original.Amanomuraku_tick;
			clone.AstraBook_tick = original.AstraBook_tick;
			if (!event.isWasDeath()) {
				clone.talk_with = original.talk_with;
				clone.SubRewardRequest = original.SubRewardRequest;
				clone.quest_buffer = original.quest_buffer;
				clone.SubQuestRequest = original.SubQuestRequest;
				clone.MainRewardRequest = original.MainRewardRequest;
				clone.MainQuestRequest = original.MainQuestRequest;
				clone.RewardMoneyBuffer = original.RewardMoneyBuffer;
				clone.aegis_tick = original.aegis_tick;
				clone.aegis_bool = original.aegis_bool;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public String job_production = "\"\"";
		public String talk_with = "\"\"";
		public double MainQuestGoal = 0;
		public double MainQuestProgress = 0;
		public boolean SubRewardRequest = false;
		public boolean IsSubQuestExist = false;
		public String quest_buffer = "\"\"";
		public double SubQuestProgress = 0;
		public boolean SubQuestRequest = false;
		public boolean MainRewardRequest = false;
		public boolean MainQuestRequest = false;
		public double my_money = 0;
		public String MainQuestContents = "\"\"";
		public double SubQuestGoal = 0;
		public double MainQuestRewardMoney = 0;
		public boolean IsMainQuestExist = false;
		public double RewardMoneyBuffer = 0;
		public double SubQuestRewardMoney = 0;
		public String SubQuestContents = "\"\"";
		public double QuestCooltimeBuffer = 0;
		public String SubQuestProvider = "\"\"";
		public ItemStack SubQuestItem = ItemStack.EMPTY;
		public double Player_Level = 1.0;
		public double HealthUpSkillPoint = 0;
		public double DefenseUpSkillPoint = 0;
		public double Skill_Points = 0;
		public double AttackUpSkillPoint = 0;
		public double Player_EXP = 0;
		public double RecoverSkillPoint = 0;
		public double RangeUpSkillPoint = 0;
		public double FoodFighterSkillPoint = 0;
		public boolean JumpVar = false;
		public double HornPlayerSkillPoint = 0;
		public double ReflectionSkillPointUp = 0;
		public double aegis_tick = 100.0;
		public boolean aegis_bool = true;
		public double DoubleJumpSkillPoint = 0;
		public boolean BlinkVar = false;
		public double timeBuffer = 0;
		public double Amanomuraku_tick = 0.0;
		public double AstraBook_tick = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("job_production", job_production);
			nbt.putString("talk_with", talk_with);
			nbt.putDouble("MainQuestGoal", MainQuestGoal);
			nbt.putDouble("MainQuestProgress", MainQuestProgress);
			nbt.putBoolean("SubRewardRequest", SubRewardRequest);
			nbt.putBoolean("IsSubQuestExist", IsSubQuestExist);
			nbt.putString("quest_buffer", quest_buffer);
			nbt.putDouble("SubQuestProgress", SubQuestProgress);
			nbt.putBoolean("SubQuestRequest", SubQuestRequest);
			nbt.putBoolean("MainRewardRequest", MainRewardRequest);
			nbt.putBoolean("MainQuestRequest", MainQuestRequest);
			nbt.putDouble("my_money", my_money);
			nbt.putString("MainQuestContents", MainQuestContents);
			nbt.putDouble("SubQuestGoal", SubQuestGoal);
			nbt.putDouble("MainQuestRewardMoney", MainQuestRewardMoney);
			nbt.putBoolean("IsMainQuestExist", IsMainQuestExist);
			nbt.putDouble("RewardMoneyBuffer", RewardMoneyBuffer);
			nbt.putDouble("SubQuestRewardMoney", SubQuestRewardMoney);
			nbt.putString("SubQuestContents", SubQuestContents);
			nbt.putDouble("QuestCooltimeBuffer", QuestCooltimeBuffer);
			nbt.putString("SubQuestProvider", SubQuestProvider);
			nbt.put("SubQuestItem", SubQuestItem.saveOptional(lookupProvider));
			nbt.putDouble("Player_Level", Player_Level);
			nbt.putDouble("HealthUpSkillPoint", HealthUpSkillPoint);
			nbt.putDouble("DefenseUpSkillPoint", DefenseUpSkillPoint);
			nbt.putDouble("Skill_Points", Skill_Points);
			nbt.putDouble("AttackUpSkillPoint", AttackUpSkillPoint);
			nbt.putDouble("Player_EXP", Player_EXP);
			nbt.putDouble("RecoverSkillPoint", RecoverSkillPoint);
			nbt.putDouble("RangeUpSkillPoint", RangeUpSkillPoint);
			nbt.putDouble("FoodFighterSkillPoint", FoodFighterSkillPoint);
			nbt.putBoolean("JumpVar", JumpVar);
			nbt.putDouble("HornPlayerSkillPoint", HornPlayerSkillPoint);
			nbt.putDouble("ReflectionSkillPointUp", ReflectionSkillPointUp);
			nbt.putDouble("aegis_tick", aegis_tick);
			nbt.putBoolean("aegis_bool", aegis_bool);
			nbt.putDouble("DoubleJumpSkillPoint", DoubleJumpSkillPoint);
			nbt.putBoolean("BlinkVar", BlinkVar);
			nbt.putDouble("timeBuffer", timeBuffer);
			nbt.putDouble("Amanomuraku_tick", Amanomuraku_tick);
			nbt.putDouble("AstraBook_tick", AstraBook_tick);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			job_production = nbt.getString("job_production");
			talk_with = nbt.getString("talk_with");
			MainQuestGoal = nbt.getDouble("MainQuestGoal");
			MainQuestProgress = nbt.getDouble("MainQuestProgress");
			SubRewardRequest = nbt.getBoolean("SubRewardRequest");
			IsSubQuestExist = nbt.getBoolean("IsSubQuestExist");
			quest_buffer = nbt.getString("quest_buffer");
			SubQuestProgress = nbt.getDouble("SubQuestProgress");
			SubQuestRequest = nbt.getBoolean("SubQuestRequest");
			MainRewardRequest = nbt.getBoolean("MainRewardRequest");
			MainQuestRequest = nbt.getBoolean("MainQuestRequest");
			my_money = nbt.getDouble("my_money");
			MainQuestContents = nbt.getString("MainQuestContents");
			SubQuestGoal = nbt.getDouble("SubQuestGoal");
			MainQuestRewardMoney = nbt.getDouble("MainQuestRewardMoney");
			IsMainQuestExist = nbt.getBoolean("IsMainQuestExist");
			RewardMoneyBuffer = nbt.getDouble("RewardMoneyBuffer");
			SubQuestRewardMoney = nbt.getDouble("SubQuestRewardMoney");
			SubQuestContents = nbt.getString("SubQuestContents");
			QuestCooltimeBuffer = nbt.getDouble("QuestCooltimeBuffer");
			SubQuestProvider = nbt.getString("SubQuestProvider");
			SubQuestItem = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SubQuestItem"));
			Player_Level = nbt.getDouble("Player_Level");
			HealthUpSkillPoint = nbt.getDouble("HealthUpSkillPoint");
			DefenseUpSkillPoint = nbt.getDouble("DefenseUpSkillPoint");
			Skill_Points = nbt.getDouble("Skill_Points");
			AttackUpSkillPoint = nbt.getDouble("AttackUpSkillPoint");
			Player_EXP = nbt.getDouble("Player_EXP");
			RecoverSkillPoint = nbt.getDouble("RecoverSkillPoint");
			RangeUpSkillPoint = nbt.getDouble("RangeUpSkillPoint");
			FoodFighterSkillPoint = nbt.getDouble("FoodFighterSkillPoint");
			JumpVar = nbt.getBoolean("JumpVar");
			HornPlayerSkillPoint = nbt.getDouble("HornPlayerSkillPoint");
			ReflectionSkillPointUp = nbt.getDouble("ReflectionSkillPointUp");
			aegis_tick = nbt.getDouble("aegis_tick");
			aegis_bool = nbt.getBoolean("aegis_bool");
			DoubleJumpSkillPoint = nbt.getDouble("DoubleJumpSkillPoint");
			BlinkVar = nbt.getBoolean("BlinkVar");
			timeBuffer = nbt.getDouble("timeBuffer");
			Amanomuraku_tick = nbt.getDouble("Amanomuraku_tick");
			AstraBook_tick = nbt.getDouble("AstraBook_tick");
		}

		public void syncPlayerVariables(Entity entity) {
			if (!entity.level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(entity.level().players())) {
					if (entityiterator instanceof ServerPlayer serverPlayer)
						PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this, entity.getId()));
				}
			}
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int target) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess()));
			buffer.writeInt(message.target()); // Write the entity ID to the buffer
		}, (RegistryFriendlyByteBuf buffer) -> {
			var nbt = buffer.readNbt();
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserializeNBT(buffer.registryAccess(), nbt);
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().level().getEntity(message.target()).getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess())))
						.exceptionally(e -> {
							context.connection().disconnect(Component.literal(e.getMessage()));
							return null;
						});
			}
		}
	}
}
