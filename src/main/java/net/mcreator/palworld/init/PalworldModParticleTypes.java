
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
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> AEGIS_PARTICLE = REGISTRY.register("aegis_particle", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> THUNDER_PARTICLE = REGISTRY.register("thunder_particle", () -> new SimpleParticleType(false));
}
