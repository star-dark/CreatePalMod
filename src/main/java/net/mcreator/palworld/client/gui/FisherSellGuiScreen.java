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

import net.mcreator.palworld.world.inventory.FisherSellGuiMenu;
import net.mcreator.palworld.network.FisherSellGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FisherSellGuiScreen extends AbstractContainerScreen<FisherSellGuiMenu> {
	private final static HashMap<String, Object> guistate = FisherSellGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_panmae2;
	Button button_panmae;
	Button button_panmae1;
	Button button_panmae3;
	Button button_panmae4;
	Button button_panmae5;
	Button button_panmae6;
	Button button_panmae7;
	Button button_panmae8;
	Button button_panmae9;
	Button button_panmae10;
	Button button_panmae11;
	Button button_panmae12;
	Button button_panmae13;
	Button button_panmae14;
	Button button_panmae15;
	Button button_panmae16;
	Button button_panmae17;
	Button button_cwiso;

	public FisherSellGuiScreen(FisherSellGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 226;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/fisher_sell_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_10weon"), 33, 19, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_10weon1"), 132, 19, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_10weon2"), 231, 19, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_10weon3"), 33, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_10weon4"), 132, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_10weon5"), 231, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_10weon6"), 33, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_30weon"), 132, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_30weon1"), 231, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_30weon2"), 33, 100, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_30weon3"), 132, 100, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_50weon"), 231, 100, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_50weon1"), 33, 127, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_50weon2"), 132, 127, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_70weon"), 231, 127, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_70weon1"), 33, 154, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_70weon2"), 132, 154, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_sell_gui.label_100weon"), 231, 154, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_panmae2 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae2"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(0, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 258, this.topPos + 19, 35, 20).build();
		guistate.put("button:button_panmae2", button_panmae2);
		this.addRenderableWidget(button_panmae2);
		button_panmae = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(1, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 19, 35, 20).build();
		guistate.put("button:button_panmae", button_panmae);
		this.addRenderableWidget(button_panmae);
		button_panmae1 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(2, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 159, this.topPos + 19, 35, 20).build();
		guistate.put("button:button_panmae1", button_panmae1);
		this.addRenderableWidget(button_panmae1);
		button_panmae3 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae3"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(3, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 46, 35, 20).build();
		guistate.put("button:button_panmae3", button_panmae3);
		this.addRenderableWidget(button_panmae3);
		button_panmae4 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae4"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(4, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 159, this.topPos + 46, 35, 20).build();
		guistate.put("button:button_panmae4", button_panmae4);
		this.addRenderableWidget(button_panmae4);
		button_panmae5 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae5"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(5, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 258, this.topPos + 46, 35, 20).build();
		guistate.put("button:button_panmae5", button_panmae5);
		this.addRenderableWidget(button_panmae5);
		button_panmae6 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae6"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(6, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 73, 35, 20).build();
		guistate.put("button:button_panmae6", button_panmae6);
		this.addRenderableWidget(button_panmae6);
		button_panmae7 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae7"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(7, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 159, this.topPos + 73, 35, 20).build();
		guistate.put("button:button_panmae7", button_panmae7);
		this.addRenderableWidget(button_panmae7);
		button_panmae8 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae8"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(8, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 258, this.topPos + 73, 35, 20).build();
		guistate.put("button:button_panmae8", button_panmae8);
		this.addRenderableWidget(button_panmae8);
		button_panmae9 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae9"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(9, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 100, 35, 20).build();
		guistate.put("button:button_panmae9", button_panmae9);
		this.addRenderableWidget(button_panmae9);
		button_panmae10 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae10"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(10, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}).bounds(this.leftPos + 159, this.topPos + 100, 35, 20).build();
		guistate.put("button:button_panmae10", button_panmae10);
		this.addRenderableWidget(button_panmae10);
		button_panmae11 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae11"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(11, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}).bounds(this.leftPos + 258, this.topPos + 100, 35, 20).build();
		guistate.put("button:button_panmae11", button_panmae11);
		this.addRenderableWidget(button_panmae11);
		button_panmae12 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae12"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(12, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 127, 35, 20).build();
		guistate.put("button:button_panmae12", button_panmae12);
		this.addRenderableWidget(button_panmae12);
		button_panmae13 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae13"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(13, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		}).bounds(this.leftPos + 159, this.topPos + 127, 35, 20).build();
		guistate.put("button:button_panmae13", button_panmae13);
		this.addRenderableWidget(button_panmae13);
		button_panmae14 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae14"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(14, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		}).bounds(this.leftPos + 258, this.topPos + 127, 35, 20).build();
		guistate.put("button:button_panmae14", button_panmae14);
		this.addRenderableWidget(button_panmae14);
		button_panmae15 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae15"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(15, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 154, 35, 20).build();
		guistate.put("button:button_panmae15", button_panmae15);
		this.addRenderableWidget(button_panmae15);
		button_panmae16 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae16"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(16, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		}).bounds(this.leftPos + 159, this.topPos + 154, 35, 20).build();
		guistate.put("button:button_panmae16", button_panmae16);
		this.addRenderableWidget(button_panmae16);
		button_panmae17 = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_panmae17"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(17, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		}).bounds(this.leftPos + 258, this.topPos + 154, 35, 20).build();
		guistate.put("button:button_panmae17", button_panmae17);
		this.addRenderableWidget(button_panmae17);
		button_cwiso = Button.builder(Component.translatable("gui.palworld.fisher_sell_gui.button_cwiso"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSellGuiButtonMessage(18, x, y, z));
				FisherSellGuiButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		}).bounds(this.leftPos + 141, this.topPos + 190, 35, 20).build();
		guistate.put("button:button_cwiso", button_cwiso);
		this.addRenderableWidget(button_cwiso);
	}
}
