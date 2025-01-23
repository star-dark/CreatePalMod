package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class AegisEffectProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
double r = 0;double a = 0;double b = 0;
if (<=0) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(PalworldModMobEffects.DELETED_MOD_ELEMENT, 10, 1));PalworldMod.queueServerWork(777, () -> {
});
}else{if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == PalworldModItems.DELETED_MOD_ELEMENT.get()||(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).getItem() == PalworldModItems.DELETED_MOD_ELEMENT.get())&&==true) {{
final Vec3 _center = new Vec3(x, (y+1), z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator instanceof Player)) {entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FLY_INTO_WALL)), 1);entityiterator.setDeltaMovement(new Vec3(((-1.5)*entityiterator.getX()), ((-1.5)*entityiterator.getY()), ((-1.5)*entityiterator.getZ())));}
}
}if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 2));r = 1.5;a = Math.random()*12;b = 90;for (int index0 = 0; index0<30; index0++) {for (int index1 = 0; index1<16; index1++) {world.addParticle((SimpleParticleType) (PalworldModParticleTypes.AEGIS_PARTICLE.get()), (x-r*Math.cos(Math.toRadians(b))*Math.sin(Math.toRadians(a))), ((y+1)-r*Math.sin(Math.toRadians(b))), (z+r*Math.cos(Math.toRadians(b))*Math.cos(Math.toRadians(a))), 0, 0, 0);b = b+12;}a = a+12;b = 90;}}}
}
}
