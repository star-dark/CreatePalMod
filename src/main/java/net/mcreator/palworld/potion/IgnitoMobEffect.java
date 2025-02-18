
package net.mcreator.palworld.potion;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class IgnitoMobEffect extends InstantenousMobEffect {
	public IgnitoMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -39373);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
				return false;
			}
		}, PalworldModMobEffects.IGNITO.get());
	}
}