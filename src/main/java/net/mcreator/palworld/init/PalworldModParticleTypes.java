
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.palworld.PalworldMod;

public class PalworldModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, PalworldMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LEVEL_UP_PARTICLE = REGISTRY.register("level_up_particle", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> THUNDER_PARTICLE = REGISTRY.register("thunder_particle", () -> new SimpleParticleType(false));
}
