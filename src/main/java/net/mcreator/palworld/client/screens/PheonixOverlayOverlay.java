
package net.mcreator.palworld.client.screens;

@EventBusSubscriber({Dist.CLIENT})
public class PheonixOverlayOverlay {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();

		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;

		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}

		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);

		if (

		PheonixOverlayDisplayOverlayIngameProcedure.execute()

		) {

			if (

			StackAmountProcedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix1.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount2Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix2.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount3Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix3.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount4Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix4.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount5Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix5.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount6Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix6.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount7Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix7.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount8Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix8.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmount9Procedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix9.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (

			StackAmountFullProcedure.execute()

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pinigseu.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}

		}

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}

}
