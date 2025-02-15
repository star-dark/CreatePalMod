
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.palworld.client.particle.WaterParticleParticle;
import net.mcreator.palworld.client.particle.ThunderParticleParticle;
import net.mcreator.palworld.client.particle.LevelUpParticleParticle;
import net.mcreator.palworld.client.particle.HoverParticleParticle;
import net.mcreator.palworld.client.particle.AegisParticleParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PalworldModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(PalworldModParticleTypes.LEVEL_UP_PARTICLE.get(), LevelUpParticleParticle::provider);
		event.registerSpriteSet(PalworldModParticleTypes.HOVER_PARTICLE.get(), HoverParticleParticle::provider);
		event.registerSpriteSet(PalworldModParticleTypes.AEGIS_PARTICLE.get(), AegisParticleParticle::provider);
		event.registerSpriteSet(PalworldModParticleTypes.THUNDER_PARTICLE.get(), ThunderParticleParticle::provider);
		event.registerSpriteSet(PalworldModParticleTypes.WATER_PARTICLE.get(), WaterParticleParticle::provider);
	}
}
