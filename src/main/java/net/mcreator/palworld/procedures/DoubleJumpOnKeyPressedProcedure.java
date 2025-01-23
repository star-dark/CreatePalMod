package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class DoubleJumpOnKeyPressedProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (!entity.onGround()&&==true) {entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.5, (entity.getDeltaMovement().z())));}
}
}
