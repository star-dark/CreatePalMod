package net.mcreator.palworld.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.palworld.world.inventory.QuestTapMenu;
import net.mcreator.palworld.procedures.SubQuestProcedure;
import net.mcreator.palworld.procedures.MainQuestProcedure;
import net.mcreator.palworld.procedures.IsSubQuestExistProcedure;
import net.mcreator.palworld.procedures.IsSubQuestCompleteProcedure;
import net.mcreator.palworld.procedures.IsMainQuestExistProcedure;
import net.mcreator.palworld.procedures.IsMainQuestCompleteProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuestTapScreen extends AbstractContainerScreen<QuestTapMenu> {
	private final static HashMap<String, Object> guistate = QuestTapMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public QuestTapScreen(QuestTapMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 143;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/quest_tap.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.quest_tap.label_kweseuteu"), 79, 10, -12829636, false);
		if (IsMainQuestExistProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					MainQuestProcedure.execute(entity), 24, 38, -12829636, false);
		if (IsSubQuestExistProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					SubQuestProcedure.execute(entity), 23, 86, -12829636, false);
		if (IsMainQuestCompleteProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.palworld.quest_tap.label_wanryo"), 139, 38, -12829636, false);
		if (IsSubQuestCompleteProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.palworld.quest_tap.label_wanryo1"), 139, 87, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}