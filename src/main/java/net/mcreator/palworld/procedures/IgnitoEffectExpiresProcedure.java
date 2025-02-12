package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class IgnitoEffectExpiresProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((10+*2) / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (entityiterator.isOnFire()&&!(entity == entityiterator)) {if (world instanceof Level _level && !_level.isClientSide())
_level.explode(null, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), (float), Level.ExplosionInteraction.TNT);}
}
}
}
}
