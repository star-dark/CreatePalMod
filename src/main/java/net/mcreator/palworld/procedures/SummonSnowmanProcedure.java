package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModAttributes;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class SummonSnowmanProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, x, y, z, damagesource, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity immediatesourceentity, Entity sourceentity) {
		if (damagesource == null || immediatesourceentity == null || sourceentity == null)
			return;
		Entity snowman = null;
		if ((damagesource.getEntity()) instanceof Player && sourceentity.getPercentFrozen() * 100 == 100 && !(sourceentity == immediatesourceentity)) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.SNOW_GOLEM.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			snowman = (Entity) world.getEntitiesOfClass(SnowGolem.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			if (snowman instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(PalworldModAttributes.IS_SUMMON))
				_livingEntity6.getAttribute(PalworldModAttributes.IS_SUMMON).setBaseValue(sourceentity.getData(PalworldModVariables.PLAYER_VARIABLES).SnowmanSkillPoint);
			sourceentity.setTicksFrozen(0);
		}
	}
}
