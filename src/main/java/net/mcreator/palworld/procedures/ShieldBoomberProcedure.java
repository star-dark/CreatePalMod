package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
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
public class ShieldBoomberProcedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		PacketDistributor.sendToServer(new ShieldBoomberMessage());
		execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public record ShieldBoomberMessage() implements CustomPacketPayload {
		public static final Type<ShieldBoomberMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "procedure_shield_boomber"));
		public static final StreamCodec<RegistryFriendlyByteBuf, ShieldBoomberMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ShieldBoomberMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new ShieldBoomberMessage());

		@Override
		public Type<ShieldBoomberMessage> type() {
			return TYPE;
		}

		public static void handleData(final ShieldBoomberMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player().level(), context.player().getX(), context.player().getY(), context.player().getZ(), context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			PalworldMod.addNetworkMessage(ShieldBoomberMessage.TYPE, ShieldBoomberMessage.STREAM_CODEC, ShieldBoomberMessage::handleData);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double shootdirection = 0;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).shieldBoomberSkillpoint > 0
				&& entity.getData(PalworldModVariables.PLAYER_VARIABLES).ProtectionAmount > 9 - entity.getData(PalworldModVariables.PLAYER_VARIABLES).shieldBoomberSkillpoint
				&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.ProtectionAmount = entity.getData(PalworldModVariables.PLAYER_VARIABLES).ProtectionAmount - (10 - entity.getData(PalworldModVariables.PLAYER_VARIABLES).shieldBoomberSkillpoint);
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getFireball(Level level, Entity shooter) {
						AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
						entityToSpawn.setOwner(shooter);
						return entityToSpawn;
					}
				}.getFireball(projectileLevel, entity);
				_entityToSpawn.setPos((x + entity.getLookAngle().x), (y + 2), (z + entity.getLookAngle().x));
				_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 1, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
