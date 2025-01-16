
package net.mcreator.palworld.client.screens;

@EventBusSubscriber({Dist.CLIENT})
public class CurrentMoneyOverlay {

	@SubscribeEvent(priority = EventPriority.NORMAL)
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

		if (true) {

			event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/money2.png"), 42, 9, 0, 0, 16, 16, 16, 16);

			if (

			IsFisherProcedure.execute(entity)

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/fisher.png"), w / 2 + -172, h / 2 + -91, 0, 0, 16, 16, 16, 16);
			}
			if (

			IsMinerProcedure.execute(entity)

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/miner.png"), w / 2 + -171, h / 2 + -92, 0, 0, 16, 16, 16, 16);
			}
			if (

			IsFarmerProcedure.execute(entity)

			) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/farmer.png"), w / 2 + -171, h / 2 + -91, 0, 0, 16, 16, 16, 16);
			}

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					BringMyMoneyProcedure.execute(entity), 58, 12, -256, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palworld.current_money.label_empty"), w / 2 + -213, h / 2 + -120, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palworld.current_money.label_empty1"), w / 2 + -213, h / 2 + -120, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					JobTextProcedure.execute(entity), w / 2 + -155, h / 2 + -88, -13421569, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					PlayerLevelProcedure.execute(), w / 2 + -170, h / 2 + -73, -65536, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					PlayerExpGoalProcedure.execute(), w / 2 + -123, h / 2 + -73, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					PlayerExpProcedure.execute(), w / 2 + -151, h / 2 + -73, -1, false);

			if (

			UserFaceProcedure.execute(entity)

			instanceof LivingEntity livingEntity) {
				renderEntityInInventoryFollowsAngle(event.getGuiGraphics(), 22, 56, 30, 0f, 0, livingEntity);
			}
		}

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}

	private static void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}

}
