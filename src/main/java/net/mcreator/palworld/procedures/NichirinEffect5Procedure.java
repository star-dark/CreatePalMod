package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class NichirinEffect5Procedure {
public static void execute(
LevelAccessor world,
Entity entity ) {
if (
entity == null ) return ;
if (world.dayTime()>=) {if (==0) {}else if (==2) {if (entity.onGround()) {}else if (!entity.onGround()) {entity.setDeltaMovement(new Vec3(0, (-3), 0));}}else if (==1) {}}
}
}
