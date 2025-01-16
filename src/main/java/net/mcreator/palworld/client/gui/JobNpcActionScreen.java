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

import net.mcreator.palworld.world.inventory.JobNpcActionMenu;
import net.mcreator.palworld.network.JobNpcActionButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JobNpcActionScreen extends AbstractContainerScreen<JobNpcActionMenu> {
	private final static HashMap<String, Object> guistate = JobNpcActionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_gumae;
	Button button_panmae;
	Button button_cwiso;

	public JobNpcActionScreen(JobNpcActionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 70;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/job_npc_action.png");

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
	}

	@Override
	public void init() {
		super.init();
		button_gumae = Button.builder(Component.translatable("gui.palworld.job_npc_action.button_gumae"), e -> {
		}).bounds(this.leftPos + 18, this.topPos + 14, 35, 20).build();
		guistate.put("button:button_gumae", button_gumae);
		this.addRenderableWidget(button_gumae);
		button_panmae = Button.builder(Component.translatable("gui.palworld.job_npc_action.button_panmae"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new JobNpcActionButtonMessage(1, x, y, z));
				JobNpcActionButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 18, this.topPos + 39, 35, 20).build();
		guistate.put("button:button_panmae", button_panmae);
		this.addRenderableWidget(button_panmae);
		button_cwiso = Button.builder(Component.translatable("gui.palworld.job_npc_action.button_cwiso"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new JobNpcActionButtonMessage(2, x, y, z));
				JobNpcActionButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 18, this.topPos + 69, 35, 20).build();
		guistate.put("button:button_cwiso", button_cwiso);
		this.addRenderableWidget(button_cwiso);
	}
}
