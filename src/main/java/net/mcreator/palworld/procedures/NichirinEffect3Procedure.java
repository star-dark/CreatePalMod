package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class NichirinEffect3Procedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
double r = 0;double deg = 0;double i = 0;
if (world.dayTime()>=&&entity.onGround()) {deg = 0;r = 1;i = 1;if (world instanceof ServerLevel _level) {
(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {});
}for (int index0 = 0; index0<4; index0++) {for (int index1 = 0; index1<2; index1++) {for (int index2 = 0; index2<21; index2++) {world.addParticle((SimpleParticleType) (PalworldModParticleTypes.DELETED_MOD_ELEMENT.get()), (x-r*Math.sin(Math.toRadians(deg))), (y+i), (z+r*Math.cos(Math.toRadians(deg))), ((-0.1)*Math.sin(Math.toRadians(deg))), 0, (0.1*Math.cos(Math.toRadians(deg))));{
final Vec3 _center = new Vec3((x-r*Math.sin(Math.toRadians(deg))), y, (z+r*Math.cos(Math.toRadians(deg))));
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator instanceof Player)) {entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 1);}
}
}deg = deg+18;}if (i==2||i==4) {deg = 18;}else{deg = 0;}r = r+1;}}}
}
}
