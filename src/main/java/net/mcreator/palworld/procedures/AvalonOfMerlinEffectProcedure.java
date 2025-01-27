package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.palworld.network.PalworldModVariables;

public class AvalonOfMerlinEffectProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double r = 0;
		double d = 0;
		double angle = 0;
		double k = 0;
		double n = 0;
		k = 1080;
		angle = 0;
		if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 0) {
			n = 1;
			d = 2;
			for (int index0 = 0; index0 < (int) k; index0++) {
				r = 7 * Math.cos(Math.toRadians((n / d) * angle));
				world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 4), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
				angle = angle + 360 / (k * 0.33);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uC18D\uBC15"), false);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 1) {
			n = 3;
			d = 2;
			for (int index1 = 0; index1 < (int) k; index1++) {
				r = 8 * Math.cos(Math.toRadians((n / d) * angle));
				world.addParticle(ParticleTypes.LANDING_OBSIDIAN_TEAR, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 4), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
				angle = angle + 360 / (k * 0.33);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uC911\uB3C5"), false);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 2) {
			n = 4;
			d = 1;
			for (int index2 = 0; index2 < (int) k; index2++) {
				r = 8 * Math.cos(Math.toRadians((n / d) * angle));
				world.addParticle(ParticleTypes.LANDING_HONEY, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 4), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
				angle = angle + 360 / (k * 0.33);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uC57D\uD654"), false);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 3) {
			n = 5;
			d = 2;
			for (int index3 = 0; index3 < (int) k; index3++) {
				r = 8 * Math.cos(Math.toRadians((n / d) * angle));
				world.addParticle(ParticleTypes.FALLING_NECTAR, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 4), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
				angle = angle + 360 / (k * 0.33);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uC5D0\uC5B4\uBCF8"), false);
		} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number % 10 == 4) {
			n = 5;
			d = 3;
			for (int index4 = 0; index4 < (int) k; index4++) {
				r = 8 * Math.cos(Math.toRadians((n / d) * angle));
				world.addParticle(ParticleTypes.LANDING_LAVA, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 4), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
				angle = angle + 360 / (k * 0.33);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uB370\uBBF8\uC9C0(\uAC15)"), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB9C8\uBC95 \uC0AC\uC6A9 \uC2E4\uD328"), true);
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Avalon_number = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
