package net.mcreator.palworld.procedures;

import net.neoforged.bus.api.Event;

public class MinerPickEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double randomNumber = 0;
		if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals("Miner")) {
			randomNumber = Mth.nextInt(RandomSource.create(), 1, 10);
			if (randomNumber <= 9 && blockstate == Blocks.COAL_ORE.defaultBlockState()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randomNumber <= 8 && blockstate == Blocks.COPPER_ORE.defaultBlockState()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randomNumber <= 7 && blockstate == Blocks.IRON_ORE.defaultBlockState()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randomNumber <= 6 && blockstate == Blocks.GOLD_ORE.defaultBlockState()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randomNumber <= 5 && blockstate == Blocks.DIAMOND_ORE.defaultBlockState()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randomNumber <= 5 && blockstate == Blocks.EMERALD_ORE.defaultBlockState()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randomNumber <= 8 && blockstate == Blocks.LAPIS_ORE.defaultBlockState()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(PalworldModItems.DELETED_MOD_ELEMENT.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else {
			if (blockstate == Blocks.COAL_ORE.defaultBlockState() || blockstate == Blocks.COPPER_ORE.defaultBlockState() || blockstate == Blocks.IRON_ORE.defaultBlockState() || blockstate == Blocks.GOLD_ORE.defaultBlockState()
					|| blockstate == Blocks.DIAMOND_ORE.defaultBlockState() || blockstate == Blocks.LAPIS_ORE.defaultBlockState() || blockstate == Blocks.EMERALD_ORE.defaultBlockState()) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.COAL);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.RAW_IRON);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.IRON_INGOT);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.RAW_GOLD);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.GOLD_INGOT);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.DIAMOND);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\uACE1\uAD2D\uC774\uC758 \uC800\uC8FC\uB85C \uAD11\uBB3C\uC744 \uC783\uC2B5\uB2C8\uB2E4"), false);
			}
		}
	}
}
