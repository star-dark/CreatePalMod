package net.mcreator.palworld.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.palworld.world.inventory.JobNpcSellGuiMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JobNpcSellGuiScreen extends AbstractContainerScreen<JobNpcSellGuiMenu> {
	private final static HashMap<String, Object> guistate = JobNpcSellGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_cwiso;
	Button button_panmae;
	Button button_panmae1;
	Button button_panmae2;
	Button button_panmae3;
	Button button_panmae4;
	Button button_panmae5;

	public JobNpcSellGuiScreen(JobNpcSellGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 230;
		this.imageHeight = 150;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/job_npc_sell_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.job_npc_sell_gui.label_1weon"), 44, 23, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.job_npc_sell_gui.label_1weon1"), 44, 53, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.job_npc_sell_gui.label_1weon2"), 44, 83, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.job_npc_sell_gui.label_33weon"), 152, 23, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.job_npc_sell_gui.label_33weon1"), 152, 53, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.job_npc_sell_gui.label_33weon2"), 152, 83, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_cwiso = Button.builder(Component.translatable("gui.palworld.job_npc_sell_gui.button_cwiso"), e -> {
		}).bounds(this.leftPos + 98, this.topPos + 113, 35, 20).build();
		guistate.put("button:button_cwiso", button_cwiso);
		this.addRenderableWidget(button_cwiso);
		button_panmae = Button.builder(Component.translatable("gui.palworld.job_npc_sell_gui.button_panmae"), e -> {
		}).bounds(this.leftPos + 62, this.topPos + 23, 35, 20).build();
		guistate.put("button:button_panmae", button_panmae);
		this.addRenderableWidget(button_panmae);
		button_panmae1 = Button.builder(Component.translatable("gui.palworld.job_npc_sell_gui.button_panmae1"), e -> {
		}).bounds(this.leftPos + 179, this.topPos + 23, 35, 20).build();
		guistate.put("button:button_panmae1", button_panmae1);
		this.addRenderableWidget(button_panmae1);
		button_panmae2 = Button.builder(Component.translatable("gui.palworld.job_npc_sell_gui.button_panmae2"), e -> {
		}).bounds(this.leftPos + 62, this.topPos + 53, 35, 20).build();
		guistate.put("button:button_panmae2", button_panmae2);
		this.addRenderableWidget(button_panmae2);
		button_panmae3 = Button.builder(Component.translatable("gui.palworld.job_npc_sell_gui.button_panmae3"), e -> {
		}).bounds(this.leftPos + 62, this.topPos + 83, 35, 20).build();
		guistate.put("button:button_panmae3", button_panmae3);
		this.addRenderableWidget(button_panmae3);
		button_panmae4 = Button.builder(Component.translatable("gui.palworld.job_npc_sell_gui.button_panmae4"), e -> {
		}).bounds(this.leftPos + 179, this.topPos + 53, 35, 20).build();
		guistate.put("button:button_panmae4", button_panmae4);
		this.addRenderableWidget(button_panmae4);
		button_panmae5 = Button.builder(Component.translatable("gui.palworld.job_npc_sell_gui.button_panmae5"), e -> {
		}).bounds(this.leftPos + 179, this.topPos + 83, 35, 20).build();
		guistate.put("button:button_panmae5", button_panmae5);
		this.addRenderableWidget(button_panmae5);
	}
}
