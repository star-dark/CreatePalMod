package net.mcreator.palworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.palworld.network.PalworldModVariables;

public class AvalonOfMerlinEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double r = 0;
		double d = 0;
		double angle = 0;
		double k = 0;
		double n = 0;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Avalon_number = Mth.nextInt(RandomSource.create(), 1, 5);
				_vars.syncPlayerVariables(entity);
			}
			AvalonOfMerlinEffect3Procedure.execute(world, x, y, z, entity);
			k = 1080;
			angle = 0;
			if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 1) {
				n = 1;
				d = 2;
				for (int index0 = 0; index0 < (int) k; index0++) {
					r = 3 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.SOUL, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.33);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uC18D\uBC15"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 2) {
				n = 3;
				d = 2;
				for (int index1 = 0; index1 < (int) k; index1++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.FALLING_OBSIDIAN_TEAR, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.33);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uC911\uB3C5"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 3) {
				n = 4;
				d = 1;
				for (int index2 = 0; index2 < (int) k; index2++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.SMOKE, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.33);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB514\uBC84\uD504 : \uC57D\uD654"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 4) {
				n = 5;
				d = 2;
				for (int index3 = 0; index3 < (int) k; index3++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.FLAME, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.33);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB370\uBBF8\uC9C0"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 5) {
				n = 5;
				d = 3;
				for (int index4 = 0; index4 < (int) k; index4++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.33);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB370\uBBF8\uC9C0(\uAC15)"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB9C8\uBC95 \uC0AC\uC6A9 \uC2E4\uD328"), true);
			}
		}
	}
}
