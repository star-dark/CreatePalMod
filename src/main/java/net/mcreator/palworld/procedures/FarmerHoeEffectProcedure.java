package net.mcreator.palworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.palworld.network.PalworldModVariables;
import net.mcreator.palworld.init.PalworldModItems;

public class FarmerHoeEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double randomNumber = 0;
		if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals("Farmer")) {
			randomNumber = Mth.nextInt(RandomSource.create(), 1, 5);
			if (blockstate == Blocks.MELON.defaultBlockState() || blockstate == Blocks.PUMPKIN.defaultBlockState() || blockstate == Blocks.COCOA.defaultBlockState() || blockstate == Blocks.NETHER_WART.defaultBlockState()) {
				if (randomNumber <= 3) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.FARMER_DREGS.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (blockstate == Blocks.BROWN_MUSHROOM.defaultBlockState() || blockstate == Blocks.RED_MUSHROOM.defaultBlockState()) {
				if (randomNumber <= 5) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.FARMER_SPORE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (blockstate == Blocks.POTATOES.defaultBlockState() || blockstate == Blocks.BEETROOTS.defaultBlockState() || blockstate == Blocks.CARROTS.defaultBlockState() || blockstate == Blocks.WHEAT.defaultBlockState()) {
				if (randomNumber <= 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.FARMER_ROOT.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uAD2D\uC774\uC758 \uC800\uC8FC\uB85C \uB18D\uC791\uBB3C\uC744 \uC783\uC2B5\uB2C8\uB2E4"), false);
		}
	}
}
