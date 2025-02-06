package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModEntities;
import net.mcreator.palworld.entity.KusanagiEntity;
import net.mcreator.palworld.PalworldMod;

import javax.annotation.Nullable;

@EventBusSubscriber(value = {Dist.CLIENT})
public class ThrowKusanagiProcedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		PacketDistributor.sendToServer(new ThrowKusanagiMessage());
		execute(event.getEntity());
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public record ThrowKusanagiMessage() implements CustomPacketPayload {
		public static final Type<ThrowKusanagiMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalworldMod.MODID, "procedure_throw_kusanagi"));
		public static final StreamCodec<RegistryFriendlyByteBuf, ThrowKusanagiMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ThrowKusanagiMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new ThrowKusanagiMessage());

		@Override
		public Type<ThrowKusanagiMessage> type() {
			return TYPE;
		}

		public static void handleData(final ThrowKusanagiMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			PalworldMod.addNetworkMessage(ThrowKusanagiMessage.TYPE, ThrowKusanagiMessage.STREAM_CODEC, ThrowKusanagiMessage::handleData);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && entity.getData(PalworldModVariables.PLAYER_VARIABLES).ThrowKusanagiActivate) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new KusanagiEntity(PalworldModEntities.KUSANAGI.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 5, 1, (byte) 0);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.ThrowKusanagiActivate = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
