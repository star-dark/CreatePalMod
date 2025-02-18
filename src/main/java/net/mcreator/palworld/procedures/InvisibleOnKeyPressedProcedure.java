package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class InvisibleOnKeyPressedProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (>0) {entity.setInvisible(true);
}
}
}
