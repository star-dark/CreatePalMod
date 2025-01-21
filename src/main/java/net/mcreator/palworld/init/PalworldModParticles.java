
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.palworld.client.particle.ThunderParticleParticle;
import net.mcreator.palworld.client.particle.LevelUpParticleParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PalworldModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(PalworldModParticleTypes.LEVEL_UP_PARTICLE.get(), LevelUpParticleParticle::provider);
		event.registerSpriteSet(PalworldModParticleTypes.THUNDER_PARTICLE.get(), ThunderParticleParticle::provider);
	}
}
