package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class GloryGoldGhostEffectProcedure {
public static void execute(
LevelAccessor world,
Entity entity,
ItemStack itemstack ) {
if (
entity == null ) return ;
double a = 0;double b = 0;double c = 0;double enforce = 0;
a = entity.getYRot();b = entity.getXRot();c = 10;enforce = *0.5;if(entity instanceof Player _player)
_player.getCooldowns().addCooldown(itemstack.getItem(), 30);for (int index0 = 0; index0<4; index0++) {if (world instanceof ServerLevel projectileLevel) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level) {
@Override public byte getPierceLevel() {
return piercing;
}
@Override protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
if (knockback > 0) {
double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
if (vec3.lengthSqr() > 0.0) {
livingEntity.push(vec3.x, 0.1, vec3.z);
}
}
}
};
entityToSpawn.setBaseDamage(damage);
return entityToSpawn;
}
}.getArrow(projectileLevel, (float)(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level*0.1), (int)enforce, (byte) enforce);
_entityToSpawn.setPos((entity.getX()), (entity.getY()+1.5), (entity.getZ()));
_entityToSpawn.shoot(((-1)*(Math.cos(Math.toRadians(c))*Math.cos(Math.toRadians(b))*Math.sin(Math.toRadians(a))+Math.sin(Math.toRadians(c))*Math.sin(Math.toRadians(a-90)))), ((-1)*Math.cos(Math.toRadians(c))*Math.sin(Math.toRadians(b))), (Math.cos(Math.toRadians(c))*Math.cos(Math.toRadians(b))*Math.cos(Math.toRadians(a))+Math.sin(Math.toRadians(c))*Math.cos(Math.toRadians(a-90))), 3, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}c = (-1)*c;if (world instanceof ServerLevel projectileLevel) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level) {
@Override public byte getPierceLevel() {
return piercing;
}
@Override protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
if (knockback > 0) {
double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
if (vec3.lengthSqr() > 0.0) {
livingEntity.push(vec3.x, 0.1, vec3.z);
}
}
}
};
entityToSpawn.setBaseDamage(damage);
return entityToSpawn;
}
}.getArrow(projectileLevel, (float)(entity.getData(PalworldModVariables.PLAYER_VARIABLES).Player_Level*0.1), (int)enforce, (byte) enforce);
_entityToSpawn.setPos((entity.getX()), (entity.getY()+1.5), (entity.getZ()));
_entityToSpawn.shoot(((-1)*(Math.cos(Math.toRadians(c))*Math.cos(Math.toRadians(b))*Math.sin(Math.toRadians(a))+Math.sin(Math.toRadians(c))*Math.sin(Math.toRadians(a-90)))), ((-1)*Math.cos(Math.toRadians(c))*Math.sin(Math.toRadians(b))), (Math.cos(Math.toRadians(c))*Math.cos(Math.toRadians(b))*Math.cos(Math.toRadians(a))+Math.sin(Math.toRadians(c))*Math.cos(Math.toRadians(a-90))), 3, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}c = (-1)*c+10;}
}
}
