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

import net.mcreator.palworld.world.inventory.JobNpcGuiMenu;
import net.mcreator.palworld.procedures.JobNpcGuiTextProcedure;
import net.mcreator.palworld.network.JobNpcGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JobNpcGuiScreen extends AbstractContainerScreen<JobNpcGuiMenu> {
	private final static HashMap<String, Object> guistate = JobNpcGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_surag;
	Button button_geojeol;

	public JobNpcGuiScreen(JobNpcGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 160;
		this.imageHeight = 80;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/job_npc_gui.png");

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
		guiGraphics.drawString(this.font,

				JobNpcGuiTextProcedure.execute(entity), 13, 17, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_surag = Button.builder(Component.translatable("gui.palworld.job_npc_gui.button_surag"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new JobNpcGuiButtonMessage(0, x, y, z));
				JobNpcGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 76, this.topPos + 48, 35, 20).build();
		guistate.put("button:button_surag", button_surag);
		this.addRenderableWidget(button_surag);
		button_geojeol = Button.builder(Component.translatable("gui.palworld.job_npc_gui.button_geojeol"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new JobNpcGuiButtonMessage(1, x, y, z));
				JobNpcGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 116, this.topPos + 48, 35, 20).build();
		guistate.put("button:button_geojeol", button_geojeol);
		this.addRenderableWidget(button_geojeol);
	}
}