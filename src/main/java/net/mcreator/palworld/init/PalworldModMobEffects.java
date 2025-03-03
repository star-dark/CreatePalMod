
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.palworld.procedures.InvincivilityEffectExpiresProcedure;
import net.mcreator.palworld.procedures.IgnitoEffectExpiresProcedure;
import net.mcreator.palworld.potion.WaterPotionEffectMobEffect;
import net.mcreator.palworld.potion.ThunderPotionMobEffect;
import net.mcreator.palworld.potion.InvincivilityMobEffect;
import net.mcreator.palworld.potion.IgnitoMobEffect;
import net.mcreator.palworld.potion.AegisCoolMobEffect;
import net.mcreator.palworld.PalworldMod;

@EventBusSubscriber
public class PalworldModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, PalworldMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> AEGIS_COOL = REGISTRY.register("aegis_cool", () -> new AegisCoolMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> THUNDER_POTION = REGISTRY.register("thunder_potion", () -> new ThunderPotionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WATER_POTION_EFFECT = REGISTRY.register("water_potion_effect", () -> new WaterPotionEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> IGNITO = REGISTRY.register("ignito", () -> new IgnitoMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INVINCIVILITY = REGISTRY.register("invincivility", () -> new InvincivilityMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(IGNITO)) {
			IgnitoEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(INVINCIVILITY)) {
			InvincivilityEffectExpiresProcedure.execute(entity);
		}
	}
}
