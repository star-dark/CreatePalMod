package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class NichirinEffect4Procedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (>=2) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("1\uD615 : \uC218\uBA74\uBCA0\uAE30"), true);}else if (==0) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("2\uD615 : \uBB3C\uBC29\uC544"), true);}else if (==1) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("8\uD615 : \uC6A9\uC18C"), true);}
}
}
