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

import net.mcreator.palworld.world.inventory.FarmerSellGuiMenu;
import net.mcreator.palworld.network.FarmerSellGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FarmerSellGuiScreen extends AbstractContainerScreen<FarmerSellGuiMenu> {
	private final static HashMap<String, Object> guistate = FarmerSellGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_cwiso;
	Button button_modu_panmae;
	Button button_modu_panmae1;
	Button button_modu_panmae2;

	public FarmerSellGuiScreen(FarmerSellGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 140;
		this.imageHeight = 150;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/farmer_sell_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_sell_gui.label_1weon"), 42, 23, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_sell_gui.label_1weon1"), 42, 53, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_sell_gui.label_1weon2"), 42, 83, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_cwiso = Button.builder(Component.translatable("gui.palworld.farmer_sell_gui.button_cwiso"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FarmerSellGuiButtonMessage(0, x, y, z));
				FarmerSellGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 51, this.topPos + 113, 35, 20).build();
		guistate.put("button:button_cwiso", button_cwiso);
		this.addRenderableWidget(button_cwiso);
		button_modu_panmae = Button.builder(Component.translatable("gui.palworld.farmer_sell_gui.button_modu_panmae"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FarmerSellGuiButtonMessage(1, x, y, z));
				FarmerSellGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 23, 36, 20).build();
		guistate.put("button:button_modu_panmae", button_modu_panmae);
		this.addRenderableWidget(button_modu_panmae);
		button_modu_panmae1 = Button.builder(Component.translatable("gui.palworld.farmer_sell_gui.button_modu_panmae1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FarmerSellGuiButtonMessage(2, x, y, z));
				FarmerSellGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 53, 36, 20).build();
		guistate.put("button:button_modu_panmae1", button_modu_panmae1);
		this.addRenderableWidget(button_modu_panmae1);
		button_modu_panmae2 = Button.builder(Component.translatable("gui.palworld.farmer_sell_gui.button_modu_panmae2"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FarmerSellGuiButtonMessage(3, x, y, z));
				FarmerSellGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 83, 36, 20).build();
		guistate.put("button:button_modu_panmae2", button_modu_panmae2);
		this.addRenderableWidget(button_modu_panmae2);
	}
}
