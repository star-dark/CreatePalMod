
package net.mcreator.palworld.potion;

public class WaterPotionEffectMobEffect extends InstantenousMobEffect {
	public WaterPotionEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}
}