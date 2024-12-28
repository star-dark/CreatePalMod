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

import net.mcreator.palworld.world.inventory.MoneyTapMenu;
import net.mcreator.palworld.procedures.BringMyMoneyProcedure;
import net.mcreator.palworld.network.MoneyTapButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MoneyTapScreen extends AbstractContainerScreen<MoneyTapMenu> {
	private final static HashMap<String, Object> guistate = MoneyTapMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_10000;
	Button button_5000;
	Button button_1000;

	public MoneyTapScreen(MoneyTapMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/money_tap.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.money_tap.label_inculganeunggeumaeg"), 24, 34, -12829636, false);
		guiGraphics.drawString(this.font,

				BringMyMoneyProcedure.execute(entity), 81, 34, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_10000 = Button.builder(Component.translatable("gui.palworld.money_tap.button_10000"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MoneyTapButtonMessage(0, x, y, z));
				MoneyTapButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 17, this.topPos + 119, 39, 20).build();
		guistate.put("button:button_10000", button_10000);
		this.addRenderableWidget(button_10000);
		button_5000 = Button.builder(Component.translatable("gui.palworld.money_tap.button_5000"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MoneyTapButtonMessage(1, x, y, z));
				MoneyTapButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 70, this.topPos + 119, 39, 20).build();
		guistate.put("button:button_5000", button_5000);
		this.addRenderableWidget(button_5000);
		button_1000 = Button.builder(Component.translatable("gui.palworld.money_tap.button_1000"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new MoneyTapButtonMessage(2, x, y, z));
				MoneyTapButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 119, 39, 20).build();
		guistate.put("button:button_1000", button_1000);
		this.addRenderableWidget(button_1000);
	}
}
