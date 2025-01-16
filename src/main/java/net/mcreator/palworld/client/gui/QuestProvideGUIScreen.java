package net.mcreator.palworld.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.palworld.world.inventory.QuestProvideGUIMenu;
import net.mcreator.palworld.procedures.RewardButtonAppearProcedure;
import net.mcreator.palworld.procedures.QuestTapCloseButtonAppearProcedure;
import net.mcreator.palworld.procedures.IsNotMainQuestCompleteProcedure;
import net.mcreator.palworld.procedures.IsMainQuestCompleteProcedure;
import net.mcreator.palworld.procedures.BringQuestRewardProcedure;
import net.mcreator.palworld.procedures.BringQuestContentsProcedure;
import net.mcreator.palworld.procedures.AcceptApearProcedure;
import net.mcreator.palworld.network.QuestProvideGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuestProvideGUIScreen extends AbstractContainerScreen<QuestProvideGUIMenu> {
	private final static HashMap<String, Object> guistate = QuestProvideGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_surag;
	Button button_geojeol;
	Button button_dadgi;
	Button button_bosanghoegdeug;

	public QuestProvideGUIScreen(QuestProvideGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 122;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/quest_provide_gui.png");

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
		if (IsNotMainQuestCompleteProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("palworld:textures/screens/bang.png"), this.leftPos + 19, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (IsMainQuestCompleteProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("palworld:textures/screens/question.png"), this.leftPos + 19, this.topPos + 32, 0, 0, 16, 16, 16, 16);
		}
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
		guiGraphics.drawString(this.font,

				BringQuestContentsProcedure.execute(entity), 46, 34, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.quest_provide_gui.label_bosang"), 37, 57, -12829636, false);
		guiGraphics.drawString(this.font,

				BringQuestRewardProcedure.execute(entity), 67, 56, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_surag = Button.builder(Component.translatable("gui.palworld.quest_provide_gui.button_surag"), e -> {
			if (AcceptApearProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new QuestProvideGUIButtonMessage(0, x, y, z));
				QuestProvideGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 82, 35, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = AcceptApearProcedure.execute(entity);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_surag", button_surag);
		this.addRenderableWidget(button_surag);
		button_geojeol = Button.builder(Component.translatable("gui.palworld.quest_provide_gui.button_geojeol"), e -> {
			if (AcceptApearProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new QuestProvideGUIButtonMessage(1, x, y, z));
				QuestProvideGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 82, 35, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = AcceptApearProcedure.execute(entity);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_geojeol", button_geojeol);
		this.addRenderableWidget(button_geojeol);
		button_dadgi = Button.builder(Component.translatable("gui.palworld.quest_provide_gui.button_dadgi"), e -> {
			if (QuestTapCloseButtonAppearProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new QuestProvideGUIButtonMessage(2, x, y, z));
				QuestProvideGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 82, 103, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = QuestTapCloseButtonAppearProcedure.execute(entity);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_dadgi", button_dadgi);
		this.addRenderableWidget(button_dadgi);
		button_bosanghoegdeug = Button.builder(Component.translatable("gui.palworld.quest_provide_gui.button_bosanghoegdeug"), e -> {
			if (RewardButtonAppearProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new QuestProvideGUIButtonMessage(3, x, y, z));
				QuestProvideGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 82, 103, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = RewardButtonAppearProcedure.execute(entity);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_bosanghoegdeug", button_bosanghoegdeug);
		this.addRenderableWidget(button_bosanghoegdeug);
	}
}
