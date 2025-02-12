package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class TransformkireulnoheulddaeProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
if (>0) {if (==0) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uBC29\uC5B4\uBAA8\uB4DC"), true);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")),
SoundSource.NEUTRAL, 1, 1, false);
}
}
if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int)Double.POSITIVE_INFINITY, (int)Math.floor(/ 2)));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int)Double.POSITIVE_INFINITY, (int)(2-Math.floor(/ 2))));if (entity instanceof LivingEntity _entity) _entity.removeEffect(MobEffects.DAMAGE_BOOST);if (entity instanceof LivingEntity _entity) _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uACF5\uACA9\uBAA8\uB4DC"), true);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")),
SoundSource.NEUTRAL, 1, 1, false);
}
}
if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int)Double.POSITIVE_INFINITY, (int)Math.floor(/ 2)));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)Double.POSITIVE_INFINITY, (int)(2-Math.floor(/ 2))));if (entity instanceof LivingEntity _entity) _entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);if (entity instanceof LivingEntity _entity) _entity.removeEffect(MobEffects.WEAKNESS);}}
}
}
