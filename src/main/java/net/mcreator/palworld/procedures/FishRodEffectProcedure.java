package net.mcreator.palworld.procedures;

import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
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

import javax.annotation.Nullable;

@EventBusSubscriber
public class FishRodEffectProcedure {
	@SubscribeEvent
	public static void onPlayerFishItem(ItemFishedEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double RandomNumber = 0;
		if ((entity.getData(PalworldModVariables.PLAYER_VARIABLES).job_production).equals("Fisher")) {
			if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.PUFFERFISH)) : false) && 1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				RandomNumber = Mth.nextInt(RandomSource.create(), 1, 7);
				if (1 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_ANGLER.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uBCF5\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uC544\uADC0\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (2 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_ARAPAIMA.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uBCF5\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uD53C\uB77C\uB8E8\uCFE0\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (3 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_TUNA.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uBCF5\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uCC38\uCE58\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (4 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_RAINBOW_TROUT.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uBCF5\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uBB34\uC9C0\uAC1C \uC1A1\uC5B4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (5 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBB3C\uACE0\uAE30\uAC00 \uBBF8\uB07C\uB9CC \uBA39\uACE0 \uB3C4\uB9DD\uCCE4\uC2B5\uB2C8\uB2E4"), false);
				} else if (6 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBB3C\uACE0\uAE30\uAC00 \uBBF8\uB07C\uB9CC \uBA39\uACE0 \uB3C4\uB9DD\uCCE4\uC2B5\uB2C8\uB2E4"), false);
				} else if (7 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBB3C\uACE0\uAE30\uAC00 \uBBF8\uB07C\uB9CC \uBA39\uACE0 \uB3C4\uB9DD\uCCE4\uC2B5\uB2C8\uB2E4"), false);
				}
			} else if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.TROPICAL_FISH)) : false) && 1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				RandomNumber = Mth.nextInt(RandomSource.create(), 1, 5);
				if (1 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.TROPICAL_FISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_RED_BELLIED_PIRANHA.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uC5F4\uB300\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uD53C\uB77C\uB0D0\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (2 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.TROPICAL_FISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_ELECTRIC_EEL.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uC5F4\uB300\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uC804\uAE30\uBC40\uC7A5\uC5B4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (3 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.TROPICAL_FISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_MUSKELLUNGE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uC5F4\uB300\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uBA38\uC2A4\uCF08\uB8EC\uC9C0\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (4 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.TROPICAL_FISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBB3C\uACE0\uAE30\uAC00 \uBBF8\uB07C\uB9CC \uBA39\uACE0 \uB3C4\uB9DD\uCCE4\uC2B5\uB2C8\uB2E4"), false);
				} else if (5 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.TROPICAL_FISH);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBB3C\uACE0\uAE30\uAC00 \uBBF8\uB07C\uB9CC \uBA39\uACE0 \uB3C4\uB9DD\uCCE4\uC2B5\uB2C8\uB2E4"), false);
				}
			} else if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.SALMON)) : false) && 1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
				RandomNumber = Mth.nextInt(RandomSource.create(), 1, 5);
				if (1 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.SALMON);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_HAILBUT.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uC5F0\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uB119\uCE58\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (2 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.SALMON);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_PERCH.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uC5F0\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uB18D\uC5B4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (3 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.SALMON);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_CARP.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uC5F0\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uC789\uC5B4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (4 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.SALMON);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_CATFISH.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uC5F0\uC5B4\uB97C \uC0AC\uC6A9\uD574 \"\uBA54\uAE30\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (5 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.SALMON);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBB3C\uACE0\uAE30\uAC00 \uBBF8\uB07C\uB9CC \uBA39\uACE0 \uB3C4\uB9DD\uCCE4\uC2B5\uB2C8\uB2E4"), false);
				}
			} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.COD)) : false) {
				RandomNumber = Mth.nextInt(RandomSource.create(), 1, 7);
				if (1 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.COD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_HERRING.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uB300\uAD6C\uB97C \uC0AC\uC6A9\uD574 \"\uCCAD\uC5B4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (2 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.COD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_POLLOCK.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uB300\uAD6C\uB97C \uC0AC\uC6A9\uD574 \"\uBA85\uD0DC\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (3 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.COD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_RED_GROUPER.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uB300\uAD6C\uB97C \uC0AC\uC6A9\uD574 \"\uBD89\uBC14\uB9AC\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (4 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.COD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_SYNODONTIS.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uB300\uAD6C\uB97C \uC0AC\uC6A9\uD574 \"\uC2DC\uB178\uB3C8\uD2F0\uC2A4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (5 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.COD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_BASS.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uB300\uAD6C\uB97C \uC0AC\uC6A9\uD574 \"\uBC30\uC2A4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (6 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.COD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_TAMBAQUI.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uB300\uAD6C\uB97C \uC0AC\uC6A9\uD574 \"\uD0D0\uBC14\uD0A4\"\uB97C \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				} else if (7 == RandomNumber) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.COD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalworldModItems.FISH_BLUE_GILL.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\uBBF8\uB07C\uB85C \uB300\uAD6C\uB97C \uC0AC\uC6A9\uD574 \"\uBE14\uB8E8\uAE38\"\uC744 \uB09A\uC558\uC2B5\uB2C8\uB2E4!"), false);
				}
			}
		} else {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.TROPICAL_FISH);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.SALMON);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.COD);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB09A\uC2EF\uB300\uC758 \uC800\uC8FC\uB85C \uBB3C\uACE0\uAE30\uB97C \uC783\uC2B5\uB2C8\uB2E4."), false);
		}
	}
}
