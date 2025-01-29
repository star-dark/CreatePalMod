package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class AvalonOfMerlinEffect3Procedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
double r = 0;double d = 0;double angle = 0;double k = 0;double n = 0;
{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator instanceof Player)) {if (%10==0) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 10, false, false));}else if (%10==1) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 2, false, false));}else if (%10==2) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 3, false, false));}else if (%10==3) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 80, (int)(/ 10), false, false));}else if (%10==4) {entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK)), (float)(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level*1.5));}}if (entityiterator instanceof Player) {if ((-%10)/ 10==0) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, (int)(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level/ 10), false, false));}else if ((-%10)/ 10==1) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 1, false, false));}else if ((-%10)/ 10==2) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, false));}else if ((-%10)/ 10==3) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1, false, false));}else if ((-%10)/ 10==4) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, (int)(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level/ 10+1), false, false));}else if ((-%10)/ 10==5) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, (int)(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level/ 10+1), false, false));}else if ((-%10)/ 10==6) {if(entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, (int)(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level/ 10+1), false, false));}}
}
}if (%10>=5||(-%10)/ 10>=7) {}
}
}
