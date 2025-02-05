package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class NichirinEffect7Procedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
double r = 0;double a = 0;double b = 0;
if (world.dayTime()>=) {r = 2;a = entity.getYRot();b = entity.getXRot();entity.getPersistentData().putDouble("timer", 20);for (int index0 = 0; index0<120; index0++) {if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.DOLPHIN, (x-r*Math.cos(Math.toRadians(b))*Math.sin(Math.toRadians(a))), ((y+1.5)-r*Math.sin(Math.toRadians(b))), (z+r*Math.cos(Math.toRadians(b))*Math.cos(Math.toRadians(a))), 30, 0.2, 0.2, 0.2, 0.2);if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.END_ROD, (x-r*Math.cos(Math.toRadians(b))*Math.sin(Math.toRadians(a))), ((y+1)-r*Math.sin(Math.toRadians(b))), (z+r*Math.cos(Math.toRadians(b))*Math.cos(Math.toRadians(a))), 2, 0.2, 0.2, 0.2, 0.02);{
final Vec3 _center = new Vec3((x-r*Math.cos(Math.toRadians(b))*Math.sin(Math.toRadians(a))), ((y+1)-r*Math.sin(Math.toRadians(b))), (z+r*Math.cos(Math.toRadians(b))*Math.cos(Math.toRadians(a))));
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator instanceof Player)) {entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), 5);}
}
}b = b+3;}entity.setDeltaMovement(new Vec3((entity.getLookAngle().x*1), (entity.getLookAngle().y*1.5), (entity.getLookAngle().z*1)));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(PalworldModMobEffects.DELETED_MOD_ELEMENT, 150, 1, false, false));}
}
}
