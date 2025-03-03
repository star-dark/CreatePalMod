
package net.mcreator.palworld.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.palworld.procedures.StackAmountProcedure;
import net.mcreator.palworld.procedures.StackAmountFullProcedure;
import net.mcreator.palworld.procedures.StackAmount9Procedure;
import net.mcreator.palworld.procedures.StackAmount8Procedure;
import net.mcreator.palworld.procedures.StackAmount7Procedure;
import net.mcreator.palworld.procedures.StackAmount6Procedure;
import net.mcreator.palworld.procedures.StackAmount5Procedure;
import net.mcreator.palworld.procedures.StackAmount4Procedure;
import net.mcreator.palworld.procedures.StackAmount3Procedure;
import net.mcreator.palworld.procedures.StackAmount2Procedure;
import net.mcreator.palworld.procedures.PheonixOverlayDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

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
		if (PheonixOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			if (StackAmountProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix1.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix2.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix3.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix4.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix5.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix6.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix7.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix8.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmount9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/pheonix9.png"), w - 106, h - 106, 0, 0, 83, 100, 83, 100);
			}
			if (StackAmountFullProcedure.execute(entity)) {
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
