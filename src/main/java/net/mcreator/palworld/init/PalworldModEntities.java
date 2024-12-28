
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.palworld.entity.FarmerJobNPCEntity;
import net.mcreator.palworld.PalworldMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PalworldModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, PalworldMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<FarmerJobNPCEntity>> FARMER_JOB_NPC = register("farmer_job_npc",
			EntityType.Builder.<FarmerJobNPCEntity>of(FarmerJobNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		FarmerJobNPCEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(FARMER_JOB_NPC.get(), FarmerJobNPCEntity.createAttributes().build());
	}
}
