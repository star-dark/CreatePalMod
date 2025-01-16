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

import net.mcreator.palworld.world.inventory.MinerSellGuiMenu;
import net.mcreator.palworld.network.MinerSellGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MinerSellGuiScreen extends AbstractContainerScreen<MinerSellGuiMenu> {
	private final static HashMap<String, Object> guistate = MinerSellGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_panmae;
	Button button_panmae1;
	Button button_panmae2;
	Button button_panmae3;
	Button button_panmae4;
	Button button_panmae5;
	Button button_panmae6;
	Button button_cwiso;

	public MinerSellGuiScreen(MinerSellGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/miner_sell_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.miner_sell_gui.label_1weon"), 47, 15, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.miner_sell_gui.label_3weon"), 47, 41, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.miner_sell_gui.label_5weon"), 47, 66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.miner_sell_gui.label_10weon"), 47, 92, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.miner_sell_gui.label_10weon1"), 47, 117, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.miner_sell_gui.label_100weon"), 47, 143, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.miner_sell_gui.label_100weon1"), 47, 168, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_panmae = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_panmae"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(0, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 15, 35, 20).build();
		guistate.put("button:button_panmae", button_panmae);
		this.addRenderableWidget(button_panmae);
		button_panmae1 = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_panmae1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(1, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 41, 35, 20).build();
		guistate.put("button:button_panmae1", button_panmae1);
		this.addRenderableWidget(button_panmae1);
		button_panmae2 = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_panmae2"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(2, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 66, 35, 20).build();
		guistate.put("button:button_panmae2", button_panmae2);
		this.addRenderableWidget(button_panmae2);
		button_panmae3 = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_panmae3"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(3, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 92, 35, 20).build();
		guistate.put("button:button_panmae3", button_panmae3);
		this.addRenderableWidget(button_panmae3);
		button_panmae4 = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_panmae4"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(4, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 117, 35, 20).build();
		guistate.put("button:button_panmae4", button_panmae4);
		this.addRenderableWidget(button_panmae4);
		button_panmae5 = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_panmae5"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(5, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 143, 35, 20).build();
		guistate.put("button:button_panmae5", button_panmae5);
		this.addRenderableWidget(button_panmae5);
		button_panmae6 = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_panmae6"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(6, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 168, 35, 20).build();
		guistate.put("button:button_panmae6", button_panmae6);
		this.addRenderableWidget(button_panmae6);
		button_cwiso = Button.builder(Component.translatable("gui.palworld.miner_sell_gui.button_cwiso"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MinerSellGuiButtonMessage(7, x, y, z));
				MinerSellGuiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 56, this.topPos + 194, 35, 20).build();
		guistate.put("button:button_cwiso", button_cwiso);
		this.addRenderableWidget(button_cwiso);
	}
}
