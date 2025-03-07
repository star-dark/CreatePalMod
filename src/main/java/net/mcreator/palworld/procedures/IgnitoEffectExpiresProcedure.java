package net.mcreator.palworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.palworld.network.PalworldModVariables;

import java.util.List;
import java.util.Comparator;

public class IgnitoEffectExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((10 + entity.getData(PalworldModVariables.PLAYER_VARIABLES).IgnitoSkillPoint * 2) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.isOnFire() && !(entity == entityiterator)) {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), (float) entity.getData(PalworldModVariables.PLAYER_VARIABLES).IgnitoSkillPoint, Level.ExplosionInteraction.TNT);
				}
			}
		}
	}
}
