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

public class AvalonOfMerlinEffect2Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double r = 0;
		double d = 0;
		double num = 0;
		double angle = 0;
		double k = 0;
		double n = 0;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
			{
				PalworldModVariables.PlayerVariables _vars = entity.getData(PalworldModVariables.PLAYER_VARIABLES);
				_vars.Avalon_number = Mth.nextInt(RandomSource.create(), 6, 12);
				_vars.syncPlayerVariables(entity);
			}
			k = 2160;
			angle = 0;
			if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 6) {
				n = 4;
				d = 5;
				for (int index0 = 0; index0 < (int) k; index0++) {
					r = 3 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.HAPPY_VILLAGER, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.1415);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uBC84\uD504 : \uD790"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 7) {
				n = 3;
				d = 5;
				for (int index1 = 0; index1 < (int) k; index1++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.INSTANT_EFFECT, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.1415);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uBC84\uD504 : \uD22C\uBA85\uD654"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 8) {
				n = 3;
				d = 4;
				for (int index2 = 0; index2 < (int) k; index2++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.WITCH, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.1415);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uBC84\uD504 : \uC7AC\uC0DD"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 9) {
				n = 2;
				d = 3;
				for (int index3 = 0; index3 < (int) k; index3++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.1415);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uBC84\uD504 : \uCD94\uAC00 \uCCB4\uB825"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 10) {
				n = 1;
				d = 4;
				for (int index4 = 0; index4 < (int) k; index4++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.NAUTILUS, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.1415);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uBC84\uD504 : \uBC29\uC5B4\uB825"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 11) {
				n = 4;
				d = 3;
				for (int index5 = 0; index5 < (int) k; index5++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.END_ROD, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.1415);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uBC84\uD504 : \uACF5\uACA9\uB825"), false);
			} else if (entity.getData(PalworldModVariables.PLAYER_VARIABLES).Avalon_number == 12) {
				n = 2;
				d = 5;
				for (int index6 = 0; index6 < (int) k; index6++) {
					r = 10 * Math.cos(Math.toRadians((n / d) * angle));
					world.addParticle(ParticleTypes.FIREWORK, (entity.getX() + r * Math.cos(Math.toRadians(angle))), (entity.getY() + 0.2), (entity.getZ() + r * Math.sin(Math.toRadians(angle))), 0, 0, 0);
					angle = angle + 360 / (k * 0.1415);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uBC84\uD504 : \uC2E0\uC18D"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uB9C8\uBC95 \uC0AC\uC6A9 \uC2E4\uD328"), true);
			}
		}
	}
}
