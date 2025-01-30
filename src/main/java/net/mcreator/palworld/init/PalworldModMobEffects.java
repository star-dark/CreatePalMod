
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.palworld.potion.ThunderPotionMobEffect;
import net.mcreator.palworld.potion.AegisCoolMobEffect;
import net.mcreator.palworld.PalworldMod;

public class PalworldModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, PalworldMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> AEGIS_COOL = REGISTRY.register("aegis_cool", () -> new AegisCoolMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> THUNDER_POTION = REGISTRY.register("thunder_potion", () -> new ThunderPotionMobEffect());
}
