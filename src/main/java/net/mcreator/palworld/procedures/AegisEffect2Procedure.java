package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class AegisEffect2Procedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (==true&&>0) {if (<200) {}else{}if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("Aegis OFF"), true);}else if (==false&&>0) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("Aegis ON"), true);}else if (==true&&<=0) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("Aegis Cool"), true);}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("Aegis Cool"), true);}
}
}
