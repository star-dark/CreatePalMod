
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

import net.mcreator.palworld.procedures.ProtectAttackDisplayOverlayIngameProcedure;
import net.mcreator.palworld.procedures.IsAmount9Procedure;
import net.mcreator.palworld.procedures.IsAmount8Procedure;
import net.mcreator.palworld.procedures.IsAmount7Procedure;
import net.mcreator.palworld.procedures.IsAmount6Procedure;
import net.mcreator.palworld.procedures.IsAmount5Procedure;
import net.mcreator.palworld.procedures.IsAmount4Procedure;
import net.mcreator.palworld.procedures.IsAmount3Procedure;
import net.mcreator.palworld.procedures.IsAmount2Procedure;
import net.mcreator.palworld.procedures.IsAmount1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class ProtectAttackOverlay {
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
		if (ProtectAttackDisplayOverlayIngameProcedure.execute(entity)) {
			if (IsAmount9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae.png"), w / 2 + 107, h / 2 + -1, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae1.png"), w / 2 + 107, h / 2 + -1, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae2.png"), w / 2 + 107, h / 2 + -1, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae3.png"), w / 2 + 107, h / 2 + 0, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae4.png"), w / 2 + 107, h / 2 + 0, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae5.png"), w / 2 + 107, h / 2 + 0, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae6.png"), w / 2 + 107, h / 2 + 0, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae7.png"), w / 2 + 107, h / 2 + 0, 0, 0, 80, 103, 80, 103);
			}
			if (IsAmount8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palworld:textures/screens/bangpae8.png"), w / 2 + 106, h / 2 + 0, 0, 0, 80, 103, 80, 103);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
